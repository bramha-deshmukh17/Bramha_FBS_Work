/*Q2 Print table for given number.
Input: n = 5
Output: 5 10 15 20 25 30 35 40 45 50*/

#include<stdio.h>
void main(){
    int n, i=1;
    printf("Enter a number: ");
    scanf("%d", &n);

    while(i<=10){
        printf("%d\t", (n*i));
        i++;
    }
}