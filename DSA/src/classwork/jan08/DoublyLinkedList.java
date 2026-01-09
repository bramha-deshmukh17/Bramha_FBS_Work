package classwork.jan08;

public class DoublyLinkedList {
    Node start, end;
    int size;

    public DoublyLinkedList() {
        this.start = null;
        this.end = null;
        size=0;
    }

    public void insertAtPosition(int data, int pos) {
    
        Node newNode = new Node(data);
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            if (isEmpty()) {
                start = newNode;
                end = newNode;
            } else {
                newNode.setNext(start);
                start.setPrev(newNode);
                start = newNode;
            }
        } else if (pos == size) {
            end.setNext(newNode);
            newNode.setPrev(end);
            end = newNode;
        } else {
            Node current = start;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
        }
        size++;
    }

    public void deleteAtPosition(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            if (isEmpty()) {
                System.out.println("List is empty");
                return;
            }
            else if (size == 1) {
                start = null;
                end = null;
            } else {
                start = start.getNext();
                start.setPrev(null);
            }
        } else if (pos == size) {
            end = end.getPrev();
            end.setNext(null);
        } else {
            Node current = start;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        size--;
    }

    public void displayForward() {
        Node current = start;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        Node current = end;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
