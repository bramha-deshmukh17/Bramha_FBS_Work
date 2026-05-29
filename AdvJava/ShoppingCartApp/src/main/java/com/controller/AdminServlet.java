package com.controller;

import com.aspect.ObjectCreater;
import com.bean.User;
import com.bean.Product;
import com.bean.Order;
import com.services.UserService;
import com.services.OrderService;
import com.services.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@WebServlet("/admin")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 10 * 1024 * 1024, maxRequestSize = 20 * 1024 * 1024)
public class AdminServlet extends HttpServlet {
    private final UserService userService = ObjectCreater.createObject("userService", UserService.class);
    private final OrderService orderService = ObjectCreater.createObject("orderService", OrderService.class);
    private final ProductService productService = ObjectCreater.createObject("productService", ProductService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (userService == null || orderService == null || productService == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Service initialization failed");
            return;
        }
        
        String action = request.getParameter("action");

        if ("logout".equals(action)) {
            response.sendRedirect("logout");
            return;
        }

        HttpSession session = request.getSession(false);
        User loggedInUser = (session == null) ? null : (User) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        if (loggedInUser.getRole() == null || !"admin".equals(loggedInUser.getRole())) {
            response.sendRedirect("productList.jsp");
            return;
        }

        if ("users".equals(action)) {
            request.setAttribute("users", userService.getAllUsers());
            request.getRequestDispatcher("adminUsers.jsp").forward(request, response);
        } else if ("orders".equals(action)) {
            request.setAttribute("orders", orderService.getAllOrders());
            request.getRequestDispatcher("adminOrders.jsp").forward(request, response);
        } else if ("products".equals(action)) {
            request.setAttribute("products", productService.getAllProducts());
            request.getRequestDispatcher("adminProducts.jsp").forward(request, response);
        } else if ("newProduct".equals(action)) {
            request.setAttribute("mode", "add");
            request.getRequestDispatcher("adminProductForm.jsp").forward(request, response);
        } else if ("editProduct".equals(action)) {
            int productId = parseIntOrDefault(request.getParameter("id"), -1);
            if (productId <= 0) {
                response.sendRedirect("admin?action=products&msg=invalid_product");
                return;
            }
            Product product = productService.getProductById(productId);
            if (product == null) {
                response.sendRedirect("admin?action=products&msg=product_not_found");
                return;
            }
            request.setAttribute("mode", "edit");
            request.setAttribute("product", product);
            request.getRequestDispatcher("adminProductForm.jsp").forward(request, response);
        } else {
            response.sendRedirect("adminDashboard.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (userService == null || orderService == null || productService == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Service initialization failed");
            return;
        }
        
        String action = request.getParameter("action");

        HttpSession session = request.getSession(false);
        User loggedInUser = (session == null) ? null : (User) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        if (loggedInUser.getRole() == null || !"admin".equals(loggedInUser.getRole())) {
            response.sendRedirect("productList.jsp");
            return;
        }

        if ("deleteUser".equals(action)) {
            handleDeleteUser(request, response, loggedInUser);
        } else if ("addProduct".equals(action)) {
            handleAddProduct(request, response);
        } else if ("updateProduct".equals(action)) {
            handleUpdateProduct(request, response);
        } else if ("deleteProduct".equals(action)) {
            handleDeleteProduct(request, response);
        } else if ("updateOrderStatus".equals(action)) {
            handleUpdateOrderStatus(request, response);
        } else {
            response.sendRedirect("adminDashboard.jsp");
        }
    }

