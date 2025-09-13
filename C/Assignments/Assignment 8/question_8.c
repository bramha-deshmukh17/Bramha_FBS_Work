// Q8. Merge two arrays

#include<stdio.h>
void main(){
    int size1, size2, size3;

    printf("Enter size for 1st array: ");
    scanf("%d", &size1);

    printf("Enter size for 2nd array: ");
    scanf("%d", &size2);

    size3 = size1+size2;
    int arr[size3], arr1[size1], arr2[size2];

    printf("Enter array 1 elements: ");
    for (int i = 0; i < size1; i++)
        scanf("%d", &arr1[i]);

    printf("Enter array 2 elements: ");
    for (int i = 0; i < size2; i++)
        scanf("%d", &arr2[i]);
    
    for(int i=0; i<size3; i++){
        if(i < size1)
            arr[i] = arr1[i];
        else
            arr[i] = arr2[i-size1];
    }

    printf("Elements after merging into 3rd array: [");
    for (int i = 0; i < size3; i++)
        printf(" %d ", arr[i]);

    printf("]");
}