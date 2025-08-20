// Q1. Accept two numbers from user and an operator (+,-,/,*,%) based on that perform the desired operations.

#include <stdio.h>
void main(){
    int num1, num2, operation;
    printf("Enter two numbers: ");
    scanf("%d", &num1);
    scanf("%d", &num2);

    printf("1. Addition\n2. Subtrction\n3. Multiplication\n4. Division\n5. Reminder\nEnter what to perform opration: ");
    scanf("%d", &operation);
    if (operation >= 1 && operation <= 5)
    {
        if (operation == 1)
        {
            printf("Addition: %d", num1 + num2);
        }
        else if (operation == 2)
        {
            printf("Subtraction: %d", num1 - num2);
        }
        else if (operation == 3)
        {
            printf("Multiplication: %d", num1 * num2);
        }
        else if (operation == 4)
        {
            printf("Division: %d", num1 / num2);
        }
        else
        {
            printf("Reminder: %d", num1 % num2);
        }
    }
    else{
        printf("Enter a valid option");
    }
}