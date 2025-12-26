package classwork.dec25;

public class StackInt {
	int[] arr;
	int top;

	public StackInt(int size) {
		arr = new int[size];
		top = -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int num) {
		if (!isFull())
			arr[++top] = num;
		else
			System.out.println("Stack overflow");
	}

	public int pop() {
		if (!isEmpty())
			return arr[top--];
		else
			return -1;
	}

	public int peek() {
		if (!isEmpty())
			return arr[top];
		else
			return -1;
	}

}
