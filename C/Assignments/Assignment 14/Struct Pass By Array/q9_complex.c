#include <stdio.h>

typedef struct Complex
{
    int real, img;
} Complex;

void store(Complex *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter real part: ");
        scanf("%d", &temp[i].real);
        printf("Enter img part: ");
        scanf("%d", &temp[i].img);
    }
}

void display(Complex *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("\nComplex - %d + %di.", temp[i].real, temp[i].img);
    }
}
void main()
{

    Complex d[5];

    store(d, 5);
    display(d, 5);
}