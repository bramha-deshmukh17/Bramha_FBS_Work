#include <stdio.h>

int numisPrime(int num)
{
    if (num == 1 )
        return 1;
    for (int i = 2; i * i <= num; i++)
    {
        if (num % i == 0)
            return 0;
    }
    return 1;
}

void main()
{

    int num = 1;
    for (int i = 0; i < 5; i++)
    {
        int j = 0;
        while (j <= i)
        {
            if (numisPrime(num) && num%2!=0)
            {
                printf("%d ", num);
                j++;
            }
            num++;
        }
        printf("\n");
    }
}