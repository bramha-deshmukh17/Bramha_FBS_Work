package Assignment_3;

public class question_6 {
	/*6 Check the given number is Perfect number or not.
	Input: n = 28
	Output: Perfect*/

	
	public static void main(String args[]){
	    int n=28, sum=0, i=1;


	    while(i<n){
	        if(n%i==0)
	            sum += i;
	        
	        i++;
		}
		System.out.println(sum == n ? "Perfect" : "Not perfect");
	}
}
