package Assignment_3;

public class question_10 {
	/*Q10 Find Sum of first and last digit of given number.
	Input: n = 12345
	Output: 6 (1 + 5)*/


	public static void main(String args[]){
	    int n=12345, last, sum;

	   
	    last=n%10;

	    while(n>=10){
	        n/=10;        
	    }
	    sum = n + last;
	    System.out.printf("%d (%d + %d)", sum, n, last);
	}
}
