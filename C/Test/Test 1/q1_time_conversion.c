// Que 1. Convert the time entered in hh,min and sec into total seconds.

#include<stdio.h>
void main()
{

    int hour, min, seconds;
    printf("Enter hour, min and seconds:");
    scanf("%d %d %d", &hour, &min, &seconds);

    long int total_sec = (hour * 3600) + (min * 60) + seconds;
    printf("Total seconds: %d", total_sec);
}