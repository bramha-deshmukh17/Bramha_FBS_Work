#include <stdio.h>
#include <string.h>
struct house
{
    int house_no;
    int floor_no;
    char owner[20];
};

void store(struct house* h){
    printf("Enter floor no: ");
    scanf("%d", &h->floor_no);
    printf("Enter house no: ");
    scanf("%d", &h->house_no);

    // to clear enter in input buffer
    fflush(stdin);
    printf("Enter owner name: ");
    gets(h->owner);
}

void display(struct house* h){
    printf("\nHouse 1: Floor - %d, House no - %d, Owner Name - %s", &h->floor_no, &h->house_no, h->owner);
}

void main()
{

    struct house h[2];

    for(int i=0; i<2; i++){
        store(&h[i]);
    }

    for (int i = 0; i < 2; i++)
    {
        display(&h[i]);
    }
}