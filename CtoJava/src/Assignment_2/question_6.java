package Assignment_2;

import java.util.Scanner;
public class question_6 {

	/*Q6. Accept a number and check if it is divisible by 3, 5, or both.
	(Print "Divisible by 3 but not by 5" or "Divisible by 5 but not by 3" or "Divisible by
	both" or” Divisible by None”)*/

	public static void main(String args[]){

	    int num;
	    System.out.printf("Enter a number: ");
	    Scanner sc=new Scanner(System.in);
		num=sc.nextInt();

	    if(num%3 ==0 && num%5 == 0){
	    	System.out.printf("Divisible by both");
	    }
	    else if(num%3 == 0){
	    	System.out.printf("Divisible by 3 but not by 5");
	    }
	    else if(num%5 == 0){
	    	System.out.printf("Divisible by 5 but not by 3");

	    }
	    else{
	    	System.out.printf("Divisible by None");
	    }
	    sc.close();
	}
}
