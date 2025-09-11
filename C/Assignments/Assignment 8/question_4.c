// Q4. Find odd and even among the numbers.
#include<stdio.h>
void main(){

    int size;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
    

    for (int i = 0; i < size; i++)
        arr[i] % 2 == 0 ? printf("\n%d is Even", arr[i]) : printf("\n%d is Odd", arr[i]);
}