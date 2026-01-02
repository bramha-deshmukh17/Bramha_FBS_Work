package com.studentmanagement.consoleview;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.studentmanagement.controller.StudentManagement;
import com.studentmanagement.model.MockDetail;
import com.studentmanagement.model.MockStatus;
import com.studentmanagement.model.Student;

public class StudentView {
	public void showMenu() {

		StudentManagement sm = new StudentManagement();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n1. Add Student");
			System.out.println("2. Display Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Search Student");
			System.out.println("6. sort Student");
			System.out.println("7. Wish Birthday");
			System.out.println("8. Get mock details by FRN");
			System.out.println("9. Update mock details");
			System.out.println("0. To Exit and Save");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			try {
				switch (choice) {
					case 0:
						System.out.println("Saving data and exiting...");
						sm.saveStudents(sm.getStudentDetails());
						break;

					case 1: {
						System.out.println("Enter FRN, name, email, mobile, github repo, date of birth(DD/MM/YYYY): ");
						String frn = sc.nextLine();
						String name = sc.nextLine();
						String email = sc.nextLine();
						long mobileNo = Long.parseLong(sc.nextLine().trim());
						String gitRepo = sc.nextLine();
						String dobInput = sc.nextLine();

						LocalDate dob = null;
						try {
							dob = LocalDate.parse(dobInput, StudentManagement.dtf);
						} catch (DateTimeParseException e) {
							System.out.println("Invalid date format! Please use DD/MM/YYYY.");
						} catch (DateTimeException e) {
							System.out.println("Invalid date! Please enter a valid date.");
						}

						Student s = new Student(frn, email, mobileNo, name, gitRepo, dob);
						sm.addStudent(s);
						break;
					}

					case 2: {
						ArrayList<Student> students = sm.getStudentDetails();
						displayStudentDetails(students);
						break;
					}

					case 3: {
						System.out.println("Enter FRN number: ");
						String frn = sc.nextLine();

						ArrayList<Student> list = sm.search("frn", frn.trim());
						if (list.isEmpty()) {
							System.out.println("Student not found!");
							break;
						}
						Student existing = list.get(0);

						System.out.println("\n1. To update the email");
						System.out.println("2. To update mobile no");
						System.out.print("Enter choice: ");
						int updateChoice = Integer.parseInt(sc.nextLine().trim());

						switch (updateChoice) {
							case 1: {
								System.out.println("Enter new email: ");
								String newEmail = sc.nextLine();
								existing.setEmail(newEmail);
								sm.updateStudent(existing);
								System.out.println("Email updated successfully!");
								break;
							}
							case 2: {
								System.out.println("Enter new mobile no: ");
								long newMobile = Long.parseLong(sc.nextLine().trim());
								existing.setMobileNo(newMobile);
								sm.updateStudent(existing);
								System.out.println("Mobile no updated successfully!");
								break;
							}
							default:
								System.out.println("Invalid choice! Please try again.");
						}
						break;
					}

					case 4: {
						System.out.println("Enter FRN number to delete: ");
						String frn = sc.nextLine();
						boolean deleted = sm.deleteStudent(frn);
						System.out.println(deleted ? "Student deleted successfully!" : "Student not found!");
						break;
					}

					case 5: {
						System.out.println("\n1. Search by FRN");
						System.out.println("2. Search by email");
						System.out.println("3. Search by mobile no");
						System.out.println("4. Search by name");
						System.out.println("5. Search by DOB");
						System.out.print("Enter choice: ");
						int searchChoice = Integer.parseInt(sc.nextLine().trim());

						switch (searchChoice) {
							case 1: {
								System.out.print("Enter FRN number: ");
								String frn = sc.nextLine();
								ArrayList<Student> result = sm.search("frn", frn);
								displayStudentDetails(result);
								break;
							}
							case 2: {
								System.out.print("Enter email: ");
								String email = sc.nextLine();
								ArrayList<Student> result = sm.search("email", email);
								displayStudentDetails(result);
								break;
							}
							case 3: {
								System.out.print("Enter mobile no: ");
								String mobileStr = sc.nextLine().trim();
								try {
									Long.parseLong(mobileStr); // validate
									ArrayList<Student> result = sm.search("mobile", mobileStr);
									displayStudentDetails(result);
								} catch (NumberFormatException e) {
									System.out.println("Invalid mobile number.");
								}
								break;
							}
							case 4: {
								System.out.print("Enter name: ");
								String name = sc.nextLine();
								ArrayList<Student> result = sm.search("name", name);
								displayStudentDetails(result);
								break;
							}
							case 5: {
								System.out.print("Enter DOB(DD/MM/YYYY): ");
								String dob = sc.nextLine();
								ArrayList<Student> result = sm.search("dob", dob);
								displayStudentDetails(result);
								break;
							}
							default:
								System.out.println("Invalid choice! Please try again.");
								break;
						}
						break;
					}

					case 6: {
						System.out.println("\n1. Sort by FRN in ascending order");
						System.out.println("2. Sort by Name in ascending order");
						System.out.println("3. Sort by FRN in descending order");
						System.out.println("4. Sort by Name in descending order");
						System.out.print("Enter choice: ");
						int sortChoice = Integer.parseInt(sc.nextLine().trim());

						switch (sortChoice) {
							case 1:
								displayStudentDetails(sm.sort("frn", true));
								break;
							case 2:
								displayStudentDetails(sm.sort("name", true));
								break;
							case 3:
								displayStudentDetails(sm.sort("frn", false));
								break;
							case 4:
								displayStudentDetails(sm.sort("name", false));
								break;
							default:
								System.out.println("Invalid choice! Please try again.");
						}
						break;
					}

					case 7: {
						sm.sendTodayBirthdayWishes();
						break;
					}

					case 8: {
						System.out.print("Enter FRN number: ");
						String frn = sc.nextLine();
						ArrayList<MockDetail> mockDetails = sm.getMockDetailsByFRN(frn.trim());
						if (mockDetails == null || mockDetails.isEmpty()) {
							System.out.println("No mock details available for the provided FRN.");
						} else {
							System.out.println("Mock details:");
							System.out.printf("%-5s %-20s %-15s %-15s%n",
									"No.", "Module Name", "Status", "Date Attempted");
							for (int i = 0; i < mockDetails.size(); i++) {
								MockDetail md = mockDetails.get(i);
								String dateStr = md.getMockdate() != null
										? StudentManagement.dtf.format(md.getMockdate())
										: "-";
								System.out.printf("%-5d %-20s %-15s %-15s%n",
										i + 1,
										md.getModuleName(),
										md.getMockStatus(),
										dateStr);
							}
						}
						break;
					}

					case 9: {
						System.out.print("Provide FRN to add/update mock info: ");
						String frnInput = sc.nextLine().trim();

						ArrayList<MockDetail> existingMocks = sm.getMockDetailsByFRN(frnInput);
						if (existingMocks == null) {
							existingMocks = new ArrayList<>();
						}

						System.out.print("Enter module name: ");
						String moduleName = sc.nextLine().trim();

						System.out.print("Enter mock status (e.g., CLEAR/NOT_CLEAR/ABSENT): ");
						String status = sc.nextLine().trim();

						MockStatus mockStatus = null;
						mockStatus = MockStatus.valueOf(status.toUpperCase());
						LocalDate mockDate = LocalDate.now();

						MockDetail target = null;
						for (MockDetail md : existingMocks) {
							if (md.getModuleName() != null && md.getModuleName().equalsIgnoreCase(moduleName)) {
								target = md;
								break;
							}
						}

						if (target == null) {
							target = new MockDetail(moduleName, mockStatus, mockDate);
							existingMocks.add(target);
							System.out.println("Mock detail added for student.");
						} else {
							if (mockStatus != MockStatus.CLEAR) {
								target.setModuleName(moduleName);
								target.setMockStatus(mockStatus);
								target.setMockdate(mockDate);
								System.out.println("Mock detail updated for student.");
							} else {
								System.out.println("Mock already cleared!");
							}
						}
						break;
					}

					default:
						System.out.println("Invalid choice! Please try again.");
						break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid numeric input. Please enter digits only.");
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid value entered. Please check the options and try again.");
			} catch (DateTimeParseException e) {
				System.out.println("Invalid date format! Please use DD/MM/YYYY.");
			} catch (DateTimeException e) {
				System.out.println("Invalid date! Please enter a valid date.");
			} catch (Exception e) {
				System.out.println("An unexpected error occurred: " + e.getMessage());
			}
		} while (choice != 0);

		sc.close();
	}

