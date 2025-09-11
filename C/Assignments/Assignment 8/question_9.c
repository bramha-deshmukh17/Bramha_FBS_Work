// Q9. Reverse the given array.
#include<stdio.h>
void main(){
    int size, temp;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    /* printf("Reversed array: [");
    for (int i = size-1; i >= 0; i--)
        printf(" %d ", arr[i]);

    printf("]");*/

    int end= size-1;

    for(int i=0; i<size; i++){
        if(i<end)
        {
            temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            end--;
        }
        else
            break;
        
    }

    printf("[", arr[0]);
    for (int i = 0; i < size; i++)
        printf(" %d ", arr[i]);

    printf("]");
}