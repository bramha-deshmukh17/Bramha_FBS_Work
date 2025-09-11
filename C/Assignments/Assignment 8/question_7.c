/*Q7. Take two array and add sum in third array

Example-
arr[5]= {1,2, 3, 4,5}

brr[5]={10,20,30, 40, 50}
crr[5]={11,22,33,44,55}
*/

#include <stdio.h>
void main()
{
    int size;

    printf("Enter size for both arrays: ");
    scanf("%d", &size);

    int arr[size], arr1[size], arr2[size];

    printf("Enter array 1 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr1[i]);

    printf("Enter array 2 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr2[i]);

    for (int i = 0; i < size; i++)
        arr[i] = arr1[i] + arr2[i];

    printf("Elements after addition into 3rd array: [");
    for (int i = 0; i < size; i++)
        printf(" %d ", arr[i]);

    printf("]");
}