package classwork.jan02;

import java.util.Scanner;

public class LinkedListDemo {

	public static void main(String[] args) {

		MyLinkedList ml = new MyLinkedList();

		int choice = 1;
		Scanner sc = new Scanner(System.in);

		while (choice != 0) {
			System.out.println("\n1. To insert");
			System.out.println("2. To display");
			System.out.println("3. To insert at beginning");
			System.out.println("4. To insert at position");
			System.out.println("5. To insert at end");
			System.out.println("6. To delete at beginning");
			System.out.println("7. To delete at position");
			System.out.println("8. To delete at end");
			System.out.println("9. To display prime number in list");
			System.out.println("10. To sort the list - ascending");
			System.out.println("11. To sort the list - descending");
			System.out.println("12. To reverse the list");
			System.out.println("13. To search an element");
			System.out.println("0. To Exit");
			System.out.print("Enter a choice: ");
			choice = sc.nextInt();

			switch (choice) {

				case 1:
					System.out.print("Enter number to insert: ");
					ml.insert(sc.nextInt());
					break;

				case 2:
					ml.display();
					break;

				case 3:
					System.out.print("Enter number to insert: ");
					ml.insertAtBeg(sc.nextInt());
					break;

				case 4:
					System.out.print("Enter number to insert: ");
					int ele = sc.nextInt();
					System.out.print("Enter position: ");
					int pos = sc.nextInt();
					ml.insertAt(ele, pos);
					break;

				case 5:
					System.out.print("Enter number to insert: ");
					ml.insert(sc.nextInt());
					break;

				case 6:
					ml.deleteAtBeginning();
					break;

				case 7:
					System.out.print("Enter position to delete: ");
					int delPos = sc.nextInt();
					ml.deleteAt(delPos);
					break;

				case 8:
					ml.delete();
					break;

				case 9:
					System.out.println("Prime number: ");
					ml.displayPrimes();
					break;

				case 10:
					System.out.println("Sorted list:");
					ml.sort(true);
					break;

				case 11:
					System.out.println("Sorted list:");
					ml.sort(false);
					break;

				case 12:
					System.out.println("Reverse: ");
					ml.reverseDisplay();
					break;

				case 13:
					System.out.print("Enter element to search: ");
					ml.search(sc.nextInt());
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
