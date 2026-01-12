package classwork.jan09;

import classwork.jan02.Node;
public class StackUsingLinkedList {

	Node start;
	int size;

	public StackUsingLinkedList() {
			start = null;
			size = 0;
		}

	public void push(int ele) {
		if (isEmpty()) {
			start = new Node(ele);
		} else {
			Node temp = new Node(ele);
			temp.setNext(start);
			start = temp;
		}
		size++;
	}

	public int pop() {
		if (!isEmpty()) {
			int ele = start.getData();
			if (size == 1) {
				System.out.println(ele + " deleted");
				start = null;
			} else {
				System.out.println(ele + " deleted");
				start = start.getNext();
			}
			size--;
			return ele;
		}
		return 0;
	}
	
	public int peek() {
		if(!isEmpty())
			return start.getData();
		return 0;
	}

	boolean isEmpty() {
		return start == null;
	}
}
