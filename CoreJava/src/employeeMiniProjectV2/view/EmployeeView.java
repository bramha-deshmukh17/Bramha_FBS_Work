package employeeMiniProjectV2.view;

import java.util.Scanner;
import employeeMiniProjectV2.controller.EmployeeController;
import employeeMiniProjectV2.model.Admin;
import employeeMiniProjectV2.model.Employee;
import employeeMiniProjectV2.model.HR;
import employeeMiniProjectV2.model.SalesManager;

public class EmployeeView {
	EmployeeController ec;
	Scanner sc = new Scanner(System.in);

	public EmployeeView(EmployeeController ec) {

		this.ec = ec;
	}

	public void showOptions() {

		int choice = 0;

		do {
			System.out.println("0. Exit");
			System.out.println("1. Add an Employee");
			System.out.println("2. Search an Employee");
			System.out.println("3. Update an Employee");
			System.out.println("4. Delete an Employee");
			System.out.println("5. Display all Employees");
			System.out.println("6. Sort Employees");

			System.out.println("Enter your choice:");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter Employee Type (1-HR, 2-Admin, 3-SalesManager): ");
				int type = sc.nextInt();

				System.out.print("Enter ID: ");
				int id = sc.nextInt();

				sc.nextLine();
				System.out.print("Enter Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Base Salary: ");
				double salary = sc.nextDouble();

				if (type == 1) {
					System.out.print("Enter Commission: ");
					double comm = sc.nextDouble();

					if(ec.addEmployee(new HR(id, name, salary, comm))) {
						System.out.println("HR added.");
					}

				} else if (type == 2) {
					System.out.print("Enter Allowance: ");
					double allowance = sc.nextDouble();

					if(ec.addEmployee(new Admin(id, name, salary, allowance))) {
						System.out.println("Admin added");
					}

				} else if (type == 3) {
					System.out.print("Enter Target: ");
					int target = sc.nextInt();
					System.out.print("Enter Incentive per Target: ");
					double incentive = sc.nextDouble();

					if(ec.addEmployee(new SalesManager(id, name, salary, target, incentive))) {
						System.out.println("SalesManager added");
					}

				}else {
					System.out.println("Invalid Employee Type!");
				}

				break;
			case 2:
				System.out.print("Enter ID to search: ");
				id = sc.nextInt();
				Employee e = ec.searchEmployeeById(id);
				if (e != null)
					System.out.println("Found: " + e);
				else
					System.out.println("Employee not found.");
				break;
			case 3:
				System.out.print("Enter ID to update: ");
				id = sc.nextInt();
				System.out.print("Enter New Salary: ");
				salary = sc.nextDouble();
				if (ec.updateEmployee(id, salary))
					System.out.println("Updated successfully!");
				else
					System.out.println("Employee not found.");
				break;
			case 4:
				System.out.print("Enter ID to delete: ");
				id = sc.nextInt();
				if (ec.deleteEmployee(id))
					System.out.println("Deleted successfully!");
				else
					System.out.println("Employee not found.");
				break;
			case 5:
				ec.displayAll();
				break;
			case 6:
				System.out.println("\n1. Sort by Id");
				System.out.println("2. Sort by Name");
				System.out.println("3. Sort by Salary");
				System.out.println("Enter choice: ");
				ec.sortEmployee(sc.nextInt());
				break;
			}
		} while (choice != 0);
		System.out.println("Program Exited");
	}

}