    private void handleDeleteUser(HttpServletRequest request, HttpServletResponse response, User loggedInUser)
            throws IOException {
        int userId = parseIntOrDefault(request.getParameter("id"), -1);
        if (userId <= 0) {
            response.sendRedirect("admin?action=users&msg=invalid_user");
            return;
        }
        if (userId == loggedInUser.getId()) {
            response.sendRedirect("admin?action=users&msg=cannot_delete_self");
            return;
        }

        User userToDelete = userService.getUserById(userId);
        if (userToDelete != null && "admin".equals(userToDelete.getRole())) {
            response.sendRedirect("admin?action=users&msg=cannot_delete_admin");
            return;
        }

        boolean deleted = userService.deleteUser(userId);
        response.sendRedirect("admin?action=users&msg=" + (deleted ? "user_deleted" : "user_delete_failed"));
    }

    private void handleAddProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Product product = new Product();
        product.setName(trimOrNull(request.getParameter("name")));
        product.setDescription(trimOrNull(request.getParameter("description")));
        product.setCategory(trimOrNull(request.getParameter("category")));
        product.setPrice(parseDoubleOrDefault(request.getParameter("price"), -1));
        product.setQuantity(parseIntOrDefault(request.getParameter("quantity"), -1));

        String imageUrl = saveUploadedImageIfPresent(request, null);
        product.setImageUrl(imageUrl != null ? imageUrl : "uploads/default-product.png");

        if (!isValidProduct(product)) {
            response.sendRedirect("admin?action=newProduct&msg=invalid_input");
            return;
        }

