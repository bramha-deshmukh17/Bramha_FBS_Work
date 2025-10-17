package Assignment_5;

public class question_5 {
	/*
	Q5. Print an inverted pyramid pattern
	Input: n = 5
	Output:

	*****
	****
	***
	**
	*
	*/

	
	public static void main(String args[]){

	    int n=5;

	    for(int i=n; i>0; i--){
	        for(int j=n; j>=i; j--){
	        	System.out.printf(" ");
	        }

	        for(int k=i; k>0; k--){
	        	System.out.printf("* ");
	        }
	        System.out.printf("\n");
	    }
	}
}
