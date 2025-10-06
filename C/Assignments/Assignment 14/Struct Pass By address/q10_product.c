#include <stdio.h>

typedef struct Product
{
    int id, quantity, price;
    char name[20];
} Product;

void store(Product* temp)
{
    printf("Enter Id: ");
    scanf("%d", &temp->id);
    fflush(stdin);
    printf("Enter name: ");
    gets(temp->name);
    printf("Enter quantity: ");
    scanf("%d", &temp->quantity);
}

void display(Product* temp)
{
    printf("\nProduct - %d-%s-%d-%d", temp->id, temp->name, temp->quantity, temp->price);
}
void main()
{

    Product d;

    store(&d);
    display(&d);
}
 