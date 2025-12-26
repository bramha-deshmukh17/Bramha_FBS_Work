package classwork.dec25;

import java.util.Scanner;

public class StackDemo {

	public static void main(String[] args) {

		int choice = 1, num;
		Scanner sc = new Scanner(System.in);
		StackInt s = new StackInt(5);

		while (choice != 4) {
			System.out.println("\n1. To Push");
			System.out.println("2. To Pop");
			System.out.println("3. To Peek");
			System.out.println("4. To Exit");
			System.out.println("Enter a choice");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter number to push: ");
				s.push(sc.nextInt());
				break;
				
			case 2:
				num = s.pop();
				if(num != -1) {
					System.out.println("Popped Element: "+num);
				}else {
					System.out.println("Stack Underflow");
				}
				break;
				
			case 3:
				num = s.pop();
				if(num != -1) {
					System.out.println("Top Element: "+num);
				}else {
					System.out.println("Stack is empty");
				}
				break;
				
			case 4:
				System.out.println("Exited!");
				break;
			}
		}

	}

}
