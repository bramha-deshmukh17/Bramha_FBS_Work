package com.layer.service;

public interface LoginValidationService {
	public void createUser(String username, String password);

	public boolean validateUser(String username, String password);
}
