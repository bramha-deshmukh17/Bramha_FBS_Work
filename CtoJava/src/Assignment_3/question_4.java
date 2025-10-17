package Assignment_3;

public class question_4 {
	/*Q4 Check the given number is prime or not.
	Input: n = 7
	Output: Prime*/

	

	public static void main(String args[]){
	    int n=5, i=2, flag=1;
	    

	    while(i<n){
	        if(n%i==0){
	            flag = 0;
	            break;
	        }
			i++;
		}

		System.out.println((flag == 1 && n >= 2) ? "Prime number" : "Not prime number");
	}
}
