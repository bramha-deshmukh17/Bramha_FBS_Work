package com.studentmanagement;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		StudentManagement sm = new StudentManagement();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n0. To Exit");
			System.out.println("1. Add Student");
			System.out.println("2. Display Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Search Student");
			System.out.println("6. sort Student");
			System.out.println("7. Wish Birthday");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 0:
					System.out.println("Exiting...");
					break;
				case 1: {

					System.out.println("Enter FRN, name, email, mobile, github repo, date of birth(DD/MM/YYYY): ");
					String frn = sc.nextLine();
					String name = sc.nextLine();
					String email = sc.nextLine();
					long mobileNo = sc.nextLong();
					sc.nextLine(); // Consume newline
					String gitRepo = sc.nextLine();
					LocalDate dob = null;
					try {
						dob = LocalDate.parse(sc.next(), StudentManagement.dtf);
					} catch (DateTimeParseException e) {
						System.out.println("Invalid date format! Please use DD/MM/YYYY.");
					} catch (DateTimeException e) {
						System.out.println("Invalid date! Please enter a valid date.");
					}
					Student s = new Student(frn, name, email, gitRepo, mobileNo, dob);

					sm.addStudent(s);
					break;

				}

				case 2: {
					Student[] students = sm.getStudentDetails();
					displayStudentDetails(students);
					break;
				}
				case 3: {
					System.out.println("Enter FRN number: ");
					String frn = sc.next();
					Student s = sm.searchByFrn(frn);
					if (s != null) {
						System.out.println("\n1. To update the email");
						System.out.println("2. To update mobile no");
						System.out.print("Enter choice: ");
						switch (sc.nextInt()) {
							case 1: {
								System.out.println("Enter new email: ");
								s.setEmail(sc.next());
								System.out.println("Email updated successfully!");
								break;
							}
							case 2: {
								System.out.println("Enter new mobile no: ");
								s.setMobileNo(sc.nextLong());
								System.out.println("Mobile no updated successfully!");
								break;
							}
						}
					} else {
						System.out.println("Student not found!");
					}
					break;
				}
				case 4: {
					System.out.println("Enter FRN number to delete: ");
					String frn = sc.next();
					boolean deleted = sm.deleteStudent(frn);
					if (deleted) {
						System.out.println("Student deleted successfully!");
					} else {
						System.out.println("Student not found!");
					}
					break;
				}
				case 5: {
					System.out.println("\n1. Search by FRN");
					System.out.println("2. Search by email");
					System.out.println("3. Search by mobile no");
					System.out.println("4. Search by name");
					System.out.println("5. Search by DOB");
					System.out.print("Enter choice: ");
					switch (sc.nextInt()) {
						case 1: {
							System.out.print("Enter FRN number: ");
							sc.nextLine();
							String frn = sc.nextLine();
							Student sByFrn = sm.searchByFrn(frn);
							displayStudentDetails(sByFrn);
							break;
						}
						case 2: {
							System.out.print("Enter email: ");
							sc.nextLine();
							String email = sc.nextLine();
							Student sByEmail = sm.searchByEmail(email);
							displayStudentDetails(sByEmail);
							break;
						}
						case 3: {
							System.out.print("Enter mobile no: ");
							long mobileNo = sc.nextLong();
							Student sByMobile = sm.searchByMobile(mobileNo);
							displayStudentDetails(sByMobile);
							break;
						}
						case 4: {
							System.out.print("Enter name: ");
							sc.nextLine();
							String name = sc.nextLine();
							Student[] sByName = sm.searchByName(name);
							displayStudentDetails(sByName);
							break;
						}
						case 5: {
							System.out.print("Enter DOB(DD/MM/YYYY): ");
							sc.nextLine();
							String dob = sc.nextLine();
							Student[] sByDob = sm.searchByDob(dob);
							displayStudentDetails(sByDob);

							break;
						}
						default:
							System.out.println("Invalid choice! Please try again.");
							break;
					}

					break;
				}

				default: {
					System.out.println("Invalid choice! Please try again.");
					break;
				}
			}

		} while (choice != 0);

		sc.close();
	}

	static void displayStudentDetails(Student s) {
		if (s != null) {
			System.out.printf("%-10s %-15s %-25s %-25s %-12s %-12s%n", "FRN", "Name", "Email", "GitRepo", "Mobile", "DOB");
			String dobStr = (s.getdob() != null) ? StudentManagement.dtf.format(s.getdob()) : "-";
			System.out.printf("%-10s %-15s %-25s %-25s %-12s %-12s%n", s.getFrn(), s.getName(), s.getEmail(), s.getgitRepo(), s.getMobileNo(),
					dobStr);
		} else {
			System.out.println("Student not found!");
		}
	}

	static void displayStudentDetails(Student[] students) {
		if (students != null && students.length > 0) {
			System.out.printf("%-10s %-15s %-25s %-25s %-12s %-12s%n", "FRN", "Name", "Email", "GitRepo", "Mobile",
					"DOB");
			
			for (Student s : students) {
				String dobStr = (s.getdob() != null) ? StudentManagement.dtf.format(s.getdob()) : "-";
				System.out.printf("%-10s %-15s %-25s %-25s %-12s %-12s%n", s.getFrn(), s.getName(), s.getEmail(),
						s.getgitRepo(), s.getMobileNo(),
						dobStr);
			}
		} else {
			System.out.println("Student not found!");
		}
	}

}
