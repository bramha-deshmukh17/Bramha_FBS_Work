#include <stdio.h>
void main(){
	//Q4. Write a C program to swap two numbers using a temporary third variable.

	int a=10, b=20, temp;
	printf("a=%d and b=%d\n",a,b);
	temp = a;
	a=b;
	b=temp;
	printf("a=%d and b=%d",a,b);

}