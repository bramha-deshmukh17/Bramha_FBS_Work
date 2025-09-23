//strlen()
#include<stdio.h>

int mystrlen(char* str){

    int i=0;
    while(str[i]!='\0')
        i++;
    return i;
}

void main(){

    char str1[] = "Bramha";

    printf("Length: %d", mystrlen(str1));

}