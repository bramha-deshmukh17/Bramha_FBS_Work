#include <stdio.h>

typedef struct Hr
{
    int id;
    char name[20];
    int salary;
    int commision;
} Hr;

void store(Hr *temp)
{
    printf("Enter ID: ");
    scanf("%d", &temp->id);

    printf("Enter name: ");
    scanf("%s", temp->name);

    printf("Enter  salary: ");
    scanf("%d", &temp->salary);

    printf("Enter  commision: ");
    scanf("%d", &temp->commision);

}

void display(Hr *temp)
{

    printf("ID: %d Name: %s salary: %d commision: %d", temp->id, temp->name, temp->salary, temp->commision);
}

void main()
{

    Hr s;

    store(&s);
    display(&s);
}