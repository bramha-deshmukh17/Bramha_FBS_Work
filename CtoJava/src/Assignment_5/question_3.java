package Assignment_5;

public class question_3 {
	/*
	Q3. Print an inverted right-angled triangle pattern
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
	        for(int j=i; j>0; j--){
	        	System.out.printf("* ");
	        }
	        System.out.printf("\n");
	    }
	}
}
