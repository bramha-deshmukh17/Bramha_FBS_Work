package com.studentmanagement;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StudentManagement {
	static int currIndex = 0;
	static int size = 100;
	static Student[] sList = new Student[size];
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	StudentManagement() {
		// default addition of 10 students
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
		sList[currIndex++] = s;
	}

	public Student[] getStudentDetails() {
		Student[] students = new Student[currIndex];
		for (int i = 0; i < currIndex; i++) {
			students[i] = sList[i];
		}
		return students;
	}

	public Student searchByFrn(String frn) {

		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getFrn().equals(frn)) {
				return sList[i];
			}
		}
		return null;

	}

	public boolean deleteStudent(String frn) {
		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getFrn().equals(frn)) {
				// Shift elements to the left to fill the gap
				for (int j = i; j < currIndex - 1; j++) {
					sList[j] = sList[j + 1];
				}
				sList[currIndex - 1] = null;
				currIndex--;
				return true;
			}
		}
		return false;
	}

	public Student searchByEmail(String email) {
		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getEmail().equals(email)) {
				return sList[i];
			}
		}
		return null;
	}

	public Student searchByMobile(long mobileNo) {
		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getMobileNo() == mobileNo) {
				return sList[i];
			}
		}
		return null;
	}

	public Student[] searchByName(String name) {
		int count = 0;
		String trimmedName = name.trim();
		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getName().equalsIgnoreCase(trimmedName)) {
				count++;
			}
		}

		if (count == 0) {
			return new Student[0];
		}

		Student[] result = new Student[count];
		int resultIndex = 0;
		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getName().equalsIgnoreCase(trimmedName)) {
				result[resultIndex++] = sList[i];
			}
		}
		return result;
	}

	public Student[] searchByDob(String dob) {
		LocalDate date;
		try {
			date = LocalDate.parse(dob, dtf);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format! Please use DD/MM/YYYY.");
			return new Student[0];
		} catch (DateTimeException e) {
			System.out.println("Invalid date! Please enter a valid date.");
			return new Student[0];
		}
		int count = 0;
		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getdob().equals(date)) {
				count++;
			}
		}
		if (count == 0) {
			return new Student[0];
		}

		Student[] result = new Student[count];
		int resultIndex = 0;

		for (int i = 0; i < currIndex; i++) {
			if (sList[i].getdob().equals(date)) {
				result[resultIndex++] = sList[i];
			}
		}
		return result;
	}
}
