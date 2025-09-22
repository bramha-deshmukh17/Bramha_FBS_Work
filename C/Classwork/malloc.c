#include<stdio.h>
#include<stdlib.h>
void main(){

    int* ptr = (int*)malloc(sizeof(int)*6);

    printf("Address of %u", ptr);
}