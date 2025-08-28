/*
Q1. Print a solid square pattern
Input: n = 4
Output:

* * * *
* * * *
* * * *
* * * *
*/

#include<stdio.h>
void main(){

    int n;
    printf("Enter a number: ");
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            printf("* ");
        }
        printf("\n");
    }
}