#include<stdio.h>

void main(){

    int a=10;
    int* ptr=&a;
    
    printf("address: %u", ptr);
    printf("\naddress: %u", ptr+1);
    printf("\naddress: %u", ptr+2);
    printf("\nvalue: %d", *ptr);
    
    printf("\nvalue: %d", *ptr++);
    printf("\nvalue: %d", (*ptr)++);
    /*
    we can't do like *(ptr+2)=10;
    this will give error
    */
}