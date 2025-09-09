#include<stdio.h>

void main(){

    int a=10, b=30;
    int* ptr=&a;
    int* pt=&b;

    *pt=25;
    printf("%d\t", *ptr);
    printf("%d\t", *pt);

    b=*ptr;
    printf("%d\t", b);

    printf("%u\t", pt);
    pt=ptr;
    printf("%u\t", pt);
}