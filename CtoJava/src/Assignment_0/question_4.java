package Assignment_0;

public class question_4 {
   public static void main(String args[]){
		//Q4. Write a C program to swap two numbers using a temporary third variable.

		int a=10, b=20, temp;
		System.out.printf("a=%d and b=%d\n",a,b);
		temp = a;
		a=b;
		b=temp;
		System.out.printf("a=%d and b=%d",a,b);

	}
}
