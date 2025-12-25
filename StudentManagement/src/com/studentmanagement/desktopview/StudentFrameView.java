package com.studentmanagement.desktopview;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.studentmanagement.controller.StudentManagement;
import com.studentmanagement.model.Student;
import com.studentmanagement.services.Sms;

public class StudentFrameView extends JFrame {

    public StudentManagement sm;
    public JTable studentTable;
    public DefaultTableModel tableModel;

    public StudentFrameView() {
        sm = new StudentManagement();
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table Model
        String[] columnNames = { "FRN", "Name", "Email", "Mobile", "GitHub Repo", "DOB" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        studentTable = new JTable(tableModel);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");
        JButton sortButton = new JButton("Sort");
        JButton birthdayButton = new JButton("Wish Birthday");
        JButton refreshButton = new JButton("Refresh/Display All");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(birthdayButton);
        buttonPanel.add(refreshButton);

        // Add components to frame
        add(new JScrollPane(studentTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(StudentFrameView.this, "Do you want to save changes before exiting?", "Exit",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    sm.saveStudents(sm.getStudentDetails());
                    System.exit(0);
                } else if (confirm == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });

        refreshButton.addActionListener(e -> refreshTable(sm.getStudentDetails()));

        addButton.addActionListener(e -> addStudent());

        updateButton.addActionListener(e -> updateStudent());

        deleteButton.addActionListener(e -> deleteStudent());

        searchButton.addActionListener(e -> searchStudent());

        sortButton.addActionListener(e -> sortStudents());

        birthdayButton.addActionListener(e -> wishBirthday());

        // Initial data load
        refreshTable(sm.getStudentDetails());
    }

    public void refreshTable(List<Student> students) {
        tableModel.setRowCount(0); 
        if (students != null) {
            for (Student s : students) {
                String dobStr = (s.getDob() != null) ? StudentManagement.dtf.format(s.getDob()) : "-";
                Object[] row = {
                        s.getFrn(),
                        s.getName(),
                        s.getEmail(),
                        s.getMobileNo(),
                        s.getGitRepo(),
                        dobStr
                };
                tableModel.addRow(row);
            }
        }
    }

    public void addStudent() {
        JTextField frnField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField mobileField = new JTextField();
        JTextField gitRepoField = new JTextField();
        JTextField dobField = new JTextField("dd/MM/yyyy");

        Object[] message = {
                "FRN:", frnField,
                "Name:", nameField,
                "Email:", emailField,
                "Mobile:", mobileField,
                "GitHub Repo:", gitRepoField,
                "DOB (DD/MM/YYYY):", dobField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                LocalDate dob = LocalDate.parse(dobField.getText(), StudentManagement.dtf);
                Student s = new Student(
                        frnField.getText(),
                        emailField.getText(),
                        Long.parseLong(mobileField.getText()),
                        nameField.getText(),
                        gitRepoField.getText(),
                        dob);
                sm.addStudent(s);
                refreshTable(sm.getStudentDetails());
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format! Please use DD/MM/YYYY.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid mobile number format.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void updateStudent() {
        String frn = JOptionPane.showInputDialog(this, "Enter FRN of student to update:");
        if (frn != null && !frn.trim().isEmpty()) {
            Student student = sm.searchByFrn(frn.trim());
            if (student == null) {
                JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] options = { "Update Email", "Update Mobile" };
            int choice = JOptionPane.showOptionDialog(this, "What do you want to update?", "Update Student",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) { // Update Email
                String newEmail = JOptionPane.showInputDialog(this, "Enter new email:", student.getEmail());
                if (newEmail != null) {
                    sm.updateStudentEmail(frn, newEmail);
                }
            } else if (choice == 1) { // Update Mobile
                String newMobileStr = JOptionPane.showInputDialog(this, "Enter new mobile:", student.getMobileNo());
                if (newMobileStr != null) {
                    try {
                        long newMobile = Long.parseLong(newMobileStr);
                        sm.updateStudentMobile(frn, newMobile);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid mobile number.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            refreshTable(sm.getStudentDetails());
        }
    }

    public void deleteStudent() {
        String frn = JOptionPane.showInputDialog(this, "Enter FRN of student to delete:");
        if (frn != null && !frn.trim().isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete student " + frn + "?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean deleted = sm.deleteStudent(frn.trim());
                if (deleted) {
                    JOptionPane.showMessageDialog(this, "Student deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                refreshTable(sm.getStudentDetails());
            }
        }
    }

    public void searchStudent() {
        String[] options = { "By FRN", "By Name", "By Email", "By Mobile", "By DOB" };
        int choice = JOptionPane.showOptionDialog(this, "Choose search criteria:", "Search Student",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String searchTerm = JOptionPane.showInputDialog(this, "Enter search term:");
        if (searchTerm == null || searchTerm.trim().isEmpty())
            return;

        ArrayList<Student> results = new ArrayList<>();
        switch (choice) {
            case 0:
                Student s = sm.searchByFrn(searchTerm);
                if (s != null)
                    results.add(s);
                break;
            case 1: 
                results = sm.searchByName(searchTerm);
                break;
            case 2: 
                Student sByEmail = sm.searchByEmail(searchTerm);
                if (sByEmail != null)
                    results.add(sByEmail);
                break;
            case 3: 
                try {
                    Student sByMobile = sm.searchByMobile(Long.parseLong(searchTerm));
                    if (sByMobile != null)
                        results.add(sByMobile);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid mobile number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 4: 
                results = sm.searchByDob(searchTerm);
                break;
            default:
                return;
        }
        refreshTable(results);
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students found.");
        }
    }

    public void sortStudents() {
        String[] options = { "FRN Ascending", "Name Ascending", "FRN Descending", "Name Descending" };
        int choice = JOptionPane.showOptionDialog(this, "Choose sort order:", "Sort Students",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        ArrayList<Student> sortedList = null;
        switch (choice) {
            case 0:
                sortedList = sm.sortByFrn(true);
                break;
            case 1:
                sortedList = sm.sortByName(true);
                break;
            case 2:
                sortedList = sm.sortByFrn(false);
                break;
            case 3:
                sortedList = sm.sortByName(false);
                break;
            default:
                return;
        }
        refreshTable(sortedList);
    }

    public void wishBirthday() {
        ArrayList<Student> birthdayStudents = sm.getBirthdayStudents();
        if (birthdayStudents.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No birthdays today.");
        } else {
            StringBuilder message = new StringBuilder("Wishing happy birthday to:\n");
            for (Student s : birthdayStudents) {
                message.append(s.getName()).append(" (").append(s.getFrn()).append(")\n");
                Sms.sendSms("Happy birthday " + s.getName(), s.getMobileNo());
            }
            JOptionPane.showMessageDialog(this, message.toString(), "Birthday Wishes", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}