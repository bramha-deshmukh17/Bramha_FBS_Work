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

public class StudentDaoFile implements StudentDao {

	static String FILE_PATH = System.getProperty("user.home") + "/studentdata.txt";
	static ArrayList<Student> students = new ArrayList<Student>();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	static {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
			Object obj = ois.readObject();
			if (obj instanceof ArrayList) {
				students = (ArrayList<Student>) obj;
			} else {
				students = new ArrayList<>();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Student data file not found. Starting with empty list.");
			students = new ArrayList<>();
		} catch (ClassNotFoundException e) {
			System.out.println("Stored student data is incompatible with current version.");
			students = new ArrayList<>();
		} catch (IOException e) {
			System.out.println("Error loading students from file: " + e.getMessage());
			students = new ArrayList<>();
		} catch (ClassCastException e) {
			System.out.println("Student data file has unexpected format. Starting fresh.");
			students = new ArrayList<>();
		}
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
			if (s.getFrn().equals(frn))
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

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
			objectOutputStream.writeObject(students);
		} catch (IOException e) {
			System.out.println("Error saving students to file: " + e.getMessage());
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
			if (s.getDob() != null && s.getDob().getMonth() == today.getMonth()
					&& s.getDob().getDayOfMonth() == today.getDayOfMonth()) {
				birthdayStudents.add(s);
			}
		}
		return birthdayStudents;
	}

}
