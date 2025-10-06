#include <stdio.h>
#include <string.h>

typedef struct Product
{
    int id;
    char name[50];
    float price;
} Product;

typedef struct CartItem
{
    Product product;
    int quantity;
}CartItem;

void displayProducts(Product* products, int n)
{
    printf("\n Available Products \n");
    for (int i = 0; i < n; i++)
    {
        printf("%d. %s - $%.2f\n", products[i].id, products[i].name, products[i].price);
    }
}

void addItemToCart(Product* products, int productCount, CartItem* cart, int *cartItemCount)
{
    displayProducts(products, productCount);
    int productID, quantity;
    printf("Enter Product ID to add: ");
    scanf("%d", &productID);
    printf("Enter quantity: ");
    scanf("%d", &quantity);

    if (productID > 0 && productID <= productCount)
    {
        if (*cartItemCount < 10)
        {
            cart[*cartItemCount].product = products[productID - 1];
            cart[*cartItemCount].quantity = quantity;
            (*cartItemCount)++;
            printf("Item added to cart!\n");
        }
        else
        {
            printf("Cart is full.\n");
        }
    }
    else
    {
        printf("Invalid Product ID.\n");
    }
}

void viewCartAndCheckout(CartItem* cart, int cartItemCount)
{
    float totalCost = 0;
    printf("\nYour Cart \n");
    for (int i = 0; i < cartItemCount; i++)
    {
        float subtotal = cart[i].product.price * cart[i].quantity;
        printf("%s (Qty: %d) - $%.2f\n", cart[i].product.name, cart[i].quantity, subtotal);
        totalCost += subtotal;
    }
    printf("Total Cost: $%.2f\n", totalCost);
}


void main()
{
    Product products[3] = {
        {1, "Apple", 0.50},
        {2, "Bread", 2.20},
        {3, "Milk", 1.80}};

    CartItem cart[10];
    int cartItemCount = 0;
    int choice=1;

    do
    {   
        if(choice==0)
            break;
        printf("\nPoint of Sale System\n");
        printf("0. Exit\n");
        printf("1. Add Item to Cart\n");
        printf("2. View Cart and Checkout\n");
        printf("3. Clear Cart\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 0:
            printf("\nExited\n");
            break;
        case 1:
        { 
            addItemToCart(products, 3, cart, &cartItemCount);
            break;
        }
        case 2:
        { 
            viewCartAndCheckout(cart, cartItemCount);
            break;
        }
        case 3:
        {
            cartItemCount = 0;
            printf("Cart cleared.\n");
            break;
        }
        default:
            printf("\nWrong choice... \nEnter correct choice...\n\n");
        }
    } while (choice != 0);

}