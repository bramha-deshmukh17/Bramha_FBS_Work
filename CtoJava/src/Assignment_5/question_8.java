package Assignment_5;

public class question_8 {
	/*
	Q8. Print a pattern of stars in diamond shape
	Input: n = 4
	Output:

	*
	**
	***
	****
	***
	**
	*
	*/

	public static void main(String args[]){

	    int n=4;


	    for(int i=0; i<n; i++){
	        for(int j=0; j<=i; j++){
	        	System.out.printf("* ");
	        }
	        System.out.printf("\n");
	    }

	    for(int k=n-1; k>0; k--){
	        for(int l=k; l>0; l--){
	        	System.out.printf("* ");
	        }
	        System.out.printf("\n");
	    }
	}
}
