package com.studentmanagement.model;

import java.sql.*;
import java.util.ArrayList;

public class StudentDaoJDBC implements StudentDao {

    Connection getConnection() {
        try {
            // Updated JDBC URL and parameters
            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getStudentDetails() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from students";

        try (Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = extractStudentFromResultSet(rs);
                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void addStudent(Student s) {
        String sql = "insert into students (frn, email, mobile_no, name, git_repo, dob) values (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getFrn());
            ps.setString(2, s.getEmail());
            ps.setLong(3, s.getMobileNo());
            ps.setString(4, s.getName());
            ps.setString(5, s.getGitRepo());
            ps.setDate(6, Date.valueOf(s.getDob()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> search(String field, String value) {
        ArrayList<Student> result = new ArrayList<>();

        String sql = "select * from students where " + field.toLowerCase() + " = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = extractStudentFromResultSet(rs);
                s.setMockDetails(getMockDetailsByFRN(s.getFrn()));
                result.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteStudent(String frn) {
        String sql = "delete from students where frn = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, frn);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateStudent(Student s) {
        String sql = "update students set email = ?, mobile_no = ?, name = ?, git_repo = ?, dob = ? where frn = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getEmail());
            ps.setLong(2, s.getMobileNo());
            ps.setString(3, s.getName());
            ps.setString(4, s.getGitRepo());
            ps.setDate(5, Date.valueOf(s.getDob()));
            ps.setString(6, s.getFrn());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<MockDetail> getMockDetailsByFRN(String frn) {
        ArrayList<MockDetail> details = new ArrayList<>();
        String sql = "select * from mock_details where student_frn = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, frn);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                details.add(new MockDetail(
                        rs.getString("module_name"),
                        MockStatus.valueOf(rs.getString("status")),
                        rs.getDate("mock_date").toLocalDate()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

    @Override
    public void saveMockDetails(String frn, ArrayList<MockDetail> mockDetails) {
        String updateSql = "update mock_details set status = ?, mock_date = ? where student_frn = ? and module_name = ?";
        String insertSql = "insert into mock_details (student_frn, module_name, status, mock_date) values (?, ?, ?, ?)";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement ups = con.prepareStatement(updateSql);
                    PreparedStatement ips = con.prepareStatement(insertSql)) {

                for (MockDetail detail : mockDetails) {
                    // Try to update existing record matching student and module
                    ups.setString(1, detail.getMockStatus().name());
                    ups.setDate(2, Date.valueOf(detail.getMockdate()));
                    ups.setString(3, frn);
                    ups.setString(4, detail.getModuleName());

                    int rowsAffected = ups.executeUpdate();

                    // If no record was updated, insert it as a new record
                    if (rowsAffected == 0) {
                        ips.setString(1, frn);
                        ips.setString(2, detail.getModuleName());
                        ips.setString(3, detail.getMockStatus().name());
                        ips.setDate(4, Date.valueOf(detail.getMockdate()));
                        ips.executeUpdate();
                    }
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> sort(String field, boolean ascending) {
        ArrayList<Student> result = new ArrayList<>();
        String column = field.equalsIgnoreCase("name") ? "name" : "frn";
        String order = ascending ? "asc" : "desc";
        String sql = "select * from students order by " + column + " " + order;

        try (Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = extractStudentFromResultSet(rs);
                result.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Student> getBirthdayStudents() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from students where month(dob) = month(current_date) and day(dob) = day(current_date)";
        try (Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(extractStudentFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveStudents(ArrayList<Student> students) {
        // In JDBC, data is persisted immediately.
        // We can leave this empty or use it for a bulk sync if needed.
    }

    private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
        return new Student(
                rs.getString("frn"),
                rs.getString("email"),
                rs.getLong("mobile_no"),
                rs.getString("name"),
                rs.getString("git_repo"),
                rs.getDate("dob").toLocalDate());
    }
}
