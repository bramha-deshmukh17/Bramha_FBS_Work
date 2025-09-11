// Q1. Find minimum and maximum number in array.

#include<stdio.h>
void main(){

    int size, min, max, num;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for(int i=0; i<size; i++)
        scanf("%d", &arr[i]);

    
    min=arr[0];max=arr[0];

    for(int i=1; i<size; i++){
        if(arr[i]<min)
            min=arr[i];
        if(arr[i]>max)
            max=arr[i];
    }

    printf("Max = %d \nMin = %d", max, min);
}