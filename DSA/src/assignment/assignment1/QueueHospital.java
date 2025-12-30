package assignment.assignment1;

public class QueueHospital {
	int front = -1, rear = -1;
	String[] arr;

	public QueueHospital(int size) {
		arr = new String[size];
	}

	public void enqueue(String person) {
		if (!isFull()) {
			if (!alreadyExist(person)) {
				if (rear == -1) {
					rear = 0;
					front = 0;
				} else if (rear == arr.length - 1) {
					rear = 0;
				} else {
					rear++;
				}
				arr[rear] = person;
			}
		} else {
			System.out.println("Waiting line is full");
		}
	}

	public String dequeue() {
		String person = null;
		if (!isEmpty()) {
			person = arr[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == arr.length - 1) {
				front = 0;
			} else {
				front++;
			}

		}
		return person;
	}

	public void display() {
		if (!isEmpty()) {
			int i = front, count = 1;
			while (i != rear) {
				System.out.println(count++ + ". " + arr[i] + " ");
				if (i == arr.length - 1)
					i = 0;
				else
					i++;
			}
			System.out.println(count++ + ". " + arr[i]);
		} else {
			System.out.println("No one is waiting");
		}
	}

	boolean alreadyExist(String person) {

		int i = front;
		while (i != rear) {
			if (i == arr.length - 1)
				i = 0;
			else
				i++;
			if (arr[i].equals(person)) {
				System.out.println("Patient already in queue");
				return true;
			}
		}
		return false;

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
