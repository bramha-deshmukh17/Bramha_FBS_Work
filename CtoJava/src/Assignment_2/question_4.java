package Assignment_2;

import java.util.Scanner;

public class question_4 {
	/*Q4. Ask the user to enter marks.
	Then show the result based on these rules:
	If marks are more than 75 → show "Distinction"
	If marks are more than 65 → show "First Class"
	If marks are more than 55 → show "Second Class"
	If marks are 40 or more → show "Pass Class"
	If marks are less than 40 → show "Fail"*/

	public static void main(String args[]){

	    int marks;
	    System.out.printf("Enter total marks: ");

	    Scanner sc=new Scanner(System.in);
	    marks=sc.nextInt();
	    
	    if(marks>75){
	    	System.out.printf("Distinction");
	    }
	    else if(marks>65){
	    	System.out.printf("First class");
	    }
	    else if(marks>55){
	    	System.out.printf("Second class");
	    }
	    else if(marks>40){
	    	System.out.printf("Pass class");
	    }
	    else{
	    	System.out.printf("Fail");
	    }
	    sc.close();
	}
}
