#include <stdio.h>

typedef struct Admin
{
    int id;
    char name[20];
    int salary;
    int allowance;
} Admin;

Admin store()
{
    Admin temp;
    printf("Enter ID: ");
    scanf("%d", &temp.id);

    printf("Enter name: ");
    scanf("%s", &temp.name);

    printf("Enter  salary: ");
    scanf("%d", &temp.salary);

    printf("Enter  allowance: ");
    scanf("%d", &temp.allowance);

    return temp;
}

void display(Admin temp)
{

    printf("ID: %d Name: %s salary: %d Allowance: %d", temp.id, temp.name, temp.salary, temp.allowance);
}

void main()
{

    Admin s;

    s = store();
    display(s);
}