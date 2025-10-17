package Assignment_0;

public class question_10 {
	public static void main(String args[]){
		//Q10. Write a C program to input marks of five subjects, find the total marks, and calculate the percentage.

		int m1=45, m2=66, m3=58, m4=90, m5=38, total;
		float percentage;

		total = m1+m2+m3+m4+m5;
		percentage = (float) ((total/500.0)*100);

		System.out.printf("Total=%d, Percentage=%f", total, percentage);
	}
}
