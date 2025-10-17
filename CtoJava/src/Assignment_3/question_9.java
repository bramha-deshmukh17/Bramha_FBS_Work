package Assignment_3;

public class question_9 {
	/*Q9 Check the given number is Palindrome number or not.
	Input: n = 121
	Output: Palindrome*/

	public static void main(String args[]){

	    int n=121, sum=0, copy;
	   
	    copy=n;

	    while(n>0){
	        sum=(sum*10)+(n%10);
	        n/=10;
	    }

	    System.out.printf(copy == sum ? "Palindrome" : "Not palindrome");
	}
}
