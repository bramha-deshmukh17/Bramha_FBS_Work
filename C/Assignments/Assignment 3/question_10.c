/*Q10 Find Sum of first and last digit of given number.
Input: n = 12345
Output: 6 (1 + 5)*/

#include<stdio.h>

void main(){
    int n, last, sum;

    printf("Enter a number: ");
    scanf("%d", &n);

    last=n%10;

    while(n>=10){
        n/=10;        
    }
    sum = n + last;
    printf("%d (%d + %d)", sum, n, last);
}