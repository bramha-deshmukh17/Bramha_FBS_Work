// Q3. WAP to Remove the nth Index Character from a Non-Empty String

#include<stdio.h>

void main(){

    char str[100];
    int i = 0, index;

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

    printf("Enter index at which char to be removed: ");
    scanf("%d", &index);

    i=0;
    while(str[i]!='\0'){
        if(i>=index)
            str[i]=str[i+1];
        i++;
        printf("%c",str[i]);
    }
    str[i]='\0';
    printf("Removed: %s", str);
}