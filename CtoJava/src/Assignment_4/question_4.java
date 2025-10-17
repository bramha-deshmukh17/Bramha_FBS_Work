package Assignment_4;

public class question_4 {
	//Q4. Print strong numbers in the given range 1 to n.


	public static void main(String args[]){
	    int n=100, fact, newNum, sum, j, k;

	    

	    for(int i=1; i<=n; i++){
	        
	        sum=0;
	        newNum=0;
	        j=i;
	        while(j>0){
	            k=1;
	            fact = 1;
	            newNum = j%10;
	            while(k<=newNum){
	                fact *= k;
	                k++;
	            }
	    
	            sum += fact;
	            j /= 10;
	        }

	        if(i==sum)
	            System.out.printf("%d is a strong number\n", i);
	    }
	}
}
