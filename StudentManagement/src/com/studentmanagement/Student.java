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

	public String getFrn() {
		return frn;
	}

	public void setFrn(String frn) {
		this.frn = frn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGitRepo() {
		return gitRepo;
	}

	public void setGitRepo(String gitRepo) {
		this.gitRepo = gitRepo;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [frn=" + frn + ", name=" + name + ", email=" + email + ", gitRepo=" + gitRepo + ", mobileNo="
				+ mobileNo + ", dob=" + dob + "]";
	}

}
