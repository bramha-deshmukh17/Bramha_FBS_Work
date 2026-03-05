package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DatabaseManagement extends HttpServlet {

	Connection con;
	@Override
	public void init() throws ServletException {

		super.init();

		try {
			
			String driver = getServletConfig().getServletContext().getInitParameter("driver");
			String url = getServletConfig().getServletContext().getInitParameter("url");
			String username = getServletConfig().getServletContext().getInitParameter("username");
			String pass = getServletConfig().getServletContext().getInitParameter("password");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,pass);
			
			System.out.println("Database Connect Second Servelate !!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    resp.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = resp.getWriter();

	    HttpSession session = req.getSession(false);
	    if (session == null) {
	        resp.sendRedirect("index.html");
	        return;
	    }

	    String username = (String) session.getAttribute("username");

	    String laptop = req.getParameter("laptop");
	    String phone = req.getParameter("phone");

	    double lPrice = Double.parseDouble(req.getParameter("laptop_price"));
	    double pPrice = Double.parseDouble(req.getParameter("phone_price"));

	    double totalPrice = lPrice + pPrice;

	    try {
	        String sql = "INSERT INTO shoppingcart (laptop, phone, price) VALUES (?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, laptop);
	        ps.setString(2, phone);
	        ps.setDouble(3, totalPrice);

	        ps.executeUpdate();


	        
	        RequestDispatcher rd = req.getRequestDispatcher("/billing.html");
	        rd.forward(req, resp);
            

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
