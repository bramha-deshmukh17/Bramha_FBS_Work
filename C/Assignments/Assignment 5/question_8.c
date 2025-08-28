/*
Q8. Print a pattern of stars in diamond shape
Input: n = 4
Output:

*
**
***
****
***
**
*
*/

#include<stdio.h>
void main(){

    int n;
    printf("Enter a number: ");
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            printf("* ");
        }
        printf("\n");
    }

    for(int k=n-1; k>0; k--){
        for(int l=k; l>0; l--){
            printf("* ");
        }
        printf("\n");
    }
}