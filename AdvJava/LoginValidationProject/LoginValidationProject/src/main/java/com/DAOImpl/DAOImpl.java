package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.DAOInterface;
import com.bean.userPojo;

public class DAOImpl implements DAOInterface {

	Connection con = null;
	int UpdateRow = 0;
	ResultSet rs = null;

	
	public DAOImpl() {

	}

	@Override
	public int InsertData(userPojo u) {

		String Query = "INSERT INTO UserLoginTable (username, password, SecurityQuestion, SecurityAnswer) VALUES (?,?,?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, u.getUserName());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getSecurityQuestion());
			pst.setString(4, u.getAnswer());

			UpdateRow = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return UpdateRow;
	}

	@Override
	public boolean RetriveData(String username) {

		boolean flag = false;

		String Query = "SELECT * FROM UserLoginTable WHERE username = ?";

		try {
			PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, username);

			rs = pst.executeQuery();

			flag = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public String UpdatePassword(userPojo u) {

		String message = "Password Not Updated";

		String Query = "UPDATE UserLoginTable SET password = ? WHERE username = ?";

		try {
			PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, u.getPassword());
			pst.setString(2, u.getUserName());

			int row = pst.executeUpdate();

			if (row > 0) {
				message = "Password Updated Successfully";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return message;
	}

	@Override
	public boolean DeleteData(userPojo u) {

		boolean flag = false;

		String Query = "DELETE FROM UserLoginTable WHERE username = ?";

		try {
			PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, u.getUserName());

			int row = pst.executeUpdate();

			if (row > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
}
