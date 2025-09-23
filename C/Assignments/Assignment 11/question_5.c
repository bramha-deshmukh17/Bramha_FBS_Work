//strncpy()

#include<stdio.h>
#include<string.h>
char* mystrncpy(char* dest, const char* src, int n){

    int i=0;
    for(i=0; i<n && src[i]!='\0'; i++){
        dest[i]=src[i];
    }
    for( i=n; i<strlen(dest); i++){
        dest[i]='\0';
    }

    return dest;
}

void main(){

    char str1[]="Bramha Deshmukh";
    char str2[10];

    mystrncpy(str2, str1, 5);
    printf("Copied: %s", str2);
}
