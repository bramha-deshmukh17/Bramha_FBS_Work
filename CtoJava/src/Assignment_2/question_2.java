package Assignment_2;

import java.util.Scanner;
public class question_2 {
	// Q2. Accept three sides of a triangle from the user and determine whether the triangle is equilateral, isosceles, or scalene.
	
	public static void main(String args[])
	{
	    int a, b, c;
	    System.out.printf("Enter sides of th triangle:\n");

	    Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

	    if(a==b && b==c){
	        System.out.printf("Equilateral triangle");
	    }
	    else{
	        if(a==b || b==c || a==c){
	            System.out.printf("Isosceles triangle");
	        }
	        else{
	            System.out.printf("Scalene triangle");
	        }
	    }

sc.close();
	}
}
