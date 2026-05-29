package com.demos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/validation")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("html/text");
		try {
			Connection con = DBConnection.getSQLConnection();
			String query = "SELECT * FROM usertable WHERE username=? AND password=?";
			PreparedStatement psmt = con.prepareStatement(query);
			
			psmt.setString(1, username);
			psmt.setString(2, password);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				HttpSession ses = request.getSession();
				ses.setAttribute("user", username);
				
				response.sendRedirect("products");
			} else {
				response.getWriter().print("<h2>INVALID CREDENTIALS... Please Try again ...</h2>");
				response.getWriter().print("<a href='login.jsp'>Back to login page</a>");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
