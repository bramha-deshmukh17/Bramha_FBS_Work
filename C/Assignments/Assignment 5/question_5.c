/*
Q5. Print an inverted pyramid pattern
Input: n = 5
Output:

*****
****
***
**
*
*/

#include<stdio.h>
void main(){

    int n;
    printf("Enter a numbere: ");
    scanf("%d", &n);

    for(int i=n; i>0; i--){
        for(int j=n; j>=i; j--){
            printf(" ");
        }

        for(int k=i; k>0; k--){
            printf("* ");
        }
        printf("\n");
    }
}