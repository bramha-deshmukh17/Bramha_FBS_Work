package classwork.jan09;

public class MyLinkedList<T>  {

	Node<T>  start;
	int size;

	public MyLinkedList() {
		start = null;
		size = 0;
	}

	public void insertAt(T ele, int pos) {
		Node<T>  temp = new Node<T>(ele);

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

		Node<T>  curr = start;
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
				Node<T> temp = start;
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
			Node<T>  temp = start;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}
		System.out.println();
	}

	
	boolean isEmpty() {
		return start == null;
	}

	public void search(T num) {
		if (isEmpty()) {
			System.out.println("LinkedList is empty");
		} else {
			int pos = 1;
			Node<T>  temp = start;
			while (temp != null) {
				if (temp.getData().equals(num)) {
					System.out.println("Found at position: " + pos);
					return;
				}
				temp = temp.getNext();
			}
		}
	}
}
