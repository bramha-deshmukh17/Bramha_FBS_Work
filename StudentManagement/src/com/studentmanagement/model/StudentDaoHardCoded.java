package com.studentmanagement.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class StudentDaoHardCoded implements StudentDao {

    static String FILE_PATH = System.getProperty("user.home") + "/studentdata.txt";
    static ArrayList<Student> students = new ArrayList<Student>();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static {
        Student s1 = new Student("FRN001", "amit.sharma@gmail.com", 9876543210L, "Amit Sharma",
                "https://github.com/amitsharma", LocalDate.of(2000, 1, 15));
        s1.getMockDetails().add(new MockDetail("Core Java", MockStatus.CLEAR, LocalDate.of(2024, 1, 10)));
        s1.getMockDetails().add(new MockDetail("SQL", MockStatus.NOT_CLEAR, LocalDate.of(2024, 2, 5)));
        s1.getMockDetails().add(new MockDetail("Spring", MockStatus.ABSENT, LocalDate.of(2024, 3, 1)));
        students.add(s1);

        Student s2 = new Student("FRN002", "priya.patel@gmail.com", 9898989898L, "Priya Patel",
                "https://github.com/priyapatel", LocalDate.of(1999, 5, 22));
        s2.getMockDetails().add(new MockDetail("Core Java", MockStatus.NOT_CLEAR, LocalDate.of(2024, 1, 12)));
        s2.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 2, 8)));
        s2.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 3, 3)));
        students.add(s2);

        Student s3 = new Student("FRN003", "rohit.verma@gmail.com", 9123456789L, "Rohit Verma",
                "https://github.com/rohitverma", LocalDate.of(2001, 3, 10));
        s3.getMockDetails().add(new MockDetail("Core Java", MockStatus.ABSENT, LocalDate.of(2024, 1, 14)));
        s3.getMockDetails().add(new MockDetail("SQL", MockStatus.NOT_CLEAR, LocalDate.of(2024, 2, 10)));
        s3.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 3, 7)));
        students.add(s3);

        Student s4 = new Student("FRN004", "neha.joshi@gmail.com", 9988776655L, "Neha Joshi",
                "https://github.com/nehajoshi", LocalDate.of(2000, 11, 2));
        s4.getMockDetails().add(new MockDetail("Core Java", MockStatus.CLEAR, LocalDate.of(2024, 1, 16)));
        s4.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 2, 12)));
        s4.getMockDetails().add(new MockDetail("Spring", MockStatus.NOT_CLEAR, LocalDate.of(2024, 3, 9)));
        students.add(s4);

        Student s5 = new Student("FRN005", "sachin.kale@gmail.com", 9090909090L, "Sachin Kale",
                "https://github.com/sachinkale", LocalDate.of(1998, 12, 19));
        s5.getMockDetails().add(new MockDetail("Core Java", MockStatus.NOT_CLEAR, LocalDate.of(2024, 1, 18)));
        s5.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 2, 14)));
        s5.getMockDetails().add(new MockDetail("Spring", MockStatus.ABSENT, LocalDate.of(2024, 3, 11)));
        students.add(s5);

        Student s6 = new Student("FRN006", "pooja.nair@gmail.com", 9765432109L, "Pooja Nair",
                "https://github.com/poojanair", LocalDate.of(2001, 12, 19));
        s6.getMockDetails().add(new MockDetail("Core Java", MockStatus.CLEAR, LocalDate.of(2024, 1, 20)));
        s6.getMockDetails().add(new MockDetail("SQL", MockStatus.ABSENT, LocalDate.of(2024, 2, 16)));
        s6.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 3, 13)));
        students.add(s6);

        Student s7 = new Student("FRN007", "vikas.singh@gmail.com", 9345678901L, "Vikas Singh",
                "https://github.com/vikassingh", LocalDate.of(1999, 9, 14));
        s7.getMockDetails().add(new MockDetail("Core Java", MockStatus.CLEAR, LocalDate.of(2024, 1, 22)));
        s7.getMockDetails().add(new MockDetail("SQL", MockStatus.NOT_CLEAR, LocalDate.of(2024, 2, 18)));
        s7.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 3, 15)));
        students.add(s7);

        Student s8 = new Student("FRN008", "kiran.mane@gmail.com", 9887766554L, "Kiran Mane",
                "https://github.com/kiranmane", LocalDate.of(2000, 4, 8));
        s8.getMockDetails().add(new MockDetail("Core Java", MockStatus.ABSENT, LocalDate.of(2024, 1, 24)));
        s8.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 2, 20)));
        s8.getMockDetails().add(new MockDetail("Spring", MockStatus.NOT_CLEAR, LocalDate.of(2024, 3, 17)));
        students.add(s8);

        Student s9 = new Student("FRN009", "anita.desai@gmail.com", 9012345678L, "Anita Desai",
                "https://github.com/anitadesai", LocalDate.of(1999, 9, 14));
        s9.getMockDetails().add(new MockDetail("Core Java", MockStatus.CLEAR, LocalDate.of(2024, 1, 26)));
        s9.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 2, 22)));
        s9.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 3, 19)));
        students.add(s9);

        Student s10 = new Student("FRN010", "rahul.mehta@gmail.com", 9998887776L, "Rahul Mehta",
                "https://github.com/rahulmehta", LocalDate.of(2001, 6, 30));
        s10.getMockDetails().add(new MockDetail("Core Java", MockStatus.NOT_CLEAR, LocalDate.of(2024, 1, 28)));
        s10.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 2, 24)));
        s10.getMockDetails().add(new MockDetail("Spring", MockStatus.ABSENT, LocalDate.of(2024, 3, 21)));
        students.add(s10);

        Student s11 = new Student("FRN021", "sonal.jain@gmail.com", 9876123456L, "Sonal Jain",
                "https://github.com/sonaljain", LocalDate.of(1999, 9, 14));
        s11.getMockDetails().add(new MockDetail("Core Java", MockStatus.CLEAR, LocalDate.of(2024, 1, 30)));
        s11.getMockDetails().add(new MockDetail("SQL", MockStatus.NOT_CLEAR, LocalDate.of(2024, 2, 26)));
        s11.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 3, 23)));
        students.add(s11);

        Student s12 = new Student("FRN012", "deepak.pawar@gmail.com", 9753124680L, "Deepak Pawar",
                "https://github.com/deepakpawar", LocalDate.of(2000, 8, 5));
        s12.getMockDetails().add(new MockDetail("Core Java", MockStatus.ABSENT, LocalDate.of(2024, 2, 1)));
        s12.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 3, 1)));
        s12.getMockDetails().add(new MockDetail("Spring", MockStatus.NOT_CLEAR, LocalDate.of(2024, 4, 1)));
        students.add(s12);

        Student s13 = new Student("FRN013", "mehul.gupta@gmail.com", 9647382910L, "Mehul Gupta",
                "https://github.com/mehulgupta", LocalDate.of(1998, 12, 1));
        s13.getMockDetails().add(new MockDetail("Core Java", MockStatus.CLEAR, LocalDate.of(2024, 2, 3)));
        s13.getMockDetails().add(new MockDetail("SQL", MockStatus.CLEAR, LocalDate.of(2024, 3, 3)));
        s13.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 4, 3)));
        students.add(s13);

        Student s14 = new Student("FRN014", "sneha.kulkarni@gmail.com", 9823012345L, "Sneha Kulkarni",
                "https://github.com/snehakulkarni", LocalDate.of(2001, 1, 18));
        s14.getMockDetails().add(new MockDetail("Core Java", MockStatus.NOT_CLEAR, LocalDate.of(2024, 2, 5)));
        s14.getMockDetails().add(new MockDetail("SQL", MockStatus.ABSENT, LocalDate.of(2024, 3, 5)));
        s14.getMockDetails().add(new MockDetail("Spring", MockStatus.CLEAR, LocalDate.of(2024, 4, 5)));
        students.add(s14);
    }

    public ArrayList<Student> getAllStudents() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Object obj = objectInputStream.readObject();
            if (obj instanceof ArrayList) {
                students = (ArrayList<Student>) obj;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Student data file not found. Using in-memory default data.");
        } catch (ClassNotFoundException e) {
            System.out.println("Stored student data is incompatible with current version.");
        } catch (IOException e) {
            System.out.println("Error reading student data file: " + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Student data file has unexpected format.");
        }

        return students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public ArrayList<Student> getStudentDetails() {
        return StudentDaoFile.students;
    }

    public ArrayList<Student> search(String field, String value) {
        ArrayList<Student> result = new ArrayList<>();
        if (field == null || value == null) {
            return result;
        }

        String f = field.trim().toLowerCase();
        String v = value.trim();

        switch (f) {
            case "frn":
                for (Student s : students) {
                    if (s.getFrn().equals(v)) {
                        result.add(s);
                    }
                }
                break;
            case "email":
                for (Student s : students) {
                    if (s.getEmail().equals(v)) {
                        result.add(s);
                    }
                }
                break;
            case "mobile":
                try {
                    long mobileNo = Long.parseLong(v);
                    for (Student s : students) {
                        if (s.getMobileNo() == mobileNo) {
                            result.add(s);
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number");
                }
                break;
            case "name":
                for (Student s : students) {
                    if (s.getName().equalsIgnoreCase(v)) {
                        result.add(s);
                    }
                }
                break;
            case "dob":
                LocalDate date;
                try {
                    date = LocalDate.parse(v, dtf);
                } catch (DateTimeException e) {
                    return result;
                }
                for (Student s : students) {
                    if (s.getDob() != null && s.getDob().equals(date)) {
                        result.add(s);
                    }
                }
                break;
            default:
                System.out.println("Unsupported search field: " + field);
        }

        return result;
    }

    public boolean deleteStudent(String frn) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFrn().equals(frn)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public void updateStudent(Student updatedStudent) {
        if (updatedStudent == null || updatedStudent.getFrn() == null) {
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFrn().equals(updatedStudent.getFrn())) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    public ArrayList<MockDetail> getMockDetailsByFRN(String frn) {

        for (Student s : students) {
            if (s.getName().equals(frn))
                return s.getMockDetails();
        }
        return null;
    }

    public void saveMockDetails(String frn, ArrayList<MockDetail> mockDetails) {
        if (frn == null || mockDetails == null)
            return;
        for (Student s : students) {
            if (frn.equalsIgnoreCase(s.getFrn())) {
                s.setMockDetails(mockDetails);
                break;
            }
        }
    }

    public void saveStudents(ArrayList<Student> students) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(students);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to create/open student data file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing student data file: " + e.getMessage());
        }
    }

    public ArrayList<Student> sort(String field, boolean ascending) {
        ArrayList<Student> sorted = new ArrayList<>(students);
        String f = field == null ? "" : field.trim().toLowerCase();
        switch (f) {
            case "frn":
                Collections.sort(sorted, new FRNComparator(ascending));
                break;
            case "name":
                Collections.sort(sorted, new NameComparator(ascending));
                break;
            default:
                System.out.println("Unsupported sort field: " + field);
        }
        return sorted;
    }

    public ArrayList<Student> getBirthdayStudents() {
        ArrayList<Student> birthdayStudents = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Student s : students) {
            if (s.getDob().getDayOfMonth() == today.getDayOfMonth() &&
                    s.getDob().getMonth() == today.getMonth()) {
                birthdayStudents.add(s);
            }
        }
        return birthdayStudents;
    }

    @Override
    public String addOrUpdateMockDetail(String frn, String moduleName, String statusInput) {
        if (frn == null || frn.trim().isEmpty())
            return "FRN is required.";
        if (moduleName == null || moduleName.trim().isEmpty())
            return "Module name is required.";
        if (statusInput == null || statusInput.trim().isEmpty())
            return "Mock status is required.";

        String frnTrim = frn.trim();
        String moduleTrim = moduleName.trim();

        ArrayList<Student> found = search("frn", frnTrim);
        if (found == null || found.isEmpty())
            return "Student with " + frnTrim + " not found";

        MockStatus mockStatus;
        try {
            mockStatus = MockStatus.valueOf(statusInput.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return "Invalid mock status. Use CLEAR / NOT_CLEAR / ABSENT.";
        }

        ArrayList<MockDetail> existingMocks = getMockDetailsByFRN(frnTrim);
        if (existingMocks == null)
            existingMocks = new ArrayList<>();

        MockDetail target = null;
        for (MockDetail md : existingMocks) {
            if (md != null && md.getModuleName() != null && md.getModuleName().equalsIgnoreCase(moduleTrim)) {
                target = md;
                break;
            }
        }

        LocalDate mockDate = LocalDate.now();

        if (target == null) {
            existingMocks.add(new MockDetail(moduleTrim, mockStatus, mockDate));
            saveMockDetails(frnTrim, existingMocks);
            return "Mock detail added for student.";
        }

        if (target.getMockStatus() == MockStatus.CLEAR) {
            return "Mock already cleared!";
        }

        target.setModuleName(moduleTrim);
        target.setMockStatus(mockStatus);
        target.setMockdate(mockDate);

        saveMockDetails(frnTrim, existingMocks);
        return "Mock detail updated for student.";
    }

}
