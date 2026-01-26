package com.layer.client;

import java.util.Scanner;

import com.layer.service.LoginValidationService;
import com.layer.aspect.ObjectCreater;

public class ClientCode {

	public static void main(String[] args) {
		// Taking data from the Client or enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter username");
		String name = sc.nextLine();
		String password = sc.nextLine();

		LoginValidationService login = ObjectCreater.createObject();
		login.createUser(name, password);

		boolean value = login.validateUser(name, password);
		if (value) {
			System.out.println("Welcome user....");
		} else {
			System.out.println("Please try again...");
		}

		sc.close();
	}

}
