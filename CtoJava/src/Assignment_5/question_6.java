package Assignment_5;

public class question_6 {
	/*
	6. Print a half pyramid using numbers
	Input: n = 5
	Output:
	1
	12
	123
	1234
	12345
	*/

	public static void main(String args[]){

	    int n=5;
	    

	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=i; j++){
	        	System.out.printf("%d ", j);
	        }
	        System.out.printf("\n");
	    }
	}
}
