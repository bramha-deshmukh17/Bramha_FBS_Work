#include <stdio.h>

typedef struct Hr
{
    int id;
    char name[20];
    int salary;
    int commision;
} Hr;

void store(Hr *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter ID: ");
        scanf("%d", &temp[i].id);

        printf("Enter name: ");
        scanf("%s", temp[i].name);

        printf("Enter  salary: ");
        scanf("%d", &temp[i].salary);

        printf("Enter  commision: ");
        scanf("%d", &temp[i].commision);
    }
}

void display(Hr *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("ID: %d Name: %s salary: %d commision: %d\n", temp[i].id, temp[i].name, temp[i].salary, temp[i].commision);
    }
}

void main()
{

    Hr s[5];

    store(s, 5);
    display(s, 5);
}