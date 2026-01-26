package com.employee.demos;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
		EmployeeManagement em=new EmployeeManagement(); 
		do {
			System.out.println("\n1. Add");
			System.out.println("2. Search by Id");
			System.out.println("3. Update by Id");
			System.out.println("4. Delete by Id");
			System.out.println("5. Display All");
			System.out.println("0. Exit");
			
			System.out.print("Enter Your choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 0:
				System.out.println("Exiting...");
				break;
				
			case 1:
				em.addEmployee();
				break;
				
			case 2:
				em.searchEmployee();
				break;
			
			case 3:
				em.updateEmployee();
				break;
			
			case 4:
				em.deleteEmployee();
				break;
			
			case 5:
				em.displayAll();
				break;
				
			default:
				System.out.println("Wrong choice! try again");
				break;
				
			}
			
		}while(choice!=0);
		
		sc.close();

	}

}
