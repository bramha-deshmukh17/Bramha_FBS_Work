//strncat()

#include <stdio.h>
char* mystrncat(char* str1, char* str2, int n){

    int i=0, j=0;
    while(str1[i]!='\0'){
        i++;
    }
    while(str2[j]!='\0' && j<n){
        str1[i]=str2[j];
        i++;
        j++;
    }
    str1[i]='\0';

    return str1;
}

void main(){
    char str1[]="Bramha ";
    char str2[]="Deshmukh";
    int n=4;
    printf("Concatenated: %s", mystrncat(str1, str2, n));
}