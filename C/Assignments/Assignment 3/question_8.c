/*Q8 Check the given number is Strong number or not.
Input: n = 145
Output: Strong*/

#include<stdio.h>
void main(){

    int n, copy, sum = 0, i, newNum, fact;
    
    printf("Enter a number: ");
    scanf("%d", &n);
    copy = n;

    while(n>0){
        i=1;
        fact = 1;
        newNum = n%10;
        while(i<=newNum){
            fact *= i;
            i++;
        }

        sum += fact;
        n /= 10;
    }

    sum == copy ? printf("Strong") : printf("Not strong");
}