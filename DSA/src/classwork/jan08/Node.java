package classwork.jan08;

public class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }
}
