package Assignment_3;

public class question_8 {
	/*Q8 Check the given number is Strong number or not.
	Input: n = 145
	Output: Strong*/

	public static void main(String args[]){

	    int n=145, copy, sum = 0, i, newNum, fact;
	    
	    copy = n;

	    while(n>0){
	        i=1;
	        fact = 1;
	        newNum = n%10;
	        while(i<=newNum){
	            fact *= i;
	            i++;
	        }

	        sum += fact;
	        n /= 10;
	    }

	    System.out.println(sum == copy ? "Strong" : "Not strong");
	}
}
