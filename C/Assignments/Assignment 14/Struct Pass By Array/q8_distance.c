#include <stdio.h>

typedef struct Distance
{
    int feet, inch;
} Distance;

void store(Distance *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter feet: ");
        scanf("%d", &temp[i].feet);
        printf("Enter inch: ");
        scanf("%d", &temp[i].inch);
    }
}

void display(Distance *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("\nDistance - %dft. %din.", temp[i].feet, temp[i].inch);
    }
}
void main()
{

    Distance d[5];

    store(d, 5);
    display(d, 5);
}