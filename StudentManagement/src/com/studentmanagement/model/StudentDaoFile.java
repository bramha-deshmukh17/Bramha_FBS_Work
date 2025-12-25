package com.studentmanagement.model;

import java.io.FileInputStream;
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

public class StudentDaoFile implements StudentDao {

	static String FILE_PATH = System.getProperty("user.home") + "/studentdata.txt";
	static ArrayList<Student> students = new ArrayList<Student>();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	static {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
			students = (ArrayList<Student>) ois.readObject();
		} catch (Exception e) {
			students = new ArrayList<>();
		}
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
			if (s.getDob() != null && s.getDob().equals(date)) {
				result.add(s);
			}
		}
		return result;
	}

	public boolean deleteStudent(String frn) {
		return students.removeIf(s -> s.getFrn().equals(frn));
	}

	public void updateStudent(Student students) {
		// TODO Auto-generated method stub
	}

	public ArrayList<MockDetail> getMockDetailsByFRN(String frn) {
		for (Student s : students) {
			if (s.getFrn().equals(frn))
				return s.getMockDetails();
		}
		return null;
	}

	public void saveStudents(ArrayList<Student> studentsToSave) {
		// Update the in-memory list and save it to the file.
		StudentDaoFile.students = studentsToSave;
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
			objectOutputStream.writeObject(studentsToSave);
		} catch (IOException e) {
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
			if (s.getDob() != null && s.getDob().getMonth() == today.getMonth()
					&& s.getDob().getDayOfMonth() == today.getDayOfMonth()) {
				birthdayStudents.add(s);
			}
		}
		return birthdayStudents;
	}

}
