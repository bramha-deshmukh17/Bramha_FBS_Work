package classwork.dec25;

import java.util.Scanner;

class Stack {
	int[] arr;
	int top;

	Stack(int size) {
		arr = new int[size];
		top = -1;
	}

	boolean isFull() {
		return top == arr.length - 1;
	}

	boolean isEmpty() {
		return top == -1;
	}

	void push(int num) {
		if (!isFull())
			arr[++top] = num;
		else
			System.out.println("Stack overflow");
	}

	int pop() {
		if (!isEmpty())
			return arr[top--];
		else
			return -1;
	}

	int peek() {
		if (!isEmpty())
			return arr[top];
		else
			return -1;
	}
}

public class StackDemo {

	public static void main(String[] args) {

		int choice = 1, num;
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack(5);

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
