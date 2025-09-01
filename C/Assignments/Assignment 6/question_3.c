/*Q3. Convert Ass_4 into two type of function i.e. w/o parameter, w/o return type and with
parameter and w/o return type.
*/

#include<stdio.h>

void submenu(){

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
        if (choice != 0)
        {
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
            if (choice != 0)
                printf("\n\nPlease select valid choice");
        }
        if (choice != 0)
            printf("\n\n\nPress 0.To exit.\n");
    } while (choice != 0);
}

void armstrong(){
    int n, copy, sum, r;
    printf("Enter range: ");
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
    {
        copy = i;
        sum = 0;
        while (copy > 0)
        {
            r = copy % 10;
            sum += (r * r * r);
            copy /= 10;
        }
        if (sum == i)
        {
            printf("%d is Armstrong\n", i);
        }
    }
}

void prime(){
    int n, flag;

    printf("Enter range: ");
    scanf("%d", &n);

    for (int i = 2; i <= n; i++)
    {
        flag = 1;

        for (int j = 2; j < i; j++)
        {
            if (i % j == 0)
            {
                flag = 0;
                break;
            }
        }

        if (flag == 1)
        {
            printf("%d is prime\n", i);
        }
    }
}

void perfect(int n){
    int j, sum;

    for (int i = 1; i <= n; i++)
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

void strong(int n){
    int fact, newNum, sum, j, k;

    for (int i = 1; i <= n; i++)
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


void main(){

    int choice = 1;

    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit\n");
        printf("Press 1: To enter submenu\n");
        printf("Press 2: To print armstrong nos in a range\n");
        printf("Press 3: To print prime nos in a range\n");
        printf("Press 4: To print perfect nos number in a range\n");
        printf("Press 5: To print strong nos in a range\n");
        printf("Enter choice: ");
        scanf("%d", &choice);
        printf("\n");

        if (choice == 1)
            submenu();

        else if (choice == 2)
            armstrong();

        else if (choice == 3)
            prime();
    
        else if (choice == 4)
        {
            int n;
            printf("Enter range: ");
            scanf("%d", &n);

            perfect(n);
        }

        else if (choice == 5)
        {
            int n;
            printf("Enter range: ");
            scanf("%d", &n);

            strong(n);
        }

        else
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");

    } while (choice != 0);
}



