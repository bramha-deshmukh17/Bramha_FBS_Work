package Assignment_5;

public class question_7 {
	/*
	Q7. Print a Floyd’s triangle pattern
	Input: n = 4
	Output:
	1
	2 3
	4 5 6
	7 8 9 10
	*/

	public static void main(String args[]){
	    int n=4, count=1;
	    

	    for(int i=0; i<n; i++){
	        for(int j=0; j<=i; j++){
	        	System.out.printf("%d ", count);
	            count++;
	        }
	        System.out.printf("\n");
	    }
	}
}
