#include <stdio.h>

typedef struct Time
{
    int hour;
    int minute;
    int second;
} Time;

void store(Time *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Enter Hour: ");
        scanf("%d", &temp[i].hour);
        printf("Enter Minute: ");
        scanf("%d", &temp[i].minute);
        printf("Enter Second: ");
        scanf("%d", &temp[i].second);
    }
}

void display(Time *temp, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("\nTime - %d-%d-%d", temp[i].hour, temp[i].minute, temp[i].second);
    }
}
void main()
{

    Time d[5];

    store(d, 5);
    display(d, 5);
}