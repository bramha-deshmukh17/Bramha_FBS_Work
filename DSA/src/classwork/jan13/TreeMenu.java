package classwork.jan13;

import java.util.Scanner;

public class TreeMenu {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu:");
            System.out.println("1. Insert Data");
            System.out.println("2. Display Tree");
            System.out.println("3. Delete Data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer to insert: ");
                    int data = scanner.nextInt();
                    bst.insertData(data);
                    System.out.println(data + " inserted into the tree.");
                    break;
                case 2:
                    System.out.println("Display Options:");
                    System.out.println("1. Inorder");
                    System.out.println("2. Preorder");
                    System.out.println("3. Postorder");
                    System.out.print("Enter your choice: ");
                    int displayChoice = scanner.nextInt();
                    bst.display(displayChoice);
                    break;
                case 3:
                    System.out.print("Enter num to delete: ");
                    int deleteData = scanner.nextInt();
                    bst.deleteData(deleteData);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
