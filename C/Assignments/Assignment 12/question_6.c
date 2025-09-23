// Q6. WAP to Take in a String and Replace Every Blank Space with special symbol.

#include<stdio.h>

void main(){

    char str[100];
    int i = 0;
    printf("Enter a string: ");
    while (i < 100)
    {
        str[i] = getchar();
        if (str[i] == '\n')
        {
            str[i] = '\0';
            break;
        }
        i++;
    }
    str[i] = '\0';

    i=0;
    while(str[i]!='\0'){
        if(str[i]==' ')
            str[i]='@';
        i++;
    }

    printf("Replaced: %s", str);

}