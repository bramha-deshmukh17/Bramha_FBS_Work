// Q10. Sort the array.

#include<stdio.h>
void main(){
    int size, temp;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    for(int i=0; i<size; i++){
        for(int j=i; j<size; j++){
            if(arr[i]>arr[j]){
                //bubble sort algorithm
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
    }

    printf("Sorted array: [");
    for (int i = 0; i < size; i++)
        printf(" %d ", arr[i]);

    printf("]");
}