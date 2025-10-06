#include <stdio.h>

typedef struct Date
{
    int date;
    int month;
    int year;
} Date;

void store(Date *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter date: ");
        scanf("%d", &temp[i].date);
        printf("Enter month: ");
        scanf("%d", &temp[i].month);
        printf("Enter year: ");
        scanf("%d", &temp[i].year);
    }
}

void display(Date *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("\nDate - %d-%d-%d", temp[i].date, temp[i].month, temp[i].year);
    }
}
void main()
{

    Date d[5];

    store(d, 5);
    display(d, 5);
}