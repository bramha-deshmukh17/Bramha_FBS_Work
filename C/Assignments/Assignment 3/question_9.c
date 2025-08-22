/*Q9 Check the given number is Palindrome number or not.
Input: n = 121
Output: Palindrome*/

#include<stdio.h>
void main(){

    int n, r, sum=0, copy;
    printf("Enter a number: ");
    scanf("%d", &n);

    copy=n;

    while(n>0){
        sum=(sum*10)+(n%10);
        n/=10;
    }

    copy == sum ? printf("Palindrome") : printf("Not palindrome");
}