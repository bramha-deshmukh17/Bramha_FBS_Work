// strchr()

#include <stdio.h>
char* mystrchr(char* str1, int ch){

    int i=0;
    while(str1[i]!='\0'){
        if(str1[i]==ch){
            return &str1[i];
        }
        i++;
    }

    return NULL;
}
void main()
{

    char str1[] = "Bramha";
    char ch = 'a';

    char* result = mystrchr(str1, ch);
    result ? printf("Character found: %s\n",result) : printf("Character not found\n");
}