/* Q2. Convert Ass_3 program into functions with four types of function.(Excluding range
programs) . convert range programs into two type of function i.e. w/o parameter, w/o
return type and with parameter and w/o return type.
*/

#include <stdio.h>

void displayRange()
{
    int i = 1;
    while (i <= 10)
    {
        printf("%d\t", i);
        i++;
    }
}

void table()
{
    int n, i = 1;
    printf("Enter a number: ");
    scanf("%d", &n);

    while (i <= 10)
    {
        printf("%d\t", (n * i));
        i++;
    }
}

void sumOfNums(int start, int end)
{
    int sum = 0;

    while (start <= end)
    {
        sum += start;
        start++;
    }
    printf("Sum of numbers in range: %d", sum);
}

void prime(){
    int n, i = 2, flag = 1;
    printf("Enter a number: ");
    scanf("%d", &n);

    while (i < n)
    {
        if (n % i == 0)
        {
            flag = 0;
            break;
        }
        i++;
    }

    // n>=2 to avoid negative and 1 to be prime
    flag && n >= 2 ? printf("Prime number") : printf("Not prime number");
}

void armstrong(){
    int n, r, sum = 0, copy;

    printf("Enter a number: ");
    scanf("%d", &n);
    copy = n;

    while (n > 0)
    {
        r = n % 10;
        sum += (r * r * r);

        n /= 10;
    }

    copy == sum ? printf("Armstrong") : printf("Not Armstrong");
}

void perfect(int n){
    int sum = 0, i = 1;

    while (i < n)
    {
        if (n % i == 0)
            sum += i;

        i++;
    }
    sum == n ? printf("Perfect") : printf("Not perfect");
}

void sumOfDigit(int n){
    int last, sum;

    last = n % 10;

    while (n >= 10)
    {
        n /= 10;
    }
    sum = n + last;
    printf("%d (%d + %d)", sum, n, last);
    
}

int strong(){
    int n, copy, sum = 0, i, newNum, fact;

    printf("Enter a number: ");
    scanf("%d", &n);
    copy = n;

    while (n > 0)
    {
        i = 1;
        fact = 1;
        newNum = n % 10;
        while (i <= newNum)
        {
            fact *= i;
            i++;
        }

        sum += fact;
        n /= 10;
    }

    return sum == copy;
}

int palindrome(){
    int n, r, sum = 0, copy;
    printf("Enter a number: ");
    scanf("%d", &n);
    copy = n;

    while (n > 0)
    {
        sum = (sum * 10) + (n % 10);
        n /= 10;
    }

    return copy == sum;
}

int factorial(int n){
    int fact = 1, i = 1;

    while (i <= n)
    {
        fact *= i;
        i++;
    }

    return fact;
}

void main()
{
    int choice = 1;

    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit\n");
        printf("Press 1: To print numbers upto a range\n");
        printf("Press 2: To print table\n");
        printf("Press 3: To print sum of nums in range\n");
        printf("Press 4: To check prime number\n");
        printf("Press 5: To check armstrong number\n");
        printf("Press 6: To check perfect number\n");
        printf("Press 7: To print sum of 1st and last digit\n");
        printf("Press 8: To check strong number\n");
        printf("Press 9: To check palindrome number\n");
        printf("Press 10: To print factorial\n");
        printf("Enter choice: ");
        scanf("%d", &choice);
        printf("\n");

        if (choice == 1)
            displayRange();

        else if (choice == 2)
            table();

        else if (choice == 3)
        {
            int start, end;
            printf("Enter start and end: ");
            scanf("%d %d", &start, &end);
            sumOfNums(start, end);
        }

        else if (choice == 4)
            prime();

        else if (choice == 5)
            armstrong();

        else if (choice == 6)
        {
            printf("Enter a number: ");
            int num;
            scanf("%d", &num);
            perfect(num);
        }

        else if (choice == 7)
        {
            int n;
            printf("Enter a number: ");
            scanf("%d", &n);

            sumOfDigit(n);
        }

        else if (choice == 8)
            strong() ? printf("Strong number") : printf("Not strong number");

        else if (choice == 9)
            palindrome() ? printf("Palindrome number") : printf("Not palindrome number");

        else if (choice == 10)
            {   int n;
                printf("Enter a number: ");
                scanf("%d", &n);
                printf("Factorial: %d", factorial(n));
            }

        else
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");

    } while (choice != 0);
}
