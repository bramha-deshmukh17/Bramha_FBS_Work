//strrev()
#include<stdio.h>
#include<string.h>
char* mystrrev(char* str1){

    int i=strlen(str1)-1, j=0;
    char temp;
    
    while(i>j){
        temp=str1[i];
        str1[i]=str1[j];
        str1[j]=temp;
        i--;
        j++;
    }

    return str1;
}

void main(){

    char str1[]="Bramha";

    printf("Reversed: %s", mystrrev(str1));

}