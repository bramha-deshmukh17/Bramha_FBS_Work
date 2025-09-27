#include <stdio.h>
#include <string.h>

void rotate(char *str, int positions)
{
    char temp;
    int len = strlen(str);

    for (int i = 0; i < positions; i++)
    {
        temp = str[len-1];

        for (int j = len - 1; j > 0; j--)
            str[j] = str[j - 1];

        str[0] = temp;
    }
}

void main()
{

    char str[100];
    int num, i = 0;

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

    printf("Enter number of chars to switch: ");
    scanf("%d", &num);

    rotate(str, num);

    printf("String %s", str);
}