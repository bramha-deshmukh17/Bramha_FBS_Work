// Q2. Accept three sides of a triangle from the user and determine whether the triangle is equilateral, isosceles, or scalene.
#include<stdio.h>
void main()
{
    int a, b, c;
    printf("Enter sides of th triangle:\n");

    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);

    if(a==b && b==c){
        printf("Equilateral triangle");
    }
    else{
        if(a==b || b==c || a==c){
            printf("Isosceles triangle");
        }
        else{
            printf("Scalene triangle");
        }
    }


}