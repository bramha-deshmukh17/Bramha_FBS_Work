//strcat()

#include<stdio.h>

char* mystrcat(char* str1, char* str2){

    int i=0, j=0;
    while(str1[i]!='\0'){
        i++;
    }
    while(str2[j]!='\0'){
        str1[i]=str2[j];
        i++;
        j++;
    }
    str1[i]=str2[j];

    return str1;
}

void main(){
    char str1[]="Bramha ";
    char str2[]="Deshmukh";
    printf("Concatenated: %s", mystrcat(str1, str2));
}