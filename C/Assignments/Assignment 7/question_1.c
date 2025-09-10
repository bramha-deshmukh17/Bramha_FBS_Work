// 1. Do all type 3 (with parameter, w/o return type) function programs using pointer.

#include <stdio.h>
#include <conio.h>

// func w/o return with param
void greatestNum(int *a, int *b, int *c)
{

    if (*a > *b && *a > *c)
        printf("a is greater");
    else
    {
        if (*b > *a && *b > *c)
            printf("b is greater");
        else
            printf("c is greater");
    }
}

void voteAgeCheck(int *age)
{
    if (*age >= 18)
        printf("Eligible to vote");
    else
        printf("Not eligible to vote");
}

void charCaseCheck(char *ch)
{
    if (*ch >= 'A' && *ch <= 'Z')
        printf("Character is uppercase");
    else
        printf("Character is lowercase");
}

void typeOfTrinagle(int *a, int *b, int *c)
{
    if (*a == *b && *b == *c)
        printf("Equilateral triangle");
    else
    {
        if (*a == *b || *b == *c || *a == *c)
            printf("Isosceles triangle");
        else
            printf("Scalene triangle");
    }
}

void perfect(int *n)
{

    int sum = 0, i = 1;

    while (i < *n)
    {
        if (*n % i == 0)
            sum += i;

        i++;
    }
    sum == *n ? printf("Perfect") : printf("Not perfect");
}

void sumOfDigit(int *n)
{
    int last, sum;

    last = *n % 10;

    while (*n >= 10)
    {
        *n /= 10;
    }
    sum = *n + last;
    printf("%d (%d + %d)", sum, *n, last);
}

void perfectNoRange(int* n)
{
    int j, sum;

    for (int i = 1; i <= *n; i++)
    {
        sum = 0;
        j = 1;
        while (j < i)
        {
            if (i % j == 0)
                sum += j;
            j++;
        }

        if (sum == i)
            printf("%d is perfect number\n", i);
    }
}

void strong(int* n)
{
    int fact, newNum, sum, j, k;

    for (int i = 1; i <= *n; i++)
    {

        sum = 0;
        newNum = 0;
        j = i;
        while (j > 0)
        {
            k = 1;
            fact = 1;
            newNum = j % 10;
            while (k <= newNum)
            {
                fact *= k;
                k++;
            }

            sum += fact;
            j /= 10;
        }

        if (i == sum)
            printf("%d is a strong number\n", i);
    }
}

void main()
{
    int choice = 1;

    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit\n");
        printf("Press 1: To check greatest number\n");
        printf("Press 2: To check voting age eligibility\n");
        printf("Press 3: To check character casing\n");
        printf("Press 4: To check type of triagnle\n");
        printf("Press 5: To check perfect number\n");
        printf("Press 6: To print sum of 1st and last digit\n");
        printf("Press 7: To print perfect nos number in a range\n");
        printf("Press 8: To print strong nos in a range\n");

        printf("Enter choice: ");
        scanf("%d", &choice);
        printf("\n");

        if (choice == 1)
        {

            printf("Enter 3 numbers:");
            int a, b, c;
            scanf("%d", &a);
            scanf("%d", &b);
            scanf("%d", &c);

            greatestNum(&a, &b, &c);
        }

        else if (choice == 2)
        {
            int age;
            printf("Enter age: ");
            scanf("%d", &age);
            voteAgeCheck(&age);
        }

        else if (choice == 3)
        {

            printf("Enter a char: ");
            char ch = getch();
            printf("%c\n", ch);
            charCaseCheck(&ch);
        }

        else if (choice == 4)
        {
            printf("Enter sides of the triangle: ");
            int a, b, c;
            scanf("%d", &a);
            scanf("%d", &b);
            scanf("%d", &c);
            typeOfTrinagle(&a, &b, &c);
        }

        else if (choice == 5)
        {
            printf("Enter a number: ");
            int num;
            scanf("%d", &num);
            perfect(&num);
        }

        else if (choice == 6)
        {
            int n;
            printf("Enter a number: ");
            scanf("%d", &n);

            sumOfDigit(&n);
        }

        else if (choice == 7)
        {
            int n;
            printf("Enter range: ");
            scanf("%d", &n);

            perfectNoRange(&n);
        }

        else if (choice == 8)
        {
            int n;
            printf("Enter range: ");
            scanf("%d", &n);

            strong(&n);
        }

        else
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");

    } while (choice != 0);
}