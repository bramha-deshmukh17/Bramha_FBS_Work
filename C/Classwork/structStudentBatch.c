#include<stdio.h>

typedef struct Student{
    int roll_no;
    char name[20];

}Student;

void main(){
    
    Student july[10], aug[5], sep[15];
    
    printf("\n\nJuly Batch\n");
    for (int i = 0; i < 10; i++)
    {
        printf("Enter Roll no: ");
        scanf("%d", &july[i].roll_no);

        printf("Enter name: ");
        scanf("%s", july[i].name);
    }
    
    printf("\n\nAugust Batch\n");
    for (int i = 0; i < 5; i++)
    {
        printf("Enter Roll no: ");
        scanf("%d", &aug[i].roll_no);

        printf("Enter name: ");
        scanf("%s", aug[i].name);
        }
        
    printf("\n\nSeptember Batch\n");
    for (int i = 0; i < 15; i++)
    {
        printf("Enter Roll no: ");
        scanf("%d", &sep[i].roll_no);

        printf("Enter name: ");
        scanf("%s", sep[i].name);
    }

    printf("\n\nJuly Batch");
    for (int i = 0; i < 10; i++)
    printf("\nRoll no.: %d, Name: %s", july[i].roll_no, july[i].name);
    
    
    printf("\n\nAugust Batch");
    for (int i = 0; i < 5; i++)
    printf("\nRoll no.: %d, Name: %s", aug[i].roll_no, aug[i].name);
    
    printf("\n\nSeptember Batch");
    for (int i = 0; i < 15; i++)
        printf("\nRoll no.: %d, Name: %s", sep[i].roll_no, sep[i].name);
}