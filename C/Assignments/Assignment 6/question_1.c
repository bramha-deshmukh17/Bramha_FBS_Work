// Q1. Convert Ass_1 and ASS_2 program into functions with four types of function.

#include <stdio.h>
#include <conio.h>

// func w/o return w/o param
void checkAgeGroup()
{
    int age;
    printf("Enter age: ");
    scanf("%d", &age);

    if (age < 12)
        printf("Child");
    else if (age >= 12 && age <= 19)
        printf("Teenager");
    else if (age >= 20 && age <= 59)
        printf("Adult");
    else
        printf("Senior");
}

// func w/o return w/o param
void divisibility()
{
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    if (num % 3 == 0 && num % 5 == 0)
        printf("Divisible by both");
    else if (num % 3 == 0)
        printf("Divisible by 3 but not by 5");
    else if (num % 5 == 0)
        printf("Divisible by 5 but not by 3");
    else
        printf("Divisible by None");
}

// func w/o return w/o param
void result()
{
    int marks;
    printf("Enter total marks: ");
    scanf("%d", &marks);

    if (marks > 75)
        printf("Distinction");
    else if (marks > 65)
        printf("First class");
    else if (marks > 55)
        printf("Second class");
    else if (marks > 40)
        printf("Pass class");
    else
        printf("Fail");
}

// func w/o return with param
void greatestNum(int a, int b, int c)
{

    if (a > b && a > c)
        printf("a is greater");
    else
    {
        if (b > a && b > c)
            printf("b is greater");
        else
            printf("c is greater");
    }
}

// func w/o return with param
void voteAgeCheck(int age)
{
    if (age >= 18)
        printf("Eligible to vote");
    else
        printf("Not eligible to vote");
}

// func w/o return with param
void charCaseCheck(char ch)
{
    if (ch >= 'A' && ch <= 'Z')
        printf("Character is uppercase");
    else
        printf("Character is lowercase");
}

// func w/o return with param
void typeOfTrinagle(int a, int b, int c)
{
    if (a == b && b == c)
        printf("Equilateral triangle");
    else
    {
        if (a == b || b == c || a == c)
            printf("Isosceles triangle");
        else
            printf("Scalene triangle");
    }
}

// func with return w/o param
int arithematicOperation()
{
    int num1, num2, operation;
    printf("Enter two numbers: ");
    scanf("%d", &num1);
    scanf("%d", &num2);

    printf("1. Addition\n2. Subtrction\n3. Multiplication\n4. Division\n5. Reminder\nEnter which opration to perform: ");
    scanf("%d", &operation);
    if (operation >= 1 && operation <= 5)
    {
        if (operation == 1)
        {
            printf("\nAddition: ");
            return num1 + num2;
        }
        else if (operation == 2)
        {
            printf("\nSubtraction: ");
            return num1 - num2;
        }
        else if (operation == 3)
        {
            printf("\nMultiplication: ");
            return num1 * num2;
        }
        else if (operation == 4)
        {
            printf("\nDivision: ");
            return num1 / num2;
        }
        else
        {
            printf("\nReminder: ");
            return num1 % num2;
        }
    }
    else
        printf("Enter a valid option");

}

// func with return w/o param
double salary()
{
    double basic, da, ta, hra;
    printf("Enter base salary: ");
    scanf("%lf", &basic);

    if (basic <= 5000)
        return basic + (basic * 0.10) + (basic * 0.20) + (basic * 0.25);
    else
        return basic + (basic * 0.15) + (basic * 0.25) + (basic * 0.30);
}

// func with return w/o param
int vowelCheck()
{
    printf("Enter a char: ");
    char ch = getch();
    printf("%c\n", ch);
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
}

// func with return with param
int leapCheck(int year)
{
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0;
}

// func with return with param
int palindrome(int num)
{

    int copy = num;

    int temp0 = num % 10;
    num = num / 10;

    int temp1 = num % 10;
    num = num / 10;

    num = (temp0 * 100) + (temp1 * 10) + num;

    return copy == num;
}

// func with return with param
int checkEvenOdd(int num)
{
    return num % 2 == 0 ;
}

// func with return with param
float checkDiscount(float price, char student)
{

    if (student == 'y')
    {
        if (price > 500.0)
            return (price * 0.80);
        else
            return price;
    }
    else
    {
        if (price > 600.0)
            return (price * 0.85);
        else
            return price;
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
        printf("Press 1: To check age group\n");
        printf("Press 2: To check divisibility\n");
        printf("Press 3: To check result\n");
        printf("Press 4: To check greatest number\n");
        printf("Press 5: To check voting age aligibility\n");
        printf("Press 6: To check character casing\n");
        printf("Press 7: To check type of triagnle\n");
        printf("Press 8: To perform arithmatic operation\n");
        printf("Press 9: To check total salary\n");
        printf("Press 10: To check vowel or consonant\n");
        printf("Press 11: To check for leap year\n");
        printf("Press 12: To check palindrome or not\n");
        printf("Press 13: To check even odd\n");
        printf("Press 14: To check price after discount\n");
        printf("Enter choice: ");
        scanf("%d", &choice);
        printf("\n");

        if (choice == 1)
            checkAgeGroup();

        else if (choice == 2)
            divisibility();

        else if (choice == 3)
            result();

        else if (choice == 4)
        {
            printf("Enter 3 numbers:");
            int a, b, c;
            scanf("%d", &a);
            scanf("%d", &b);
            scanf("%d", &c);

            greatestNum(a, b, c);
        }
        else if (choice == 5)
        {
            int age;
            printf("Enter age: ");
            scanf("%d", &age);
            voteAgeCheck(age);
        }

        else if (choice == 6)
        {
            printf("Enter a char: ");
            char ch = getch();
            printf("%c\n", ch);
            charCaseCheck(ch);
        }

        else if (choice == 7)
        {
            printf("Enter sides of th triangle:\n");
            int a, b, c;
            scanf("%d", &a);
            scanf("%d", &b);
            scanf("%d", &c);
            typeOfTrinagle(a, b, c);
        }

        else if (choice == 8)
            printf("%d", arithematicOperation());

        else if (choice == 9)
        {

            printf("Total salry: %lf", salary());
        }

        else if (choice == 10)
            vowelCheck() ? printf("Vowel") : printf("Consonant");

        else if (choice == 11)
        {
            int year;
            printf("Enter year: ");
            scanf("%d", &year);
            leapCheck(year) ? printf("Leap year") : printf("Not a Leap year");
        }

        else if (choice == 12)
        {
            int num;
            printf("Enter Number: ");
            scanf("%d", &num);
            palindrome(num) ? printf("Palindrome number") : printf("Not palindrome number");
        }

        else if (choice == 13)
        {
            int num;
            printf("Enter a number: ");
            scanf("%d", &num);
            checkEvenOdd(num) ? printf("Even") : printf("Odd");
        }

        else if (choice == 14)
        {
            float price;
            char student;

            printf("Enter price: ");
            scanf("%f", &price);

            printf("Are you a student? y-yes  n-No: ");
            scanf(" %c", &student);
            printf("Final price: %f", checkDiscount(price, student));
        }

        else
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");

    } while (choice != 0);
}