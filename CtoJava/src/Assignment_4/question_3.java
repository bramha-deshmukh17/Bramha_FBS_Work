package Assignment_4;

public class question_3 {
	//Q3. Print perfect numbers in the given range 1 to n.

	
	public static void main(String args[]){

	    int j, n=100, sum;

	    

	    for(int i=1; i<=n; i++){
	        sum=0;
	        j=1;
	        while(j<i){
	            if(i%j==0)
	                sum += j;
	                j++;
	        }

	        if(sum==i)
	            System.out.printf("%d is perfect number\n", i);
	        
	    }
	}
}
