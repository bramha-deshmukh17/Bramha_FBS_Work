package Assignment_5;

public class question_2 {
	/*
	Q2. Print a right-angled triangle pattern
	Input: n = 5
	Output:
	*
	**
	***
	****
	*****
	*/

	public static void main(String args[]){

	    int n=5;
	   
	    for(int i=0; i<n; i++){
	        for(int j=0; j<=i; j++){
	        	System.out.printf("* ");
	        }
	        System.out.printf("\n");
	    }
	}
}
