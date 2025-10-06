#include <stdio.h>

typedef struct SalesManager
{
    int id;
    char name[20];
    int salary, incentive, target
} SalesManager;

void store(SalesManager *temp)
{
    printf("Enter ID: ");
    scanf("%d", &temp->id);

    printf("Enter name: ");
    scanf("%s", temp->name);

    printf("Enter  salary: ");
    scanf("%d", &temp->salary);

    printf("Enter  incentive: ");
    scanf("%d", &temp->incentive);

    printf("Enter  target: ");
    scanf("%d", &temp->target);

}

void display(SalesManager *temp)
{

    printf("ID: %d Name: %s salary: %d incentive: %d Target: %d", temp->id, temp->name, temp->salary, temp->incentive, temp->target);
}

void main()
{

    SalesManager s;

    store(&s);
    display(&s);
}