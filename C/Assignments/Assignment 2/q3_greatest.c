// Q3. Write a program to find greatest of three numbers using nested if-else.

#include<stdio.h>

void main(){
    int a, b, c;
    printf("Enter 3 numbers:\n");

    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);

    if(a>b && a>c){
        printf("a is greater");
    }
    else{
        if(b>a && b>c){
            printf("b is greater");
        }
        else{
            printf("c is greater");
        }
    }
}