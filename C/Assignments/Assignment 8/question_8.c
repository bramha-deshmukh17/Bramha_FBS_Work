// Q8. Merge two arrays

#include<stdio.h>
void main(){
    int size;

    printf("Enter size for both arrays: ");
    scanf("%d", &size);

    int arr[size*2], arr1[size], arr2[size];

    printf("Enter array 1 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr1[i]);

    printf("Enter array 2 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr2[i]);
    
    for(int i=0; i<size*2; i++){
        if(i < size)
            arr[i] = arr1[i];
        else
            arr[i] = arr2[i-5];
    }

    printf("Elements after merging into 3rd array: [");
    for (int i = 0; i < size*2; i++)
        printf(" %d ", arr[i]);

    printf("]");
}