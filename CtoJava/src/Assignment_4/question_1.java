package Assignment_4;

public class question_1 {
	//Q1. Print armstrong number in the given range 1 to n

	
	public static void main(String args[]){
	    int n=200, copy, sum, r;
	    
	    for(int i=1; i<=n; i++){
	        copy=i;
	        sum=0;
	        while(copy>0){
	            r = copy%10;
	            sum+=(r*r*r);
	            copy/=10;
	        }
	        if(sum==i){
	            System.out.printf("%d is Armstrong\n", i);
	        }
	    }
	}
}
