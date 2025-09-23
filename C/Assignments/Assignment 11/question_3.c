//strcmp()
#include<stdio.h>

int mystrcmp(char* str1, char* str2){

    int i=0;
    while(str1[i]!='\0' || str2[i]!='\0'){
        if(str1[i]!=str2[i] ){
           if(str1[i]>str2[i])
               return 1;
            else 
               return -1;
           
        }
        i++;
    }
    return 0;

}

void main(){

    char str1[]="Bramha";
    char str2[]="BrAmha";

    !mystrcmp(str2, str1) ? printf("Same") : printf("Not same");
}