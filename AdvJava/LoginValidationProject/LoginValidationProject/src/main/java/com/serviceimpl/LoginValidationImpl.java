package com.serviceimpl;

import com.services.LoginValidationInterface;

public class LoginValidationImpl implements LoginValidationInterface {

	@Override
	public void SignUp(String username, String password, String question, String answer) {

	}

	@Override
	public boolean SignIn(String username, String password) {

		return false;
	}

	@Override
	public String ForgetPassword(String username, String question, String answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdatePassword(String username, String password, String newpassword) {

	}

	@Override
	public boolean deleteAccount(String username, String password) {

		return false;
	}

}
