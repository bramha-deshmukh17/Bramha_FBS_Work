// Q2. WAP Replace all Occurrences of ‘a’ with $ in a String

#include <stdio.h>
void main()
{
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

    i = 0;
    while (str[i] != '\0')
    {
        if (str[i] == 'a')
            str[i]='@';
        i++;
    }

    printf("After replacement: %s", str);

}