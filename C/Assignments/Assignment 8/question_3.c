// Q3. Find sum of all numbers.
#include<stdio.h>
void main(){

    int size, num, sum=0;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
    

    for(int i=0; i<size; i++){
        sum+=arr[i];
    }
    printf("Sum = %d", sum);
}