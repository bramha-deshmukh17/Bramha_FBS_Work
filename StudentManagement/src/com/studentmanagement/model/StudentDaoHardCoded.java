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
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

import com.studentmanagement.services.comparator.FRNComparator;
import com.studentmanagement.services.comparator.NameComparator;

public class StudentDaoHardCoded implements StudentDao {

    static String FILE_PATH = System.getProperty("user.home") + "/studentdata.txt";
    static ArrayList<Student> students = new ArrayList<Student>();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static {

        students.add(new Student("FRN001", "amit.sharma@gmail.com", 9876543210L, "Amit Sharma",
                "https://github.com/amitsharma", LocalDate.of(2000, 1, 15)));
        students.add(new Student("FRN002", "priya.patel@gmail.com", 9898989898L, "Priya Patel",
                "https://github.com/priyapatel", LocalDate.of(1999, 5, 22)));
        students.add(new Student("FRN003", "rohit.verma@gmail.com", 9123456789L, "Rohit Verma",
                "https://github.com/rohitverma", LocalDate.of(2001, 3, 10)));
        students.add(new Student("FRN004", "neha.joshi@gmail.com", 9988776655L, "Neha Joshi",
                "https://github.com/nehajoshi", LocalDate.of(2000, 11, 2)));
        students.add(new Student("FRN005", "sachin.kale@gmail.com", 9090909090L, "Sachin Kale",
                "https://github.com/sachinkale", LocalDate.of(1998, 12, 19)));

        students.add(new Student("FRN006", "pooja.nair@gmail.com", 9765432109L, "Pooja Nair",
                "https://github.com/poojanair", LocalDate.of(2001, 12, 19)));
        students.add(new Student("FRN007", "vikas.singh@gmail.com", 9345678901L, "Vikas Singh",
                "https://github.com/vikassingh", LocalDate.of(1999, 9, 14)));
        students.add(new Student("FRN008", "kiran.mane@gmail.com", 9887766554L, "Kiran Mane",
                "https://github.com/kiranmane", LocalDate.of(2000, 4, 8)));
        students.add(new Student("FRN009", "anita.desai@gmail.com", 9012345678L, "Anita Desai",
                "https://github.com/anitadesai", LocalDate.of(1999, 9, 14)));
        students.add(new Student("FRN010", "rahul.mehta@gmail.com", 9998887776L, "Rahul Mehta",
                "https://github.com/rahulmehta", LocalDate.of(2001, 6, 30)));

        students.add(new Student("FRN021", "sonal.jain@gmail.com", 9876123456L, "Sonal Jain",
                "https://github.com/sonaljain", LocalDate.of(1999, 9, 14)));
        students.add(new Student("FRN012", "deepak.pawar@gmail.com", 9753124680L, "Deepak Pawar",
                "https://github.com/deepakpawar", LocalDate.of(2000, 8, 5)));
        students.add(new Student("FRN013", "mehul.gupta@gmail.com", 9647382910L, "Mehul Gupta",
                "https://github.com/mehulgupta", LocalDate.of(1998, 12, 1)));
        students.add(new Student("FRN014", "sneha.kulkarni@gmail.com", 9823012345L, "Sneha Kulkarni",
                "https://github.com/snehakulkarni", LocalDate.of(2001, 1, 18)));

    }

    public ArrayList<Student> getAllStudents() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(FILE_PATH);
            objectInputStream = new ObjectInputStream(fileInputStream);

            students = (ArrayList<Student>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return students;

    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public ArrayList<Student> getStudentDetails() {
        return new ArrayList<>(students);
    }

    public Student searchByFrn(String frn) {
        for (Student s : students) {
            if (s.getFrn().equals(frn)) {
                return s;
            }
        }
        return null;
    }

    public Student searchByEmail(String email) {
        for (Student s : students) {
            if (s.getEmail().equals(email)) {
                return s;
            }
        }
        return null;
    }

    public Student searchByMobile(long mobileNo) {
        for (Student s : students) {
            if (s.getMobileNo() == mobileNo) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        String trimmedName = name.trim();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(trimmedName)) {
                result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Student> searchByDob(String dob) {
        LocalDate date;
        try {
            date = LocalDate.parse(dob, dtf);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please use DD/MM/YYYY.");
            return new ArrayList<>();
        } catch (DateTimeException e) {
            System.out.println("Invalid date! Please enter a valid date.");
            return new ArrayList<>();
        }
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getDob().equals(date)) {
                result.add(s);
            }
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

    public void updateStudent(Student students) {
        // TODO Auto-generated method stub

    }

    public ArrayList<MockDetail> getMockDetailsByFRN(String frn) {

        for (Student s : students) {
            if (s.getName().equals(frn))
                return s.getMockDetails();
        }
        return null;
    }

    public void saveStudents(ArrayList<Student> students) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(students);

            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Student> sortByFrn(boolean ascending) {
        ArrayList<Student> sorted = new ArrayList<>(students);

        Collections.sort(sorted, new FRNComparator(ascending));

        return sorted;
    }

    public ArrayList<Student> sortByName(boolean ascending) {
        ArrayList<Student> sorted = new ArrayList<>(students);

        Collections.sort(sorted, new NameComparator(ascending));

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

}
