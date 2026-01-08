package com.studentmanagement.model;

import java.sql.*;
import java.util.ArrayList;

public class StudentDaoJDBC implements StudentDao {

    Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "http://localhost/phpmyadmin/index.php?route=/database/structure&db=student";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getStudentDetails() {
        Connection con = getConnection();
        if (con == null) {
            System.err.println(
                    "Database connection failed. Ensure MySQL driver is on the module path and DB is reachable.");
            return new ArrayList<>();
        }
        ArrayList<Student> students = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student student = new Student(rs.getString("frn"),
                        rs.getString("email"),
                        rs.getLong("mobile_no"),
                        rs.getString("name"),
                        rs.getString("git_repo"),
                        rs.getDate("dob").toLocalDate());

                students.add(student);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void addStudent(Student s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStudent'");
    }

    @Override
    public ArrayList<Student> search(String field, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public boolean deleteStudent(String frn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }

    @Override
    public void saveStudents(ArrayList<Student> students) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveStudents'");
    }

    @Override
    public void updateStudent(Student students) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStudent'");
    }

    @Override
    public ArrayList<MockDetail> getMockDetailsByFRN(String frn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMockDetailsByFRN'");
    }

    @Override
    public void saveMockDetails(String frn, ArrayList<MockDetail> mockDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveMockDetails'");
    }

    @Override
    public ArrayList<Student> sort(String field, boolean ascending) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

    @Override
    public ArrayList<Student> getBirthdayStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBirthdayStudents'");
    }

}
