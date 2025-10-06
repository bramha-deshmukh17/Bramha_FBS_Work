#include <stdio.h>

typedef struct Product
{
    int id, quantity, price;
    char name[20];
} Product;

Product store()
{
    Product temp;
    printf("Enter Id: ");
    scanf("%d", &temp.id);
    fflush(stdin);
    printf("Enter name: ");
    gets(temp.name);
    printf("Enter quantity: ");
    scanf("%d", &temp.quantity);

    printf("Enter price: ");
    scanf("%d", &temp.price);

    return temp;
}

void display(Product temp)
{
    printf("\nProduct - %d-%s-%d-%d", temp.id, temp.name, temp.quantity, temp.price);
}
void main()
{

    Product d;

    d = store();
    display(d);
}