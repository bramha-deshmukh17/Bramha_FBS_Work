// Q4. WAP to Form a New String where the First Character and the Last Character have been Exchanged

#include<stdio.h>

void main(){

    char str[100];

    int i=0;
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

    char temp = str[i-1];
    str[i-1]=str[0];
    str[0]=temp;

    printf("Replaced: %s", str);

}