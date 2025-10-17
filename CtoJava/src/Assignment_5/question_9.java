package Assignment_5;

public class question_9 {
	/*
	Q9. Print a hollow square pattern
	Input: n = 4
	Output:

	* * * *
	*     *
	*     *
	* * * *
	*/

	
	public static void main(String args[]){
	    int n=4;

	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=n; j++){
	            if(i==1 || i==n || j==1 || j==n)
	            	System.out.printf("* ");
	            else
	            	System.out.printf("  ");
	        }
	        System.out.printf("\n");
	    }
	}
}
