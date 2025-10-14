//Q1. write a program to calculate the sum of following series
//1!+2!+.....+n!

#include<stdio.h>

void main(){
    int fact = 1, num, sum=0;

    printf("Enter a number: ");
    scanf("%d", &num);

    printf("Series: ");
    for(int i=1; i<=num; i++){
        for(int j=1; j<=i; j++)
            fact*=j;
        
        sum+=fact;
        fact=1;


        printf(" %d! ", i);
        if(i!=num)
            printf(" + ");
    }

    printf("\nSum of series: %d", sum);

}

/*
OUTPUT:
e:\Bramha_FBS_Work\C\Test\End Module>cd "e:\Bramha_FBS_Work\C\Test\End Module\" && gcc question_1.c -o question_1 && "e:\Bramha_FBS_Work\C\Test\End Module\"question_1
Enter a number: 5
Series:  1!  +  2!  +  3!  +  4!  +  5!
Sum of series: 153
*/