	static void displayStudentDetails(Student s) {
		if (s != null) {
			System.out.printf("%-10s %-15s %-50s %-50s %-12s %-12s%n", "FRN", "Name", "Email", "GitRepo", "Mobile",
					"DOB");
			String dobStr = (s.getDob() != null) ? StudentManagement.dtf.format(s.getDob()) : "-";
			System.out.printf("%-10s %-15s %-50s %-50s %-12s %-12s%n",
					s.getFrn(), s.getName(), s.getEmail(), s.getGitRepo(), s.getMobileNo(), dobStr);
		} else {
			System.out.println("Student not found!");
		}
	}

	static void displayStudentDetails(ArrayList<Student> students) {
		if (students != null && !students.isEmpty()) {
			System.out.printf("%-10s %-15s %-50s %-50s %-12s %-12s%n", "FRN", "Name", "Email", "GitRepo", "Mobile",
					"DOB");
			for (Student s : students) {
				String dobStr = (s.getDob() != null) ? StudentManagement.dtf.format(s.getDob()) : "-";
				System.out.printf("%-10s %-15s %-50s %-50s %-12s %-12s%n",
						s.getFrn(), s.getName(), s.getEmail(), s.getGitRepo(), s.getMobileNo(), dobStr);
			}
		} else {
			System.out.println("Student not found!");
		}
	}
}
