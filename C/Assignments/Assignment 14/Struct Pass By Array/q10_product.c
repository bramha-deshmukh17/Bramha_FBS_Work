#include <stdio.h>

typedef struct Product
{
    int id, quantity, price;
    char name[20];
} Product;

void store(Product *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter Id: ");
        scanf("%d", &temp[i].id);
        fflush(stdin);
        printf("Enter name: ");
        gets(temp[i].name);
        printf("Enter quantity: ");
        scanf("%d", &temp[i].quantity);
    }
}

void display(Product *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("\nProduct - %d-%s-%d-%d", temp[i].id, temp[i].name, temp[i].quantity, temp[i].price);
    }
}
void main()
{

    Product d[5];

    store(d, 5);
    display(d, 5);
}
