package Assignment_3;

public class question_7 {
	/*Q7 Find factorial of given number.
	Input: n = 5
	Output: 120*/

	
	public static void main(String args[]){
	    int fact = 1, n=5, i=1;
	    

	    while(i<=n){
	        fact *= i;
	        i++;
	    }

	    System.out.printf("%d", fact);
	}
}
