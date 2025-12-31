package com.studentmanagement.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.studentmanagement.model.MockDetail;
import com.studentmanagement.model.Student;
import com.studentmanagement.model.StudentDao;
import com.studentmanagement.model.StudentDaoFile;
import com.studentmanagement.services.Sms;

public class StudentManagement {

	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	final StudentDao studentDao;

	public StudentManagement() {
		studentDao = new StudentDaoFile();
	}

	public void addStudent(Student stud) {
		studentDao.addStudent(stud);
	}

	public ArrayList<Student> getStudentDetails() {
		return studentDao.getStudentDetails();
	}

	public ArrayList<Student> search(String field, String value) {
		return studentDao.search(field, value);
	}

	public void updateStudent(Student s) {
		studentDao.updateStudent(s);
	}

	public boolean deleteStudent(String frn) {
		return studentDao.deleteStudent(frn);
	}

	public ArrayList<Student> sort(String field, boolean ascending) {
		return studentDao.sort(field, ascending);
	}

	public ArrayList<Student> getBirthdayStudents() {
		return studentDao.getBirthdayStudents();
	}

	public ArrayList<MockDetail> getMockDetailsByFRN(String frn) {
		return studentDao.getMockDetailsByFRN(frn);
	}

	public void saveStudents(ArrayList<Student> students) {
		studentDao.saveStudents(students);
	}

	public void saveMockDetails(String frn, ArrayList<MockDetail> mockDetails) {
		studentDao.saveMockDetails(frn, mockDetails);
	}

	public void sendTodayBirthdayWishes() {
		ArrayList<Student> birthdayStudents = getBirthdayStudents();
		if (birthdayStudents.isEmpty()) {
			System.out.println("No birthdays today.");
		} else {
			System.out.println("Birthday Wishes to:");
			for (Student s : birthdayStudents) {
				String message = "Happy birthday " + s.getName();
				Sms.sendSms(message, s.getMobileNo());
			}
		}
	}

}
