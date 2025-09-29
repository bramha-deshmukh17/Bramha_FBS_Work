#include<stdio.h>

typedef struct Student{
    int roll_no;
    char name[20];
}Student;


void main(){

    Student s[5];

    for(int i=0; i<5; i++)
        {
            printf("Enter Roll no: ");
            scanf("%d", &s[i].roll_no);

            printf("Enter name: ");
            scanf("%s", s[i].name);
        }

    for(int i=0; i<5; i++)
    printf("\nRoll no.: %d, Name: %s", s[i].roll_no, s[i].name);
}