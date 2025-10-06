#include <stdio.h>

typedef struct Time
{
    int hour;
    int minute;
    int second;
} Time;

Time store(){
    Time temp;
    printf("Enter Hour: ");
    scanf("%d", &temp.hour);
    printf("Enter Minute: ");
    scanf("%d", &temp.minute);
    printf("Enter Second: ");
    scanf("%d", &temp.second);

    return temp;
}

void display(Time temp){
    printf("\nTime - %d-%d-%d", temp.hour, temp.minute, temp.second);

}
void main()
{

    Time d;

   d=store();
   display(d);
}