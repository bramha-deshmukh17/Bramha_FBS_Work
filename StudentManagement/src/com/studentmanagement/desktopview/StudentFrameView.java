package com.studentmanagement.desktopview;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.studentmanagement.model.MockDetail;
import com.studentmanagement.model.MockStatus;
import com.studentmanagement.model.Sms;

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
                return false; // Makes table cells non-editable
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
        JButton mockDetailsButton = new JButton("Mock Details");
        JButton updateMockButton = new JButton("Update Mock");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(birthdayButton);
        buttonPanel.add(mockDetailsButton);
        buttonPanel.add(updateMockButton);
        buttonPanel.add(refreshButton);

        add(new JScrollPane(studentTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(StudentFrameView.this,
                        "Do you want to save changes before exiting?", "Exit",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    sm.saveStudents(sm.getStudentDetails());
                    System.exit(0);
                } else if (confirm == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable(sm.getStudentDetails());
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortStudents();
            }
        });

        birthdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wishBirthday();
            }
        });

        mockDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMockDetails();
            }
        });

        updateMockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMockDetails();
            }
        });


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
        if (frn == null || frn.trim().isEmpty()) {
            return;
        }

        ArrayList<Student> list = sm.search("frn", frn.trim());
        Student existing = list.isEmpty() ? null : list.get(0);

        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTextField nameField = new JTextField(existing.getName());
        JTextField emailField = new JTextField(existing.getEmail());
        JTextField mobileField = new JTextField(String.valueOf(existing.getMobileNo()));
        JTextField gitRepoField = new JTextField(existing.getGitRepo());
        JTextField dobField = new JTextField(
                existing.getDob() != null ? StudentManagement.dtf.format(existing.getDob()) : "dd/MM/yyyy");

        Object[] message = {
                "FRN: " + existing.getFrn(),
                "Name:", nameField,
                "Email:", emailField,
                "Mobile:", mobileField,
                "GitHub Repo:", gitRepoField,
                "DOB (DD/MM/YYYY):", dobField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Update Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                LocalDate dob = LocalDate.parse(dobField.getText(), StudentManagement.dtf);
                long mobile = Long.parseLong(mobileField.getText());

                Student updated = new Student(
                        existing.getFrn(),
                        emailField.getText(),
                        mobile,
                        nameField.getText(),
                        gitRepoField.getText(),
                        dob);

                sm.updateStudent(updated);
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
                results = sm.search("frn", searchTerm);
                break;
            case 1:
                results = sm.search("name", searchTerm);
                break;
            case 2:
                results = sm.search("email", searchTerm);
                break;
            case 3:
                try {
                    Long.parseLong(searchTerm);
                    results = sm.search("mobile", searchTerm);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid mobile number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 4:
                results = sm.search("dob", searchTerm);
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
                sortedList = sm.sort("frn", true);
                break;
            case 1:
                sortedList = sm.sort("name", true);
                break;
            case 2:
                sortedList = sm.sort("frn", false);
                break;
            case 3:
                sortedList = sm.sort("name", false);
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

    public void showMockDetails() {
        String frn;

        frn = JOptionPane.showInputDialog(this, "Enter FRN of student to view mock details:");
        if (frn == null || frn.trim().isEmpty()) {
            return;
        }
        frn = frn.trim();

        ArrayList<MockDetail> mocks = sm.getMockDetailsByFRN(frn);
        if (mocks == null || mocks.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No mock details found for FRN: " + frn);
            return;
        }

        StringBuilder sb = new StringBuilder("Mock details for FRN ").append(frn).append(":\n\n");
        for (MockDetail md : mocks) {
            String dateStr = (md.getMockdate() != null)
                    ? StudentManagement.dtf.format(md.getMockdate())
                    : "-";
            sb.append("Module: ").append(md.getModuleName())
                    .append("\nStatus: ").append(md.getMockStatus())
                    .append("\nDate: ").append(dateStr)
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Mock Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateMockDetails() {
        String frn = JOptionPane.showInputDialog(this, "Enter FRN of student to update mock details:");
        if (frn == null || frn.trim().isEmpty()) {
            return;
        }
        frn = frn.trim();

        String moduleName = JOptionPane.showInputDialog(this, "Enter module name to add/update:");
        if (moduleName == null || moduleName.trim().isEmpty()) {
            return;
        }
        moduleName = moduleName.trim();

        String[] statusOptions = { "CLEAR", "NOT_CLEAR", "ABSENT" };
        String status = (String) JOptionPane.showInputDialog(
                this,
                "Select mock status:",
                "Mock Status",
                JOptionPane.QUESTION_MESSAGE,
                null,
                statusOptions,
                statusOptions[0]);
        if (status == null) {
            return;
        }

        MockStatus mockStatus;
        try {
            mockStatus = MockStatus.valueOf(status);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Invalid mock status selected.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate mockDate = LocalDate.now();
        ArrayList<MockDetail> mocks = sm.getMockDetailsByFRN(frn);
        if (mocks == null) {
            mocks = new ArrayList<>();
        }

        MockDetail target = null;
        for (MockDetail md : mocks) {
            if (md.getModuleName() != null && md.getModuleName().equalsIgnoreCase(moduleName)) {
                target = md;
                break;
            }
        }

        if (target == null) {
            target = new MockDetail(moduleName, mockStatus, mockDate);
            mocks.add(target);
            JOptionPane.showMessageDialog(this, "Mock detail added for student.");
        } else {
            if (target.getMockStatus() != MockStatus.CLEAR) {
                target.setModuleName(moduleName);
                target.setMockStatus(mockStatus);
                target.setMockdate(mockDate);
                JOptionPane.showMessageDialog(this, "Mock detail updated for student.");
            } else {
                JOptionPane.showMessageDialog(this, "Mock already cleared!", "Info",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        sm.saveMockDetails(frn, mocks);
    }
}