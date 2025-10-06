#include <stdio.h>

typedef struct Student
{
    int roll_no;
    char name[20];
    int marks;
} Student;

void store(Student* temp, int size)
{
    for(int i = 0; i < size; i++)
    {
        printf("Enter roll no.: ");
        scanf("%d", &temp[i].roll_no);

        printf("Enter name: ");
        scanf("%s", temp[i].name);

        printf("Enter  marks: ");
        scanf("%d", &temp[i].marks);
    }
}

void display(Student *temp, int size)
{
    for(int i = 0; i < size; i++)
    {
        printf("Roll no.: %d Name: %s Marks: %d\n", temp[i].roll_no, temp[i].name, temp[i].marks);
    }
}

void main()
{

    Student s[5];

    store(s, 5);

    display(s, 5);
}