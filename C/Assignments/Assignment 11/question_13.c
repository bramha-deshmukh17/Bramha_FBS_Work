// strncmp

#include <stdio.h>
int mystrncmp(char *str1, char *str2, int n)
{
    for (int i = 0; i < n; i++)
    {
        if (str1[i] != str2[i])
        {
            if (str1[i] > str2[i])
                return 1;
            else
                return -1;
        }
        if (str1[i] == '\0')
            return 0;
    }
    return 0;
}

void main()
{

    char str1[] = "Bramha";
    char str2[] = "Bramha";

    mystrncmp(str1, str2, 3) == 0 ? printf("Same\n") : printf("Not same\n");
}