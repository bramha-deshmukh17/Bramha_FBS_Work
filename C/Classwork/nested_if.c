#include<stdio.h>
void main(){
	

	int a=10, b=20, c=-30;

	if(a>b){
		if(a>c){
			printf("A is greater");
		}
		else{
			printf("C is greater");
		}
	}else{
		if(b>c){
			printf("B is greater");
		}
		else{
			printf("C is greater");
		}
	}
}