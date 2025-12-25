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

	public Student searchByFrn(String frn) {
		return studentDao.searchByFrn(frn);
	}

	public Student searchByEmail(String email) {
		return studentDao.searchByEmail(email);
	}

	public Student searchByMobile(long mobileNo) {
		return studentDao.searchByMobile(mobileNo);
	}

	public ArrayList<Student> searchByName(String name) {
		return studentDao.searchByName(name);
	}

	public ArrayList<Student> searchByDob(String dob) {
		return studentDao.searchByDob(dob);
	}

	public boolean deleteStudent(String frn) {
		return studentDao.deleteStudent(frn);
	}

	public boolean updateStudentEmail(String frn, String newEmail) {
		Student s = studentDao.searchByFrn(frn);
		if (s == null)
			return false;

		s.setEmail(newEmail);
		return true;
	}

	public boolean updateStudentMobile(String frn, long newMobile) {
		Student s = studentDao.searchByFrn(frn);
		if (s == null)
			return false;

		s.setMobileNo(newMobile);
		return true;
	}

	public ArrayList<Student> sortByFrn(boolean ascending) {
		return studentDao.sortByFrn(ascending);
	}

	public ArrayList<Student> sortByName(boolean ascending) {
		return studentDao.sortByName(ascending);
	}

	public ArrayList<Student> getBirthdayStudents() {
		return studentDao.getBirthdayStudents();
	}

	public void sendTodaysBdayWish() {
		ArrayList<Student> birthdayStudents = getBirthdayStudents();
		for (Student s : birthdayStudents) {
			String message = "Happy birthday " + s.getName();
			Sms.sendSms(message, s.getMobileNo());
		}
	}

	public ArrayList<MockDetail> getMockDetailsByFRN(String frn) {
		return studentDao.getMockDetailsByFRN(frn);
	}

	public void saveStudents(ArrayList<Student> students) {
		studentDao.saveStudents(students);
	}
}
