/*
Q7. Print a Floyd’s triangle pattern
Input: n = 4
Output:
1
2 3
4 5 6
7 8 9 10
*/

#include<stdio.h>
void main(){
    int n, count=1;
    printf("Enter a number: ");
    scanf("%d", &n);

    for(int i=0; i<5; i++){
        for(int j=0; j<=i; j++){
            printf("%d ", count);
            count++;
        }
        printf("\n");
    }
}