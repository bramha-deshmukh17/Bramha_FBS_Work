#include <stdio.h>

void main()
{

    int space = 6, reverse = 0;
    for (int i = 0; i < 12; i++)
    {
        if (i == 6)
            {
                reverse = 1;
                space = 2;
                continue;
            }
        if(!reverse)
        {
            for (int j = 0; j < space; j++)
            {
                printf(" ");
            }
            space--;
            for (int k = 0; k < i+1; k++)
            {
                if(k==0 || k==i)
                printf("* ");
                else
                printf("  ");
            }
        }
        else
        {
            for (int j = 0; j < space; j++)
            {
                printf(" ");
            }
            space++;
            for (int k = 0; k < 12 - i; k++)
            {
                if(k==0 || k==12-i-1)
                printf("* ");
                else
                printf("  ");
            }
        }
        printf("\n");

        
    }
}