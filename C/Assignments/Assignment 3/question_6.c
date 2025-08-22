/*6 Check the given number is Perfect number or not.
Input: n = 28
Output: Perfect*/

#include<stdio.h>
void main(){
    int n, sum=0, i=1;

    printf("Enter a number: ");
    scanf("%d", &n);

    while(i<n){
        if(n%i==0)
            sum += i;
        
        i++;
    }
    sum == n ? printf("Perfect") : printf("Not perfect");
}