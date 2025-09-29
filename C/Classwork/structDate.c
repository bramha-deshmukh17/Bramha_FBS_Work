#include<stdio.h>

typedef struct Date{
    int date;
    int month;
    int year;
}Date;

void main(){

    Date d[5];

    for (int i = 0; i < 5; i++)
    {
        printf("Enter date: ");
        scanf("%d", &d[i].date);
        printf("Enter month: ");
        scanf("%d", &d[i].month);
        printf("Enter year: ");
        scanf("%d", &d[i].year);
    }

    for (int i = 0; i < 5; i++)
        printf("\n%d-%d-%d", d[i].date, d[i].month, d[i].year);
}