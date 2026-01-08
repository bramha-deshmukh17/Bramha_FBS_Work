package classwork.jan02;

public class MyLinkedList {

	Node start;
	int size;

	public MyLinkedList() {
		start = null;
		size = 0;
	}

	public void insert(int ele) {
		if (isEmpty()) {
			start = new Node(ele);
		} else {
			Node temp = start;
			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.setNext(new Node(ele));
		}
		size++;
	}

	public void insertAtBeg(int ele) {
		if (isEmpty()) {
			start = new Node(ele);
		} else {
			Node temp = new Node(ele);
			temp.setNext(start);
			start = temp;
		}
		size++;
	}

	public void insertAt(int ele, int pos) {
		Node temp = new Node(ele);

		if (isEmpty()) {
			System.out.println("List is empty");
			start = temp;
			size = 1;
			return;
		}

		if (pos == 1) {
			temp.setNext(start);
			start = temp;
			size++;
			return;
		}

		Node curr = start;
		int count = 1;
		while (curr.getNext() != null && count < pos - 1) {
			curr = curr.getNext();
			count++;
		}
		if (curr.getNext() == null)
			System.out.println("Position not found, inserted at last position");

		temp.setNext(curr.getNext());
		curr.setNext(temp);
		size++;
	}

	public void delete() {
		if (!isEmpty()) {
			if (size == 1) {
				System.out.println(start.getData() + " deleted");
				start = null;
			} else {
				Node temp = start;
				for (int i = 1; i < size - 1; i++) {
					temp = temp.getNext();
				}
				System.out.println(temp.getNext().getData() + " deleted");
				temp.setNext(null);
			}
			size--;
		}
	}

	public void deleteAtBeginning() {
		if (!isEmpty()) {
			if (size == 1) {
				System.out.println(start.getData() + " deleted");
				start = null;
			} else {
				System.out.println(start.getData() + " deleted");
				start = start.getNext();
			}
			size--;
		}
	}

	public void deleteAt(int pos) {
		if (pos > 1 || pos < size) {
			if (isEmpty()) {
				System.out.println("List is empty");
				return;
			} else if (pos == 1) {
				System.out.println(start.getData() + " deleted");
				start = start.getNext();
				size--;
			} else {
				int count = 1;
				Node temp = start;
				while (temp.getNext() != null && count < pos - 1) {
					temp = temp.getNext();
					count++;
				}
				if (temp.getNext() == null) {
					System.out.println("Invalid position");
				} else {
					System.out.println(temp.getNext().getData() + " deleted");
					temp.setNext(temp.getNext().getNext());
					size--;
				}
			}
		} else {
			System.out.println("Position out of range");
		}
	}

	public void display() {
		System.out.println();
		if (isEmpty()) {
			System.out.println("LinkedList is empty");
		} else {
			Node temp = start;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}
		System.out.println();
	}

	void displayPrimes() {
		System.out.println();
		if (isEmpty()) {
			System.out.println("LinkedList is empty");
		} else {
			Node temp = start;
			while (temp != null) {
				isPrime(temp.getData());
				temp = temp.getNext();
			}
		}
		System.out.println();
	}

	void isPrime(int num) {
		if (num == 2) {
			System.err.println(num + " ");
			return;
		}
		boolean prime = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				prime = false;
				break;
			}
		}
		if (prime)
			System.out.print(num + " ");
	}

	void sort(boolean ascending) {
		if (!isEmpty() && size > 1) {
			for (int i = 0; i < size - 1; i++) {
				Node current = start;
				Node next = start.getNext();
				for (int j = 0; j < size - i - 1; j++) {
					if (ascending ? current.getData() > next.getData() : current.getData() < next.getData()) {
						int temp = current.getData();
						current.setData(next.getData());
						next.setData(temp);
					}
					current = next;
					next = next.getNext();
				}
			}
		}
	}

	void reverseDisplay() {
		reverse(start);
	}

	void reverse(Node temp) {
		if (temp != null) {
			reverse(temp.getNext());
			System.out.print(temp.getData() + " ");
		}
	}

	boolean isEmpty() {
		return start == null;
	}

	public void search(int num) {
		if (isEmpty()) {
			System.out.println("LinkedList is empty");
		} else {
			int pos = 1;
			Node temp = start;
			while (temp != null) {
				if (temp.getData() == num) {
					System.out.println("Found at position: " + pos);
					return;
				}
				temp = temp.getNext();
			}
		}
	}
}
