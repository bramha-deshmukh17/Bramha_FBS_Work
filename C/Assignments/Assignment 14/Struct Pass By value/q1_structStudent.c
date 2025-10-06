#include <stdio.h>

typedef struct Student
{
    int roll_no;
    char name[20];
    int marks;
} Student;

Student store(){
    Student temp;
    printf("Enter roll no.: ");
    scanf("%d", &temp.roll_no);

    printf("Enter name: ");
    scanf("%s", &temp.name);

    printf("Enter  marks: ");
    scanf("%d", &temp.marks);

    return temp;
}

void display(Student temp){

    printf("Roll no.: %d Name: %s Marks: %d", temp.roll_no, temp.name, temp.marks);
}

void main()
{

    Student s;

    s=store();
    display(s);
    
}