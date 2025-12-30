package assignment.assignment1;

import java.util.Scanner;

public class TextEditor {

	public static void main(String[] args) {
		int choice = 1;
		String str;
		Scanner sc = new Scanner(System.in);
		StackEditor stack = new StackEditor(10);

		while (choice != 4) {
			System.out.println("\n1. Write a line");
			System.out.println("2. Undo");
			System.out.println("3. Display current text");
			System.out.println("4. To Exit");
			System.out.print("Enter a choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter line: ");
				str = sc.nextLine();
				stack.push(str);
				break;

			case 2:
				str = stack.pop();
				if (str != null) {
					System.out.println("Undo performed!\nRemoved: " + str);
				} else {
					System.out.println("Nothing to Undo");
				}
				break;

			case 3:
				stack.display();
				break;

			case 4:
				System.out.println("Exited!");
				break;
			}
		}

	}
}
