package Assignment_2;
import java.util.Scanner;

public class question_1 {

	// Q1. Accept two numbers from user and an operator (+,-,/,*,%) based on that perform the desired operations.
	public static void main(String args[]){
	    int num1, num2, operation;
	    System.out.printf("Enter two numbers: ");
	    
	    Scanner sc=new Scanner(System.in);
	    num1=sc.nextInt();
	    num2=sc.nextInt();
	    
	    System.out.printf("1. Addition\n2. Subtrction\n3. Multiplication\n4. Division\n5. Reminder\nEnter what to perform opration: ");
	    operation=sc.nextInt();
	    
	    if (operation >= 1 && operation <= 5)
	    {
	        if (operation == 1)
	        {
	            System.out.printf("Addition: %d", num1 + num2);
	        }
	        else if (operation == 2)
	        {
	            System.out.printf("Subtraction: %d", num1 - num2);
	        }
	        else if (operation == 3)
	        {
	            System.out.printf("Multiplication: %d", num1 * num2);
	        }
	        else if (operation == 4)
	        {
	            System.out.printf("Division: %d", num1 / num2);
	        }
	        else
	        {
	            System.out.printf("Reminder: %d", num1 % num2);
	        }
	    }
	    else{
	        System.out.printf("Enter a valid option");
	    }
	    sc.close();
	}
}
