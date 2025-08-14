#include <stdio.h>
void main(){
	/*
	3. Write a C program to convert temperature from Celsius to Fahrenheit using the
	formula:
	F = (C *9/5) + 32
	*/

	double c=16.0, f;
	f=((c * 1.8) + 32);

	printf("%lf Celcius = %lf Fahrenheit", c, f);
}