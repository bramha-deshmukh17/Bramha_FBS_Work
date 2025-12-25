package com.studentmanagement.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Student implements Serializable{
	String frn;
	String email;
	long mobileNo;
	String name;
	String gitRepo;
	LocalDate dob;
	ArrayList<MockDetail> mockDetails;

	public Student() {
		mockDetails = new ArrayList<MockDetail>();
	}

	public Student(String frn, String email, long mobileNo, String name, String gitRepo, LocalDate dob) {
		super();
		this.frn = frn;
		this.email = email;
		this.mobileNo = mobileNo;
		this.name = name;
		this.gitRepo = gitRepo;
		this.dob = dob;
		mockDetails = new ArrayList<MockDetail>();
	}

	public String getFrn() {
		return frn;
	}

	public void setFrn(String frn) {
		this.frn = frn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGitRepo() {
		return gitRepo;
	}

	public void setGitRepo(String gitRepo) {
		this.gitRepo = gitRepo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ArrayList<MockDetail> getMockDetails() {
		return mockDetails;
	}

	public void setMockDetails(ArrayList<MockDetail> mockDetails) {
		this.mockDetails = mockDetails;
	}

	@Override
	public String toString() {
		return "Student [frn=" + frn + ", email=" + email + ", mobileNo=" + mobileNo + ", name=" + name + ", gitRepo="
				+ gitRepo + ", dob=" + dob + "]";
	}

}
