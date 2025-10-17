package Assignment_0;

public class question_7 {
	public static void main(String args[]){
		//Q7. Write a C program to convert given minutes into hours and remaining minutes.
		int min=100, hours, remaining;

		hours=min/60;
		remaining = min%60;

		System.out.printf("Given mins=%d \n", min);
		System.out.printf("%d Hours : %d mins", hours, remaining);
	}
}
