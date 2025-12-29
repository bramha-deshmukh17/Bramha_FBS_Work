package classwork.dec29;

public class QueueInt {
	int front = -1, rear = -1;
	int[] arr;

	QueueInt(int size) {
		arr = new int[size];
	}

	void enqueue(int ele) {
		if (!isFull()) {
			if (rear == -1) {
				rear = 0;
				front = 0;
			} else if (rear == arr.length - 1) {
				rear = 0;
			} else {
				rear++;
			}
			arr[rear] = ele;
		} else {
			System.out.println("Queue is full");
		}
	}

	int dequeue() {
		int num = -1;
		if (!isEmpty()) {
			num = arr[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == arr.length - 1) {
				front = 0;
			} else {
				front++;
			}

		}
		return num;
	}

	void display() {
		if (!isEmpty()) {
			int i = front;
			while (i != rear) {
				System.out.print(arr[i] + " ");
				if (i == arr.length - 1)
					i = 0;
				else
					i++;
			}
			System.out.print(arr[i]);
		}
	}

	boolean isEmpty() {
		return rear == -1;
	}

	boolean isFull() {
		if ((arr.length - 1 == rear && front == 0) || (front - 1 == rear)) {
			return true;
		} else {
			return false;
		}
	}
}
