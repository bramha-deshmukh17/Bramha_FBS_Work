package classwork.jan09;

public class Node<T> {
	T data;
	Node<T>  next;

	public Node(T data) {
		this.data = data;
	}

	T getData() {
		return data;
	}

	void setData(T data) {
		this.data = data;
	}

	Node<T>  getNext() {
		return next;
	}

	void setNext(Node<T>  next) {
		this.next = next;
	}
	
	
}
