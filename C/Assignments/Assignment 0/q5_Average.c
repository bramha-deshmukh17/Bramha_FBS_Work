#include <stdio.h>
void main(){
	//Q5. Write a C program to input five numbers and find their average
	int num1=15, num2=25, num3=35, num4=45, num5=55;
	float average;
	average=(num1+num2+num3+num4+num5)/5;
	printf("Average of %d, %d, %d, %d & %d is %f", num1, num2, num3, num4, num5, average);
}