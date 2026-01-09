package classwork.jan08;

import java.util.Scanner;

public class DoublyListDemo {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.println("1. Insert at Position");
            System.out.println("2. Delete at Position");
            System.out.println("3. Display List - forward");
            System.out.println("4. Display List - backward");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int data = sc.nextInt();
                    System.out.print("Enter position to insert at: ");
                    int pos = sc.nextInt();
                    dll.insertAtPosition(data, pos);
                    break;
                case 2:
                    System.out.print("Enter position to delete from: ");
                    int delPos = sc.nextInt();
                    dll.deleteAtPosition(delPos);
                    break;
                case 3:
                    dll.displayForward();
                    break;
                case 4:
                    dll.displayBackward();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
