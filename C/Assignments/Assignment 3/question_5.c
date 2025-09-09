/*Q5 Check the given number is Armstrong number or not..
Input: n = 153
Output: Armstrong*/

#include<stdio.h>
void main(){

    int n, r, sum=0, copy, power=0, res=1;

    printf("Enter a number: ");
    scanf("%d", &n);
    copy = n;

    int dummy = n;
    while(dummy!=0){
        dummy/=10;
        ++power;
    }
    while(n>0){
        r = n%10;
        res=1;

        for(int i=1; i<=power; i++)
            res*=r;
        
        sum+=(res);

        n/=10;
    }

    copy==sum ? printf("Armstrong") : printf("Not Armstrong");

}