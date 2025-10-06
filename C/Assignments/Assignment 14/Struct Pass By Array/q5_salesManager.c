#include <stdio.h>

typedef struct SalesManager
{
    int id;
    char name[20];
    int salary, incentive, target
} SalesManager;

void store(SalesManager *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter ID: ");
        scanf("%d", &temp[i].id);

        printf("Enter name: ");
        scanf("%s", temp[i].name);

        printf("Enter  salary: ");
        scanf("%d", &temp[i].salary);

        printf("Enter  incentive: ");
        scanf("%d", &temp[i].incentive);

        printf("Enter  target: ");
        scanf("%d", &temp[i].target);
    }
}

void display(SalesManager *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("ID: %d Name: %s salary: %d incentive: %d Target: %d\n", temp[i].id, temp[i].name, temp[i].salary, temp[i].incentive, temp[i].target);
    }
}

void main()
{

    SalesManager s[5];

    store(s, 5);
    display(s, 5);
}