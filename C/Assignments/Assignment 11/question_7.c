//strlower()

#include<stdio.h>

char* mystrlower(char* str1){

    int i=0;
    while(str1[i]!='\0'){
        if(str1[i]>='A' && str1[i]<='Z'){
            str1[i]=str1[i]+32;
        }
        i++;
    }

    return str1;
}

void main(){
    char str1[]="BRAMHA";

    printf("Lowercase: %s", mystrlower(str1));
}