/*Q7 Find factorial of given number.
Input: n = 5
Output: 120*/

#include<stdio.h>
void main(){
    int fact = 1, n, i=1;
    printf("Enter a number: ");
    scanf("%d", &n);

    while(i<=n){
        fact *= i;
        i++;
    }

    printf("%d", fact);
}