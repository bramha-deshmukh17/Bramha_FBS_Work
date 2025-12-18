package com.studentmanagement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("\n0. To Exit");
		System.out.println("1. Add Student");
		System.out.println("2. Display Students");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Search Student");
		System.out.println("6. sort Student");
		System.out.println("7. Wish Birthday");
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter choice: ");
		
		int choice = sc.nextInt();
		while(choice != 0) {
			
			switch(choice) {
			case 1:
				System.out.println("Enter FRN, name, email, mobile, github repo, date of birth");
				
				Student s=new Student();
				addStudent();
				break;
			}
		}
	}

}
