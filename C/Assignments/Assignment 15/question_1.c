#include <stdio.h>

struct Book
{
    char bname[20];
    int id;
    char author[20];
    float price;
};

void main()
{
    struct Book b1;

    printf("Enter Book Details:\n");

    printf("Enter Book Name: ");
    scanf("%s", b1.bname); 

    printf("Enter Book ID: ");
    scanf("%d", &b1.id);

    printf("Enter Author Name: ");
    scanf("%s", b1.author);

    printf("Enter Price: ");
    scanf("%f", &b1.price);

    printf("\nBook Details Entered \n");
    printf("Book Name: %s\n", b1.bname);
    printf("Book ID: %d\n", b1.id);
    printf("Author: %s\n", b1.author);
    printf("Price: %.2f\n", b1.price);

}