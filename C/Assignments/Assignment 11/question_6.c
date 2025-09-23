//strupper()
#include<stdio.h>

char* mystrupper(char* str1){

    int i=0;
    while(str1[i]!='\0'){
        if(str1[i]>='a' && str1[i]<='z'){
            str1[i]=str1[i]-32;
        }
        i++;
    }

    return str1;
}

void main(){
    char str1[]="Bramha";

    printf("Uppercase: %s", mystrupper(str1));
}