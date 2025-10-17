package Assignment_4;

import java.util.Scanner;

public class question_5 {
    /*
     * Q5. Write a menu driven program to take a number for user and perform
     * operations as follows.
     * 
     * Press 1.To check number is even or odd.
     * 2.To check number is prime or not.
     * 3.To check number is pallindrome or not.
     * 4.To check number is positive, negative or zero.
     * 5.To reverse a number.
     * 6.To find sum of digits.
     */

    public static void main(String args[]) {

        int choice, num = 0;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Press 0.To exit");
            System.out.println("Press 1.To check number is even or odd");
            System.out.println("Press 2.To check number is prime or not.");
            System.out.println("Press 3.To check number is pallindrome or not.");
            System.out.println("Press 4.To check number is positive, negative or zero.");
            System.out.println("Press 5.To reverse a number.");
            System.out.println("Press 6.To find sum of digits.");
            System.out.print("Enter a choice: ");
            choice = sc.nextInt();
            if (choice == 0) {
                break;
            }
            System.out.print("Enter a number: ");
            num = sc.nextInt();
            if (choice == 1) {
                System.out.println("\n\n" + num + (num % 2 == 0 ? " is even number" : " is odd number"));
            } else if (choice == 2) {
                boolean flag = true;
                if (num <= 1)
                    flag = false;
                for (int i = 2; i < num && flag; i++) {
                    if (num % i == 0) {
                        flag = false;
                    }
                }
                System.out.println("\n\n" + num + (flag ? " is Prime number" : " is not Prime number"));
            } else if (choice == 3) {
                int sum = 0, copy = num;
                while (copy > 0) {
                    sum = (sum * 10) + (copy % 10);
                    copy /= 10;
                }
                System.out.println("\n\n" + num + (sum == num ? " is palindrome number" : " is not palindrome number"));
            } else if (choice == 4) {
                if (num > 0)
                    System.out.println("\n\n" + num + " is positive number");
                else if (num < 0)
                    System.out.println("\n\n" + num + " is negative number");
                else
                    System.out.println("\n\nZero");
            } else if (choice == 5) {
                int sum = 0, copy = num;
                while (copy > 0) {
                    sum = (sum * 10) + (copy % 10);
                    copy /= 10;
                }
                System.out.println("\n\n" + sum + " is reverse of " + num);
            } else if (choice == 6) {
                int sum = 0, copy = num;
                while (copy > 0) {
                    sum += copy % 10;
                    copy /= 10;
                }
                System.out.println("\n\nSum of digits of " + num + ": " + sum);
            } else {
                if (choice != 0)
                    System.out.println("\n\nPlease select valid choice");
            }
            if (choice != 0)
                System.out.println("\n\n\nPress 0.To exit.\n");
        } while (choice != 0);

        sc.close();
    }
}
