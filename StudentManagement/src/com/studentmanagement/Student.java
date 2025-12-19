package com.studentmanagement;

import java.time.LocalDate;

public class Student {
	String frn, name, email, gitRepo;
	long mobileNo;
	LocalDate dob;

	Student(String frn, String name, String email, String gitRepo, long mobileNo, LocalDate dob) {
		this.frn = frn;
		this.name = name;
		this.email = email;
		this.gitRepo = gitRepo;
		this.mobileNo = mobileNo;
		this.dob = dob;
	}

	String getFrn() {
		return frn;
	}

	void setFrn(String frn) {
		this.frn = frn;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	String getgitRepo() {
		return gitRepo;
	}

	void setgitRepo(String gitRepo) {
		this.gitRepo = gitRepo;
	}

	long getMobileNo() {
		return mobileNo;
	}

	void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	LocalDate getdob() {
		return dob;
	}

	void setdob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [frn=" + frn + ", name=" + name + ", email=" + email + ", gitRepo=" + gitRepo + ", mobileNo="
				+ mobileNo + ", dob=" + dob + "]";
	}

}
