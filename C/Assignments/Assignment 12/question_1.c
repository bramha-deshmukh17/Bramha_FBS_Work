// Q1. Write a program to scan string from user then scan a single character and search it in a accepted string.


#include <stdio.h>
void main()
{
    char str[100];
    char ch;
    int i=0, flag = 0;

    printf("Enter a string: ");
    while(i<100){
        str[i]=getchar();
        if(str[i]=='\n'){
            str[i]='\0';
            break;
        }
    } 

    printf("Enter a character to search: ");
    scanf("%c", &ch);
    i=0;
    while ( str[i] != '\0')
    {
        if (str[i] == ch)
        {
            flag = 1;
            break;
        }
        i++;
    }

    if (flag)
        printf("Found");
    else
        printf("Not found");

}