package assignment.assignment3;

public class SortedLinkedList {
    Node start;
    public SortedLinkedList() {
        this.start = null;
    }

    //here insert method inserts the element in sorted order (insertion sort)
    public void insert(int data) {
        Node newNode = new Node(data);
        if (start == null || start.getData() >= newNode.getData()) {
            newNode.setNext(start);
            start = newNode;
        } else {
            Node current = start;
            while (current.getNext() != null && current.getNext().getData() < newNode.getData()) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public void display() {
        Node current = start;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("Sorted Linked List: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
