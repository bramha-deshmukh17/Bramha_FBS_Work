#include <stdio.h>

typedef struct Date
{
    int day, month, year;
} Date;

typedef struct Student
{
    int roll_no;
    char name[20];
    int marks;
    Date dateOfAdmission;
    Date dob;
} Student;



void store(Student *temp)
{
    printf("Enter roll no.: ");
    scanf("%d", &temp->roll_no);

    printf("Enter name: ");
    scanf("%s", temp->name);

    printf("Enter  marks: ");
    scanf("%d", &temp->marks);

    printf("Enter admission date as dd mm yyyy: ");
    scanf("%d %d %d", &temp->dateOfAdmission.day, &temp->dateOfAdmission.month, &temp->dateOfAdmission.year);

    printf("Enter dob as dd mm yyyy: ");
    scanf("%d %d %d", &temp->dob.day, &temp->dob.month, &temp->dob.year);
}

void display(Student *temp)
{

    printf("\n\nRoll no.: %d \nName: %s \nMarks: %d", temp->roll_no, temp->name, temp->marks);
    printf("\nDate of admission: %d/%d/%d", temp->dateOfAdmission.day, temp->dateOfAdmission.month, temp->dateOfAdmission.year);
    printf("\nDate of birth: %d/%d/%d", temp->dob.day, temp->dob.month, temp->dob.year);
}

void main()
{

    Student s1, s2, s3;

    store(&s1);
    display(&s1);
}