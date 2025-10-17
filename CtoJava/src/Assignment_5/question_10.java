package Assignment_5;

public class question_10 {
	/*
	Q10. Print a hollow square with diagonal pattern
	Input: n = 5
	Output:

	* * * * *
	* *     *
	*   *   *
	*     * *
	* * * * *
	*/

	
	public static void main(String args[]){

	    int n=5;
	    for (int i = 1; i <= n; i++)
	    {
	        for (int j = 1; j <= n; j++)
	        {
	            if (i == 1 || i == n || j == 1 || j == n || i==j)
	            	System.out.printf("* ");
	            else
	            	System.out.printf("  ");
	        }
	        System.out.printf("\n");
	    }
	}
}
