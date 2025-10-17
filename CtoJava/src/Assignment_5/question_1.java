package Assignment_5;

public class question_1 {
	/*
	Q1. Print a solid square pattern
	Input: n = 4
	Output:

	* * * *
	* * * *
	* * * *
	* * * *
	*/

	
	public static void main(String args[]){

	    int n=4;
	   
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            System.out.printf("* ");
	        }
	        System.out.printf("\n");
	    }
	}
}
