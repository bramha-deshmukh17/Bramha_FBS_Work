// Q2. Search the given number in array.
#include<stdio.h>
void main(){

    int size, num;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    printf("Enter a number to be searched: ");
    scanf("%d", &num);

    for(int i=0; i<size; i++)
        if(num==arr[i])
            printf("Number found at %d position", i+1);
    
}