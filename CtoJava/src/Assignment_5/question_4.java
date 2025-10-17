package Assignment_5;

public class question_4 {
	/*
	Q4. pyramid pattern
	Input: n = 5
	Output:
	     *
	    * *
	   * * *
	  * * * *
	 * * * * *
	*/

	public static void main(String args[])
	{

	    int n=5, spaces;
	    
	    spaces = n;

	    for (int i = 0; i < n; i++)
	    {
	        for (int j = 0; j < spaces; j++)
	        {
	        	System.out.printf(" ");
	        }
	        for (int k = 0; k <= i; k++)
	        {
	        	System.out.printf("* ");
	        }
	        System.out.printf("\n");
	        spaces--;
	    }

	    
	}
}
