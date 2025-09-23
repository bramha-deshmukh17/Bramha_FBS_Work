//WAP print even and odd numbers in a given range

#include<stdio.h>

void main(){

    int start, end;
    printf("Enter start and end: ");
    scanf("%d %d", &start, &end);

    for(int i=start; i<=end; i++)
        i%2 ? printf("\n%d odd", i) : printf("\n%d even", i);
    
}