        boolean added = productService.addProduct(product);
        response.sendRedirect("admin?action=products&msg=" + (added ? "product_added" : "product_add_failed"));
    }

    private void handleUpdateProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int productId = parseIntOrDefault(request.getParameter("id"), -1);
        if (productId <= 0) {
            response.sendRedirect("admin?action=products&msg=invalid_product");
            return;
        }

        Product existing = productService.getProductById(productId);
        if (existing == null) {
            response.sendRedirect("admin?action=products&msg=product_not_found");
            return;
        }

        existing.setName(trimOrNull(request.getParameter("name")));
        existing.setDescription(trimOrNull(request.getParameter("description")));
        existing.setCategory(trimOrNull(request.getParameter("category")));
        existing.setPrice(parseDoubleOrDefault(request.getParameter("price"), -1));
        existing.setQuantity(parseIntOrDefault(request.getParameter("quantity"), -1));

        String imageUrl = saveUploadedImageIfPresent(request, existing.getImageUrl());
        if (imageUrl != null) {
            existing.setImageUrl(imageUrl);
        }

        if (!isValidProduct(existing)) {
            response.sendRedirect("admin?action=editProduct&id=" + productId + "&msg=invalid_input");
            return;
        }

        boolean updated = productService.updateProduct(existing);
        response.sendRedirect("admin?action=products&msg=" + (updated ? "product_updated" : "product_update_failed"));
    }

    private void handleDeleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int productId = parseIntOrDefault(request.getParameter("id"), -1);
        if (productId <= 0) {
            response.sendRedirect("admin?action=products&msg=invalid_product");
            return;
        }
        boolean deleted = productService.deleteProduct(productId);
        response.sendRedirect("admin?action=products&msg=" + (deleted ? "product_deleted" : "product_delete_failed"));
    }

    private void handleUpdateOrderStatus(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int orderId = parseIntOrDefault(request.getParameter("id"), -1);
        String newStatus = trimOrNull(request.getParameter("status"));
        if (orderId <= 0 || newStatus == null) {
            response.sendRedirect("admin?action=orders&msg=invalid_order");
            return;
        }

        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            response.sendRedirect("admin?action=orders&msg=order_not_found");
            return;
        }

        String currentStatus = normalizeStatus(order.getStatus());
        String targetStatus = normalizeStatus(newStatus);
        if (!isAllowedStatusTransition(currentStatus, targetStatus)) {
            response.sendRedirect("admin?action=orders&msg=invalid_transition");
            return;
        }

        boolean ok = orderService.updateOrderStatus(orderId, targetStatus);
        response.sendRedirect("admin?action=orders&msg=" + (ok ? "status_updated" : "status_update_failed"));
    }

    private String saveUploadedImageIfPresent(HttpServletRequest request, String fallbackUrl)
            throws IOException, ServletException {
        Part imagePart;
        try {
            imagePart = request.getPart("image");
        } catch (IllegalStateException ex) {
            getServletContext().log("Image upload rejected (request too large).", ex);
            return null;
        }

        if (imagePart == null || imagePart.getSize() <= 0) {
            return null;
        }

        String submitted = Paths.get(Objects.toString(imagePart.getSubmittedFileName(), "")).getFileName().toString();
        if (submitted.isBlank()) {
            return null;
        }

        getServletContext().log("Image upload received: name='" + submitted + "', size=" + imagePart.getSize());

        String ext = "";
        int idx = submitted.lastIndexOf('.');
        if (idx >= 0 && idx < submitted.length() - 1) {
            ext = submitted.substring(idx).toLowerCase();
        }
        if (!isAllowedImageExtension(ext)) {
            getServletContext().log("Image upload rejected (extension not allowed): " + ext);
            return null;
        }

        String uploadsRealPath = getServletContext().getRealPath("/uploads");
        getServletContext().log("Resolved /uploads real path: " + uploadsRealPath);
        if (uploadsRealPath == null || uploadsRealPath.isBlank()) {
            getServletContext().log("Cannot resolve real path for /uploads; falling back to existing image URL.");
            return fallbackUrl;
        }

        Path uploadsDir = Path.of(uploadsRealPath);
        Files.createDirectories(uploadsDir);

        String safeName = ("p_" + System.currentTimeMillis() + ext);
        Path dest = uploadsDir.resolve(safeName);

        try (var in = imagePart.getInputStream()) {
            Files.copy(in, dest, StandardCopyOption.REPLACE_EXISTING);
        }

        getServletContext().log("Image upload saved to: " + dest.toAbsolutePath());
        return "uploads/" + safeName;
    }

    private boolean isAllowedImageExtension(String ext) {
        return ".png".equals(ext) || ".jpg".equals(ext) || ".jpeg".equals(ext) || ".gif".equals(ext)
                || ".webp".equals(ext);
    }

    private boolean isValidProduct(Product product) {
        return product.getName() != null
                && product.getDescription() != null
                && product.getCategory() != null
                && product.getPrice() >= 0
                && product.getQuantity() >= 0;
    }

    private String nextStatus(String current) {
        current = normalizeStatus(current);
        if ("Order Placed".equals(current))
            return "Shipped";
        if ("Shipped".equals(current))
            return "Out For Delivery";
        if ("Out For Delivery".equals(current))
            return "Delivered";
        return null;
    }

    private boolean isAllowedStatusTransition(String current, String target) {
        current = normalizeStatus(current);
        target = normalizeStatus(target);
        if (current.equals(target)) {
            return true;
        }
        String next = nextStatus(current);
        return next != null && next.equals(target);
    }

    private String normalizeStatus(String status) {
        if (status == null)
            return "Order Placed";
        status = status.trim();
        if (status.equalsIgnoreCase("pending"))
            return "Order Placed";
        if (status.equalsIgnoreCase("order placed"))
            return "Order Placed";
        if (status.equalsIgnoreCase("shipped"))
            return "Shipped";
        if (status.equalsIgnoreCase("outfor delyvery") || status.equalsIgnoreCase("out for delyvery")
                || status.equalsIgnoreCase("outfordelivery") || status.equalsIgnoreCase("out for delivery")) {
            return "Out For Delivery";
        }
        if (status.equalsIgnoreCase("deliverd") || status.equalsIgnoreCase("delivered"))
            return "Delivered";
        return status;
    }

    private int parseIntOrDefault(String value, int defaultValue) {
        try {
            return Integer.parseInt(Objects.toString(value, "").trim());
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    private double parseDoubleOrDefault(String value, double defaultValue) {
        try {
            return Double.parseDouble(Objects.toString(value, "").trim());
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    private String trimOrNull(String value) {
        if (value == null)
            return null;
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
}