package assignment.assignment3;

import java.util.Scanner;

public class ListDemo {
    public static void main(String[] args) {
        SortedLinkedList sll = new SortedLinkedList();
        int choice = 1;
        Scanner sc = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("\n1. To insert");
            System.out.println("2. To display");
            System.out.println("0. To Exit");
            System.out.print("Enter a choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number to insert: ");
                    sll.insert(sc.nextInt());
                    break;

                case 2:
                    sll.display();
                    break;

                case 0:
                    System.out.println("Exited!");
                    break;
            }
        }
    }
}
