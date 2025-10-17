package Assignment_3;

import java.util.Scanner;
public class question_2 {
	
	/*Q2 Print table for given number.
	Input: n = 5
	Output: 5 10 15 20 25 30 35 40 45 50*/

	public static void main(String args[]){
	    int n, i=1;
	    System.out.printf("Enter a number: ");
	    
	    Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();

	    while(i<=10){
	    	System.out.printf("%d\t", (n*i));
	        i++;
	    }
	    
	    sc.close();
	}
}
