#include <stdio.h>

typedef struct Employee
{
    int eid;
    char name[20];
    float salary;
} Employee;

void main()
{

    Employee e[5];

    for (int i = 0; i < 5; i++)
        {
            printf("Enter eid: ");
            scanf("%d", &e[i].eid);
            printf("Enter name: ");
            scanf("%s", &e[i].name);
            printf("Enter salary: ");
            scanf("%f", &e[i].salary);
        }

    for (int i = 0; i < 5; i++)
        printf("\nEmployee ID: %d  Name: %s  Salary: %f", e[i].eid, e[i].name, e[i].salary);
}