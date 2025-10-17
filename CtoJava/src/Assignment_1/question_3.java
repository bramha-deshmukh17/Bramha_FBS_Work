package Assignment_1;

public class question_3 {
	//Q3. Write a program to check whether a given year is a leap year.

	public static void main(String args[]){
	    int year = 1900;

	    if(year%4 == 0&& year%100 != 0 || year%400 == 0){
	        System.out.printf("Year is a leap year");
	    }
	    else{
	        System.out.printf("Year is not a leap year");
	    }
	}
}
