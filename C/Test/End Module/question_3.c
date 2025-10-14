/*
Q3. create a structure to store the mobile details (mid, mname, price, and brand)
Write menu driven code to accept details and display mobile details
use function for both task
*/

#include<stdio.h>
#include<stdlib.h>

int arraySize=5, mobileCount = 0;

typedef struct Mobile{
    int mid, price;
    char mname[50], brand[50];
}Mobile;

Mobile* addNewMobile(Mobile* ptr){
    if (mobileCount == arraySize)
    {
        arraySize += 5;
        Mobile *ptr = (Mobile *)realloc(ptr, arraySize * sizeof(Mobile));
    }

    printf("Enter Mobile details:\n");

    printf("Mobile id: ");
    scanf("%d", &ptr[mobileCount].mid);

    for (int i = 0; i < mobileCount; i++)
    {
        if (ptr[i].mid == ptr[mobileCount].mid)
        {
            printf("Mobile already exists. Please enter a unique Mobile id.\n");
            return ptr;
        }
    }

    printf("Mobile price: ");
    scanf("%d", &ptr[mobileCount].price);

    printf("Mobile name: ");
    fflush(stdin); 
    gets(ptr[mobileCount].mname);

    printf("Mobile brand: ");
    fflush(stdin); 
    gets(ptr[mobileCount].brand);

    mobileCount++;
    printf("\nMobile added successfully!");
    return ptr;

}

void display(Mobile *ptr){
    if(mobileCount==0){
        printf("\nNo mobile data available to display.");
        return;
    }

    printf("\nMobile Details:\n");
    for(int i=0; i<mobileCount; i++){
        printf("\nMobile id: %d", ptr[i].mid);
        printf("  Mobile price: %d", ptr[i].price);
        printf("  Mobile name: %s", ptr[i].mname);
        printf("  Mobile brand: %s\n", ptr[i].brand);
    }
}

void main(){

    Mobile *ptr = (Mobile *)malloc(arraySize * sizeof(Mobile));
    int choice = 1;

    do
    {
        printf("\n\nPress 0: Exit");
        printf("\nPress 1: To display all mobile details");
        printf("\nPress 2: To Add new mobile details");

        printf("\n\nEnter choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            display(ptr);
            break;
        case 2:
            ptr = addNewMobile(ptr);
            break;
        default:
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");
            break;
        }

    } while (choice != 0);
}

/*
OUTPUT:
e:\Bramha_FBS_Work\C\Test\End Module>cd "e:\Bramha_FBS_Work\C\Test\End Module\" && gcc question_3.c -o question_3 && "e:\Bramha_FBS_Work\C\Test\End Module\"question_3


Press 0: Exit
Press 1: To display all mobile details
Press 2: To Add new mobile details

Enter choice: 1

No mobile data available to display.

Press 0: Exit
Press 1: To display all mobile details
Press 2: To Add new mobile details

Enter choice: 2
Enter Mobile details:
Mobile id: 101
Mobile price: 45000
Mobile name: A06
Mobile brand: Samsung

Mobile added successfully!

Press 0: Exit
Press 1: To display all mobile details
Press 2: To Add new mobile details

Enter choice: 1

Mobile Details:

Mobile id: 101  Mobile price: 45000  Mobile name: A06  Mobile brand: Samsung


Press 0: Exit
Press 1: To display all mobile details
Press 2: To Add new mobile details

Enter choice: 0

Exited
*/