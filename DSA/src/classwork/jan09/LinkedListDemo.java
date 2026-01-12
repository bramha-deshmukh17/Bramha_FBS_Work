package classwork.jan09;

import java.util.Scanner;

public class LinkedListDemo {

	public static void main(String[] args) {

		MyLinkedList<Employee> ml = new MyLinkedList<Employee>();

		int choice = 1;
		Scanner sc = new Scanner(System.in);

		while (choice != 0) {
			System.out.println("\n1. To insert");
			System.out.println("2. To display");
			System.out.println("3. To search");
			System.out.println("0. To Exit");
			System.out.print("Enter a choice: ");
			choice = sc.nextInt();

			switch (choice) {

				case 1:
					System.out.print("Enter id:");
					int id=sc.nextInt();
					System.out.print("Enter name:");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Enter salary:");
					double salary=sc.nextDouble();
					System.out.print("Enter position:");
					
					ml.insertAt(new Employee(id, name, salary), sc.nextInt());
					break;

				case 2:
					ml.display();
					break;

				case 3:
					System.out.print("Enter id:");
					int id1=sc.nextInt();
					System.out.print("Enter name:");
					sc.nextLine();
					String name1 = sc.nextLine();
					System.out.print("Enter salary:");
					double salary1=sc.nextDouble();
					System.out.print("Enter position:");
					
					ml.search(new Employee(id1, name1, salary1));
					break;

				case 0:
					System.out.println("Exited!");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}
		sc.close();
	}
}
