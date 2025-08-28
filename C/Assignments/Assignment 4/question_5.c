/*
Q5. Write a menu driven program to take a number for user and perform operations as follows.

Press 1.To check number is even or odd.
2.To check number is prime or not.
3.To check number is pallindrome or not.
4.To check number is positive, negative or zero.
5.To reverse a number.
6.To find sum of digits.
*/

#include <stdio.h>
void main()
{

    int choice, num;

    do
    {
        printf("Press 1.To check number is even or odd.\n");
        printf("2.To check number is prime or not.\n");
        printf("3.To check number is pallindrome or not.\n");
        printf("4.To check number is positive, negative or zero.\n");
        printf("5.To reverse a number.\n");
        printf("6.To find sum of digits.\n");
        printf("Enter a choice: ");
        scanf("%d", &choice);
        if(choice !=0 ){
            printf("Enter a number: ");
            scanf("%d", &num);
        }
        if (choice == 1)
        {
            // even odd
            num % 2 == 0 ? printf("\n\n%d is even number", num) : printf("\n\n%d is odd number", num);
        }
        else if (choice == 2)
        {
            // prime or not
            int flag = 1;
            for (int i = 2; i < num; i++)
            {
                if (num % i == 0)
                {
                    flag = 0;
                    break;
                }
            }
            
            flag ? printf("\n\n%d is Prime number", num) : printf("\n\n%d is not Prime number", num);
        }
        else if (choice == 3)
        {
            // palindrome
            int sum = 0, copy = num;
            while (copy > 0)
            {
                sum = (sum * 10) + (copy % 10);
                copy /= 10;
            }
            sum == num ? printf("\n\n%d is palindrome number", num) : printf("\n\n%d is not palindrome number", num);
        }
        else if (choice == 4)
        {
            // positive negative or zero
            if (num > 0)
            printf("\n\n%d is positive number", num);
            else if (num < 0)
            printf("\n\n%d is negative number", num);
            else
            printf("\n\nZero");
        }
        else if (choice == 5)
        {
            // reverse num
            int sum = 0, copy = num;
            while (copy > 0)
            {
                sum = (sum * 10) + (copy % 10);
                copy /= 10;
            }
            
            printf("\n\n%d is reverse of %d", sum, num);
        }
        else if (choice == 6)
        {
            // sum of digits
            int sum = 0, copy = num;
            while (copy > 0)
            {
                sum += copy % 10;
                copy /= 10;
            }
            
            printf("\n\nSum of digits of %d: %d", num, sum);
        }
        else
        {
            if(choice != 0)
            printf("\n\nPlease select valid choice");
        }
        if(choice != 0)
        printf("\n\n\nPress 0.To exit.\n");
    } while (choice != 0);
}