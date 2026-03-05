package com.services;

public interface LoginValidationInterface {

	public void SignUp(String username, String password, String question, String answer);

	public boolean SignIn(String username, String password);

	public String ForgetPassword(String username, String question, String answer);

	public void UpdatePassword(String username, String password, String newpassword);

	public boolean deleteAccount(String username, String password);

}
