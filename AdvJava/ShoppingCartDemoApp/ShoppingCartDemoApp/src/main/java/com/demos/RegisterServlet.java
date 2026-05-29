package com.demos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String email = request.getParameter("mail");
		
		Connection con=null;
		try {
			con = DBConnection.getSQLConnection();
			String insQuery = "INSERT INTO USER(username,password,email) VALUES(?,?,?)";
			PreparedStatement psmt = con.prepareStatement(insQuery);
			
			psmt.setString(1, username);
			psmt.setString(2, password);
			psmt.setString(3, email);
			
			int result = psmt.executeUpdate();
			if(result>0)
				response.sendRedirect("login.jsp");
			else
				response.getWriter().print("<h1>Registration Failed...</h1>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
