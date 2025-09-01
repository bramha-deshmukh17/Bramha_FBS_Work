#include <stdio.h>
void addition()
{
    // Q1. Write a C program to add two integers and display the result
    int a = 10, b = 20, c;
    c = a + b;
    printf("Addition: %d\n", c);
}

void areOfCircle()
{
    // Q2. Write a C program to find the area of a circle.

    int r = 10;
    float area;
    area = 3.14 * r * r;
    printf("Area of circle: %f", area);
}

void tempConverter()
{
    /*
    3. Write a C program to convert temperature from Celsius to Fahrenheit using the
    formula:
    F = (C *9/5) + 32
    */

    double c = 16.0, f;
    f = ((c * 1.8) + 32);

    printf("%lf Celcius = %lf Fahrenheit", c, f);
}

void swapping()
{
    // Q4. Write a C program to swap two numbers using a temporary third variable.

    int a = 10, b = 20, temp;
    printf("a=%d and b=%d\n", a, b);
    temp = a;
    a = b;
    b = temp;
    printf("a=%d and b=%d", a, b);
}

void average()
{ // Q5. Write a C program to input five numbers and find their average
    int num1 = 15, num2 = 25, num3 = 35, num4 = 45, num5 = 55;
    float average;
    average = (num1 + num2 + num3 + num4 + num5) / 5;
    printf("Average of %d, %d, %d, %d & %d is %f", num1, num2, num3, num4, num5, average);
}

void squareCube()
{
    // Q6. Write a C program to find the square and cube of a given number
    int num = 5, square, cube;
    square = num * num;
    cube = num * num * num;

    printf("Number: %d, Square=%d Cube=%d", num, square, cube);
}

void hourMinConvert()
{
    // Q7. Write a C program to convert given minutes into hours and remaining minutes.
    int min = 100, hours, remaining;

    hours = min / 60;
    remaining = min % 60;

    printf("Given mins=%d \n", min);
    printf("%d Hours : %d mins", hours, remaining);
}

void perimeter()
{
    // Q8. Write a C program to input the length and width of a rectangle and find its perimeter.
    int len = 20, breadth = 10, perimeter;

    perimeter = 2 * (len + breadth);

    printf("Length: %d & Breadth: %d, Perimeter=%d", len, breadth, perimeter);
}

void area()
{
    // Q9. Write a C program to input the base and height of a triangle and calculate its area.

    int base = 10, height = 15;
    float area;

    area = 0.5 * base * height;

    printf("Base:%d, Height:%d, Area=%f", base, height, area);
}

void percentage()
{
    // Q10. Write a C program to input marks of five subjects, find the total marks, and calculate the percentage.

    int m1 = 45, m2 = 66, m3 = 58, m4 = 90, m5 = 38, total;
    float percentage;

    total = m1 + m2 + m3 + m4 + m5;
    percentage = (total / 500.0) * 100;

    printf("Total=%d, Percentage=%f", total, percentage);
}

void main()
{
    int choice = 1;

    do{
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit\n");
        printf("Press 1: Addition\n");
        printf("Press 2: Area of circle\n");
        printf("Press 3: Temperature conerter\n");
        printf("Press 4: Swapping\n");
        printf("Press 5: Average\n");
        printf("Press 6: Square and cube\n");
        printf("Press 7: Hour minutes converter\n");
        printf("Press 8: Perimeter\n");
        printf("Press 9: Area\n");
        printf("Press 10: Percentage\n");
        printf("Enter choice: ");
        scanf("%d", &choice);
        printf("\n");
        
        if (choice == 1)
            addition();
        else if (choice == 2)
            areOfCircle();
        else if (choice == 3)
            tempConverter();
        else if (choice == 4)
            swapping();
        else if (choice == 5)
            average();
        else if (choice == 6)
            squareCube();
        else if (choice == 7)
            hourMinConvert();
        else if (choice == 8)
            perimeter();
        else if (choice == 9)
            area();
        else if (choice == 10)
            percentage();
        else
            if(choice != 0)
                printf("\nWrong choice... \nEnter correct choice...\n\n");
    } while (choice != 0);
}