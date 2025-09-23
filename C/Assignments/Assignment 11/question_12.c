//strrchr()

#include <stdio.h>
#include <string.h>
char* mystrrchr(char *str1, int ch)
{

    int i = strlen(str1) - 1;
    while (i>=0)
    {
        if (str1[i] == ch)
        {
            return &str1[i];
        }
        i--;
    }

    return NULL;
}
void main()
{

    char str1[] = "Bramha";
    char ch = 'a';

    char *result = mystrrchr(str1, ch);
    result ? printf("Character found: %s\n", result) : printf("Character not found\n");
}