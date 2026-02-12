package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void init() {

		String driverClass = getServletConfig().getServletContext().getInitParameter("driver");
		String url = getServletConfig().getServletContext().getInitParameter("url");
		String user = getServletConfig().getServletContext().getInitParameter("username");

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			out.println("Welcome to web");
			String user = request.getParameter("username");
			String pass = request.getParameter("password");

			pst = con.prepareStatement("select *from usertable where username = ? and password = ?");
			pst.setString(1, user);
			pst.setString(2, pass);

			rs = pst.executeQuery();
			RequestDispatcher rd = null;

			if (rs.next()) {
				System.out.println("Valid");
//				System.out.println(getServletConfig().getInitParameter("company"));
				// forward to servlet
				HttpSession hs = request.getSession(true);
				hs.setAttribute("user", user);
				System.out.println("Servlet 1-------------------- " + hs.getId());
				rd = request.getRequestDispatcher("gadget.html");
				rd.forward(request, response);

			} else {
				System.out.println("Invalid");
				response.setContentType("text/html");// because here we are including the html not forwarding to the
														// specified html
				// reload the html using include
				rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
				out.println("Please enter correct details....!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
