// Q8. WAP to Calculate the Number of Words Present in a String

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

    i=0;
    char *ptr4 = strtok(str, " ");
    int count = 0;
    while (ptr4)
    {
        ptr4 = strtok(NULL, " ");
        count++;
    }
    printf("Words count: %d", count);
}