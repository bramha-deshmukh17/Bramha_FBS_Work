package com.controller;

import com.aspect.ObjectCreater;
import com.bean.CartItem;
import com.bean.User;
import com.services.CartService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private final CartService cartService = ObjectCreater.createObject("cartService", CartService.class);

    private Integer resolveUserId(HttpSession session) {
        // First check for userId attribute (Integer)
        Object userIdObj = session.getAttribute("userId");
        if (userIdObj instanceof Integer)
            return (Integer) userIdObj;

        // Fallback: check user attribute (User object)
        Object userObj = session.getAttribute("user");
        if (userObj instanceof User)
            return ((User) userObj).getId();

        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (cartService == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Service initialization failed");
            return;
        }

        HttpSession session = request.getSession(false);
        System.out.println("DEBUG CartServlet.doGet - Session exists: " + (session != null));
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Integer userId = resolveUserId(session);
        if (userId == null) {
            System.out.println("DEBUG CartServlet.doGet - UserId is null after resolution, invalidating session");
            // User has session but no userId - log them out
            session.invalidate();
            response.sendRedirect("login.jsp?msg=session_expired");
            return;
        }

        System.out.println("DEBUG CartServlet.doGet - UserId resolved: " + userId);

        List<CartItem> cartItems = cartService.getCartItemsByUserId(userId);

        double totalAmount = 0.0;
        for (CartItem item : cartItems) {
            totalAmount += item.getSubtotal();
        }

        request.setAttribute("cartItems", cartItems);
        request.setAttribute("totalAmount", totalAmount);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (cartService == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Service initialization failed");
            return;
        }

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Integer userId = resolveUserId(session);
        if (userId == null) {
            // User has session but no userId - log them out
            session.invalidate();
            response.sendRedirect("login.jsp?msg=session_expired");
            return;
        }

        String action = request.getParameter("action");
        action = (action == null) ? "add" : action.trim().toLowerCase();

        if ("remove".equals(action)) {
            String cartItemIdStr = request.getParameter("cartItemId");
            if (cartItemIdStr == null || cartItemIdStr.isBlank()) {
                // backward compatibility if older JSP sent productId
                cartItemIdStr = request.getParameter("productId");
            }
            if (cartItemIdStr == null || cartItemIdStr.isBlank()) {
                response.sendRedirect("cart");
                return;
            }

            int cartItemId = Integer.parseInt(cartItemIdStr);
            cartService.removeCartItem(cartItemId);
            response.sendRedirect("cart");
            return;
        }

        if ("clear".equals(action)) {
            cartService.clearCartByUserId(userId);
            response.sendRedirect("cart");
            return;
        }

        // add / buyNow require a productId
        String productIdStr = request.getParameter("productId");
        if (productIdStr == null || productIdStr.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/cart");
            return;
        }
        int productId = Integer.parseInt(productIdStr);

        int quantity = 1;
        String qtyStr = request.getParameter("quantity");
        if (qtyStr != null && !qtyStr.isBlank()) {
            quantity = Integer.parseInt(qtyStr);
            if (quantity < 1)
                quantity = 1;
        }

        if ("add".equals(action)) {
            int qty = 1;
            String q = request.getParameter("quantity");
            if (q != null && !q.isBlank())
                qty = Math.max(1, Integer.parseInt(q));

            // If item already exists in cart, increase qty; else insert new row.
            List<CartItem> items = cartService.getCartItemsByUserId(userId);
            CartItem existing = null;
            for (CartItem ci : items) {
                if (ci.getProductId() == productId) {
                    existing = ci;
                    break;
                }
            }

            if (existing != null) {
                existing.setQuantity(existing.getQuantity() + qty);
                cartService.updateCartItem(existing);
            } else {
                cartService.addCartItem(new CartItem(0, userId, productId, qty));
            }

            response.sendRedirect(request.getContextPath() + "/products");
            return;
        }

        if ("buyNow".equalsIgnoreCase(action)) {
            // keep it as POST (avoids 405 on /checkout GET)
            request.setAttribute("productId", productId);
            request.setAttribute("quantity", quantity);

            // if your CheckoutServlet is mapped to "/checkout"
            request.getRequestDispatcher("/checkout").forward(request, response);
            return;
        }

        response.sendRedirect("cart");
    }
}