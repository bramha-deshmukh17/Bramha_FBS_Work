//strcpy
#include<stdio.h>
#include<string.h>
char* mystrcpy(char* str2, char* str1){

    int i=0;
    while(str1[i]!='\0'){
        str2[i]=str1[i];
        i++;
    }
    str2[i]=str1[i];

    return str2;
}

void main(){

    char str1[]="Bramha Deshmukh";
    char str2[strlen(str1)];

    printf("Copied: %s", mystrcpy(str2, str1));
}