#include <stdio.h>

typedef struct Student
{
    int roll_no;
    char name[20];

} Student;

void storeStudent(Student *ptr, int size)
{

    for (int i = 0; i < size; i++)
    {
        printf("Enter Roll no: ");
        scanf("%d", &ptr[i].roll_no);

        printf("Enter name: ");
        scanf("%s", ptr[i].name);
    }
}

void displayStudent(Student *ptr, int size)
{
    for (int i = 0; i < size; i++)
        printf("\nRoll no.: %d, Name: %s", ptr[i].roll_no, ptr[i].name);
}

void main()
{

    Student july[10], aug[5], sep[15];

    printf("\n\nJuly Batch\n");
    storeStudent(july, 10);

    printf("\n\nAugust Batch\n");
    storeStudent(aug, 5);

    printf("\n\nSeptember Batch\n");
    storeStudent(sep, 15);

    printf("\n\nJuly Batch");
    displayStudent(july, 10);

    printf("\n\nAugust Batch");
    displayStudent(aug, 5);

    printf("\n\nSeptember Batch");
    displayStudent(sep, 15);
}