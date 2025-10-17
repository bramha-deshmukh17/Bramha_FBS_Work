package Assignment_2;

import java.util.Scanner;

public class question_7 {
	/*Q7. Accept the age and check if the person is:
	Child (age < 12),Teenager (12–19),Adult (20–59),Senior (60 and above)*/


	public static void main(String args[]){

	    int age;
	    System.out.printf("Enter age: ");
	    
	    Scanner sc=new Scanner(System.in);
	    age=sc.nextInt();
	    if(age<12){
	    	System.out.printf("Child");
	    }
	    else if(age>=12 && age<=19){
	    	System.out.printf("Teenager");
	    }
	    else if(age>=20 && age<=59){
	    	System.out.printf("Adult");
	    }
	    else{
	    	System.out.printf("Senior");
	    }
	
	sc.close();
	}
	
}
