/*
WAP to calculate the electricity bill.
For 1-50 units - 30rs/unit, for 51-150 units - 40rs/unit, for 151 and above 50rs/unit
*/

#include<stdio.h>

void main(){

    int units, total;

    printf("Enter total units: ");
    scanf("%d", &units);

    if(units>=1 && units<=50)
        printf("Total bill = %d", 30*units);
    else if(units>=51 && units <=150)
        printf("Total bill = %d", 40*units);
    else if(units>=151)
        printf("Total bill = %d", 50*units);
    else    
        printf("Enter valid units");
}