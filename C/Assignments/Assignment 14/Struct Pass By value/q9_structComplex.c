#include <stdio.h>

typedef struct Complex
{
    int real, img;
} Complex;

Complex store()
{
    Complex temp;
    printf("Enter real part: ");
    scanf("%d", &temp.real);
    printf("Enter img part: ");
    scanf("%d", &temp.img);

    return temp;
}

void display(Complex temp)
{
    printf("\nComplex - %d + %di.", temp.real, temp.img);
}
void main()
{

    Complex d;

    d = store();
    display(d);
}