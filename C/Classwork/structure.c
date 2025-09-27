#include<stdio.h>
#include<string.h>
struct house{
    int house_no;
    int floor_no;
    char owner[20];
};

void main(){

    struct house h1, h2;

    h1.floor_no=1;
    strcpy(h1.owner, "Bramha");
    h1.house_no=101;
    
    printf("Enter floor no: ");
    scanf("%d", &h2.floor_no);
    printf("Enter house no: ");
    scanf("%d", &h2.house_no);

    //to clear enter in input buffer
    fflush(stdin);
    printf("Enter owner name: ");
    gets(h2.owner);
    
    printf("\nHouse 1: Floor - %d, House no - %d, Owner Name - %s", h1.floor_no, h1.house_no, h1.owner);
    printf("\nHouse 2: Floor - %d, House no - %d, Owner Name - %s", h2.floor_no, h2.house_no, h2.owner);
}