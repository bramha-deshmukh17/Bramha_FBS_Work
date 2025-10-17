package Assignment_4;

public class question_2 {
	//Q2. Print prime numbers in the given range 1 to n.

	
	public static void main(String args[]){

	    int n=100, flag;

	   

	    for(int i=2; i<=n; i++){
	        flag=1;

	        for(int j=2; j<i; j++){
	            if(i%j == 0){
	                flag =0;
	                break;
	            }
	        }

	        if(flag==1){
	            System.out.printf("%d is prime\n", i);
	        }
	    }
	}
}
