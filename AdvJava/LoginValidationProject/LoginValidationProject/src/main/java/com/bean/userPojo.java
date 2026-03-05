package com.bean;

import java.util.Objects;

public class userPojo {

	private String userName;
	private String password;
	private String securityQuestion;
	private String answer;

	public userPojo() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "userPojo [userName=" + userName + ", password=" + password + ", securityQuestion=" + securityQuestion
				+ ", answer=" + answer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(answer, password, securityQuestion, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		userPojo other = (userPojo) obj;
		return Objects.equals(answer, other.answer) && Objects.equals(password, other.password)
				&& Objects.equals(securityQuestion, other.securityQuestion) && Objects.equals(userName, other.userName);
	}

}
