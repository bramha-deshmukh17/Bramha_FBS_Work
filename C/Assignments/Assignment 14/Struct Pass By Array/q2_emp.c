#include <stdio.h>

typedef struct Employee
{
    int id;
    char name[20];
    int salary;
} Employee;

void store(Employee *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter id: ");
        scanf("%d", &temp[i].id);

        printf("Enter name: ");
        scanf("%s", temp[i].name);

        printf("Enter  salary: ");
        scanf("%d", &temp[i].salary);
    }
}

void display(Employee *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("ID: %d Name: %s salary: %d\n", temp[i].id, temp[i].name, temp[i].salary);
    }
}

void main()
{

    Employee s[5];

    store(s, 5);
    display(s, 5);
}