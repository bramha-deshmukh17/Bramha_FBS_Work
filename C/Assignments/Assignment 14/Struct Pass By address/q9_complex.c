#include <stdio.h>

typedef struct Complex
{
    int real, img;
} Complex;

void store(Complex* temp)
{
    printf("Enter real part: ");
    scanf("%d", &temp->real);
    printf("Enter img part: ");
    scanf("%d", &temp->img);

}

void display(Complex* temp)
{
    printf("\nComplex - %d + %di.", temp->real, temp->img);
}
void main()
{

    Complex d;

    store(&d);
    display(&d);
}