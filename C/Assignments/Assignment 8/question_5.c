// Q5. Print alternate elements in array.

#include<stdio.h>
void main(){

    int size;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
    

    printf("[", arr[0]);
    for (int i = 0; i < size; i+=2)
        printf(" %d ", arr[i]);

    printf("]");
}