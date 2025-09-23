// Q9. WAP to Take in Two Strings and Display the Larger String without Using Built-in Functions

#include <stdio.h>

int mystrcmp(char *str1, char *str2)
{

    int i = 0;
    while (str1[i] != '\0' || str2[i] != '\0')
    {
        if (str1[i] != str2[i])
        {
            if (str1[i] > str2[i])
                return 1;
            else
                return -1;
        }
        i++;
    }
    return 0;
}

void main()
{

    char str1[] = "Bramha";
    char str2[] = "BrAmha";

    int res = mystrcmp(str2, str1);

    if (res == -1)
        printf("Str1 is bigger");
    else if (res == 1)
        printf("Str2 is bigger");
    else
        printf("Not same");
}