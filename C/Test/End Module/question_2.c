// Q2. Write a program to count frequency of each character (e.g. rare r-2, a-1, e-1)

#include <stdio.h>
#include <string.h>
void main()
{

    char str[100];
    int i = 0, j = 0, count = 0;

    printf("Enter a string: ");
    gets(str);

    int len = strlen(str);

    printf("Character frequencies: ");

    for (i = 0; i < len; i++)
    {
       
        if (str[i] != ' ')
        {
            char ch = str[i];
            count = 1; 

            for (j = i + 1; j < len; j++)
            {
                if (ch == str[j])
                {
                    count++;
                    str[j] = ' ';
                }
            }
            printf("%c-%d ", ch, count);
        }
    }

}

/*
OUTPUT:
e:\Bramha_FBS_Work\C\Test\End Module>cd "e:\Bramha_FBS_Work\C\Test\End Module\" && gcc question_2.c -o question_2 && "e:\Bramha_FBS_Work\C\Test\End Module\"question_2
Enter a string: Brammha Deshmukh
Character frequencies: B-1 r-1 a-2 m-3 h-3 D-1 e-1 s-1 u-1 k-1
*/