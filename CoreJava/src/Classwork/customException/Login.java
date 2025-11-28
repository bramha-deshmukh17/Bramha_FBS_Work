package Classwork.customException;

import java.util.Scanner;

class Login {

    static String username = "admin";
    static String password = "12345";

    static void validateUsername(String enteredUsername) throws InvalidUsernameException {
        if (!enteredUsername.equals(username)) {
            throw new InvalidUsernameException();
        }
    }

    static void validatePassword(String enteredPassword) throws InvalidPasswordException {
        if (!enteredPassword.equals(password)) {
            throw new InvalidPasswordException();
        }
    }
}

class LoginTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String enteredUsername = sc.next();

        try {
            Login.validateUsername(enteredUsername);
            System.out.println("Username Verified");

            int attempts = 3;

            while (attempts > 0) {

                System.out.print("Enter Password: ");
                String enteredPassword = sc.next();

                try {
                    Login.validatePassword(enteredPassword);
                    System.out.println("\nLogin Successful!");
                    return;
                } catch (InvalidPasswordException e) {
                    attempts--;
                    System.out.println(e);
                    if (attempts > 0) {
                        System.out.println("Attempts remaining: " + attempts + "\n");
                    }
                }
            }

            System.out.println("\nAccount Locked!");
        }
        catch (InvalidUsernameException e) {
            System.out.println(e);
        }

        sc.close();
    }
}
