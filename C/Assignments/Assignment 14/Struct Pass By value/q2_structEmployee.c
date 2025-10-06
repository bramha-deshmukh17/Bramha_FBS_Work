#include <stdio.h>

typedef struct Employee
{
    int id;
    char name[20];
    int salary;
} Employee;

Employee store()
{
    Employee temp;
    printf("Enter id: ");
    scanf("%d", &temp.id);

    printf("Enter name: ");
    scanf("%s", &temp.name);

    printf("Enter  salary: ");
    scanf("%d", &temp.salary);

    return temp;
}

void display(Employee temp)
{

    printf("ID: %d Name: %s salary: %d", temp.id, temp.name, temp.salary);
}

void main()
{

    Employee s;

    s = store();
    display(s);
}