#include <stdio.h>
void main(){
	//Q9. Write a C program to input the base and height of a triangle and calculate its area.

	int base=10, height=15;
	float area;

	area = 0.5 * base * height;

	printf("Base:%d, Height:%d, Area=%f", base, height, area);
}