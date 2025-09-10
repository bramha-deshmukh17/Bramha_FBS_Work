//WAP to check if number is positive, negative or neutral (0)

#include<stdio.h>

void main(){

    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    if(num>0)
        printf("Positive Number");
    else if(num<0)
        printf("Negative Number");
    else
        printf("Neutral (0)");
}