package assignment.assignment2;

import java.util.Scanner;

public class HospitalOperation {
	public static void main(String[] args) {
		int choice = 1;
		String person;
		Scanner sc = new Scanner(System.in);
		QueueHospital queue = new QueueHospital(5);

		while (choice != 4) {
			System.out.println("\n1. Add patient");
			System.out.println("2. Call next person");
			System.out.println("3. Display waiting list");
			System.out.println("4. To Exit");
			System.out.print("Enter a choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter patient name: ");
				queue.enqueue(sc.nextLine());
				break;
				
			case 2:
				person = queue.dequeue();
				if(person!=null) {
					System.out.println("Calling: "+person);
				}else {
					System.out.println("No one in waiting line!");
				}
				
			case 3:
				queue.display();
				break;
				
			case 4:
				System.out.println("Exited!");
				break;
			}
		}

	}
}
