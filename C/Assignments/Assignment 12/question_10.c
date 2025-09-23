// Q10. Write a program to check the string is palindrome or not.

#include<stdio.h>
#include<string.h>

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

    strstr(strrev(str), strdup(str)) ? printf("Palindrome") : printf("Not palindrome");
}