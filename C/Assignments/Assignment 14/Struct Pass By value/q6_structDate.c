#include <stdio.h>

typedef struct Date
{
    int date;
    int month;
    int year;
} Date;

Date store(){
    Date temp;
    printf("Enter date: ");
    scanf("%d", &temp.date);
    printf("Enter month: ");
    scanf("%d", &temp.month);
    printf("Enter year: ");
    scanf("%d", &temp.year);

    return temp;
}

void display(Date temp){
    printf("\nDate - %d-%d-%d", temp.date, temp.month, temp.year);

}
void main()
{

    Date d;

   d=store();
   display(d);
}