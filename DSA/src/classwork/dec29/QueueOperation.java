package classwork.dec29;

import java.util.Scanner;


public class QueueOperation {

	public static void main(String[] args) {
		int choice = 1, num;
		Scanner sc = new Scanner(System.in);
		QueueInt queue = new QueueInt(5);

		while (choice != 4) {
			System.out.println("\n1. To insert");
			System.out.println("2. To delete");
			System.out.println("3. To display");
			System.out.println("4. To Exit");
			System.out.println("Enter a choice");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter number to insert: ");
				queue.enqueue(sc.nextInt());
				break;
				
			case 2:
				num = queue.dequeue();
				if(num != -1) {
					System.out.println("Deleted Element: "+num);
				}else {
					System.out.println("Queue Underflow");
				}
				break;
				
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
