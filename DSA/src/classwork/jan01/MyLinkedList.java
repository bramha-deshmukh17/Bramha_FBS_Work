package classwork.jan01;

public class MyLinkedList {

	Node start;

	public MyLinkedList() {
		start = null;
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
	}

	public void insertAtBeg(int ele) {
		if (isEmpty()) {
			start = new Node(ele);
		} else {
			Node temp = new Node(ele);
			temp.setNext(start);
			start = temp;
		}
	}

	public void insertAt(int ele, int pos) {
		Node temp = new Node(ele);
		if (isEmpty()) {
			System.out.println("List is empty");
			start = temp;
		} else if (pos == 1) {
			temp.setNext(start);
			start = temp;
		} else {
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
		}
	}
	
	public void deleteAt(int pos) {
		if(isEmpty()) 
			System.out.println("List is empty");
		
		else if(pos==1)
			start=start.getNext();
		else {
			int count=1;
			Node temp=start;
			while(temp.getNext()!=null && count<pos-1) {
				temp=temp.getNext();
				count++;
			}
			if(temp.getNext()==null)
				System.out.println("Invalid position");
			else {
				System.out.println(temp.getNext().getData()+" deleted");
				temp.setNext(temp.getNext().getNext());
			}
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

	boolean isEmpty() {
		return start == null;
	}
}
