#include <stdio.h>

typedef struct Admin
{
    int id;
    char name[20];
    int salary;
    int allowance;
} Admin;

void store(Admin *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter ID: ");
        scanf("%d", &temp[i].id);

        printf("Enter name: ");
        scanf("%s", temp[i].name);

        printf("Enter  salary: ");
        scanf("%d", &temp[i].salary);

        printf("Enter  allowance: ");
        scanf("%d", &temp[i].allowance);
    }
}
void display(Admin *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("ID: %d Name: %s salary: %d Allowance: %d\n", temp[i].id, temp[i].name, temp[i].salary, temp[i].allowance);
    }
}

void main()
{

    Admin s[5];

    store(s, 5);
    display(s, 5);
}