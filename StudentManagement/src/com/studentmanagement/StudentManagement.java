package com.studentmanagement;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

import com.studentmanagement.comparator.FRNComparator;
import com.studentmanagement.comparator.NameComparator;

public class StudentManagement {
	private final ArrayList<Student> students = new ArrayList<>();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	StudentManagement() {
		dataSeeder();
	}

	private void dataSeeder() {
		addStudent(new Student("FRN001", "Charlie", "alice@gmail.com", "github.com/alice", 9876543210L,
				LocalDate.of(2002, 5, 10)));
		addStudent(new Student("FRN002", "Bob", "bob@gmail.com", "github.com/bob", 9876543211L,
				LocalDate.of(2001, 8, 15)));
		addStudent(new Student("FRN003", "Charlie", "charlie@gmail.com", "github.com/charlie", 9876543212L,
				LocalDate.of(2003, 1, 20)));
		addStudent(new Student("FRN004", "Diana", "diana@gmail.com", "github.com/diana", 9876543213L,
				LocalDate.of(2000, 12, 5)));
		addStudent(new Student("FRN005", "Ethan", "ethan@gmail.com", "github.com/ethan", 9876543214L,
				LocalDate.of(2002, 3, 18)));
		addStudent(new Student("FRN006", "Fiona", "fiona@gmail.com", "github.com/fiona", 9876543215L,
				LocalDate.of(2001, 7, 25)));
		addStudent(new Student("FRN007", "George", "george@gmail.com", "github.com/george", 9876543216L,
				LocalDate.of(2002, 3, 18)));
		addStudent(new Student("FRN008", "Charlie", "hannah@gmail.com", "github.com/hannah", 9876543217L,
				LocalDate.of(2002, 11, 30)));
		addStudent(new Student("FRN009", "Ian", "ian@gmail.com", "github.com/ian", 9876543218L,
				LocalDate.of(2000, 6, 14)));
		addStudent(new Student("FRN010", "Julia", "julia@gmail.com", "github.com/julia", 9876543219L,
				LocalDate.of(2002, 3, 18)));
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

	public boolean deleteStudent(String frn) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getFrn().equals(frn)) {
				students.remove(i);
				return true;
			}
		}
		return false;
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
