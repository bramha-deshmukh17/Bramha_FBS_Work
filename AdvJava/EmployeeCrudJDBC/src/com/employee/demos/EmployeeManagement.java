package com.employee.demos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagement {

	private final Scanner sc = new Scanner(System.in);

	public void addEmployee() {
		System.out.print("Enter employee id: ");
		int id = Integer.parseInt(sc.nextLine().trim());

		System.out.print("Enter employee name: ");
		String name = sc.nextLine().trim();

		System.out.print("Enter employee salary: ");
		double salary = Double.parseDouble(sc.nextLine().trim());

		String sql = "insert into employee (empid, name, salary) values (?, ?, ?)";

		try (Connection conn = DatabaseUtility.getSQLConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, salary);

			int rows = pstmt.executeUpdate();
			System.out.println(rows + rows > 0 ? "Row inserted" : "Failed to insert");
			DatabaseUtility.releaseResources(pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchEmployee() {
		System.out.print("Enter employee id to search: ");
		int id = Integer.parseInt(sc.nextLine().trim());

		String sql = "select empid, name, salary from employee where empid = ?";

		try {
			Connection conn = DatabaseUtility.getSQLConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			} else {
				System.out.println("Employee not found for id: " + id);
			}
			DatabaseUtility.releaseResources(rs, pstmt, conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void updateEmployee() {
		System.out.print("Enter employee id to update: ");
		int id = Integer.parseInt(sc.nextLine().trim());

		System.out.print("Enter new employee name: ");
		String name = sc.nextLine().trim();

		System.out.print("Enter new employee salary: ");
		double salary = Double.parseDouble(sc.nextLine().trim());

		String sql = "update employee set name = ?, salary = ? where empid = ?";

		try {
			Connection conn = DatabaseUtility.getSQLConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setDouble(2, salary);
			pstmt.setInt(3, id);

			int rows = pstmt.executeUpdate();
			if (rows == 0) {
				System.out.println("No employee updated. Id not found: " + id);
			} else {
				System.out.println(rows + " row(s) updated.");
			}
			DatabaseUtility.releaseResources(pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee() {
		System.out.print("Enter employee id to delete: ");
		int id = Integer.parseInt(sc.nextLine().trim());

		String sql = "delete from employee where empid = ?";

		try {
			Connection conn = DatabaseUtility.getSQLConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			int rows = pstmt.executeUpdate();
			if (rows == 0) {
				System.out.println("No employee deleted. Id not found: " + id);
			} else {
				System.out.println(rows + " row deleted.");
			}
			DatabaseUtility.releaseResources(pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayAll() {
		Connection conn = DatabaseUtility.getSQLConnection();
		String query = "select *from employee;";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}

			DatabaseUtility.releaseResources(rs, pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
