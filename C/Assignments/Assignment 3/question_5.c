/*Q5 Check the given number is Armstrong number or not..
Input: n = 153
Output: Armstrong*/

#include<stdio.h>
void main(){

    int n, r, sum=0, copy;

    printf("Enter a number: ");
    scanf("%d", &n);
    copy = n;

    while(n>0){
        r = n%10;
        sum+=(r*r*r);

        n/=10;
    }

    copy==sum ? printf("Armstrong") : printf("Not Armstrong");

}