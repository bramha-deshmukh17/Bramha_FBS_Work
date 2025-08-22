/*Q4 Check the given number is prime or not.
Input: n = 7
Output: Prime*/

#include<stdio.h>

void main(){
    int n, i=2, flag=1;
    printf("Enter a number: ");
    scanf("%d", &n);

    while(i<n){
        if(n%i==0){
            flag = 0;
            break;
        }
        i++;
    }

    //n>=2 to avoid negative and 1 to be prime
    flag && n>=2 ? printf("Prime number") : printf("Not prime number");
}