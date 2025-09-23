//strncasecmp()
#include <stdio.h>
char flip(char ch)
{
    if (ch >= 'A' && ch <= 'Z')
        return ch + 32;
    else if (ch >= 'a' && ch <= 'z')
        return ch - 32;
    else
        return ch;
}
int mystrncasecmp(char *str1, char *str2, int n)
{

    for (int i = 0; i < n; i++)
    {
        if (str1[i] != str2[i] && flip(str1[i]) != str2[i])
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
    char str2[] = "BrAmha";

    mystrncasecmp(str1, str2, 6) == 0 ? printf("Same\n") : printf("Not same\n");
}