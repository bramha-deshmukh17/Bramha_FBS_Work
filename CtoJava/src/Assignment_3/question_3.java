package Assignment_3;

import java.util.Scanner;
public class question_3 {
	/*Q3 Sum of numbers in given range.
	Find sum of numbers from start to end.
	Input: start = 1, end = 5
	Output: 15*/

	
	public static void main(String args[]){
	    int start, end, sum=0;

	    System.out.printf("Enter start and end: ");
	    
	    Scanner sc=new Scanner(System.in);
	    start=sc.nextInt();
	    end=sc.nextInt();

	    while(start<=end){
	        sum+=start;
	        start++;
	    }
	    System.out.printf("Sum of numbers in range: %d", sum);
	    
	    sc.close();
	}
}
