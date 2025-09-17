#include <stdio.h>

void main()
{

    char str[10] = "String";

    char abc[10] = {'a', 'b', 'c', 'c', 'd'};

    for (int i = 0; i < 10; i++)
    {
        printf("%c", abc[i]);
        if (abc[i] == '\0')
            printf("null");
    }
    printf("\n");

    for (int i = 0; i < 10; i++)
    {
        printf("%c", str[i]);
        if (str[i] == '\0')
            printf("null");
    }

    int i = 0;
    printf("\n");

    while (str[i] != '\0')
    {
        printf("%c", str[i]);
        i++;
    }

    printf("\n%s", str);
}