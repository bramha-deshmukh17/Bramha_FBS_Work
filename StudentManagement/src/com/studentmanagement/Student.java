package com.studentmanagement;

import java.time.LocalDate;

public class Student {
	String frn, name, email, gitrepo;
	long mobileNo;
	LocalDate birthDate;
	
	Student(String frn, String name, String email, String gitrepo, long mobileNo, LocalDate birthDate) {
		super();
		this.frn = frn;
		this.name = name;
		this.email = email;
		this.gitrepo = gitrepo;
		this.mobileNo = mobileNo;
		this.birthDate = birthDate;
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

	String getGitrepo() {
		return gitrepo;
	}

	void setGitrepo(String gitrepo) {
		this.gitrepo = gitrepo;
	}

	long getMobileNo() {
		return mobileNo;
	}

	void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	LocalDate getBirthDate() {
		return birthDate;
	}

	void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Student [frn=" + frn + ", name=" + name + ", email=" + email + ", gitrepo=" + gitrepo + ", mobileNo="
				+ mobileNo + ", birthDate=" + birthDate + "]";
	}
	
	
}
