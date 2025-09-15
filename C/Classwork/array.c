#include<stdio.h>
void main(){

    int size, num, index = -1;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    for (int i = 0; i < size; i++)
    {
        printf("Enter %dth number of array: ", i + 1);
        scanf("%d", &arr[i]);
    }

    printf("[");
    for (int i = 0; i < size; i++)
        printf(" %d ",arr[i]);
    
    printf("]");

    printf("\nEnter number to be searched: ");
    scanf("%d", &num);

    for (int i = 0; i < size; i++)
        if(num==arr[i]){
            index = i;
            break;
        }

    index == -1 ? printf("Number not found") : printf("Number found at %d index", index);
}