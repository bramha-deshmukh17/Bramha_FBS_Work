/*
Q3. Print an inverted right-angled triangle pattern
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
    printf("Enter a number: ");
    scanf("%d", &n);

    for(int i=n; i>0; i--){
        for(int j=i; j>0; j--){
            printf("* ");
        }
        printf("\n");
    }
}