#include<stdio.h>
void main(){

    int size, num, found=1;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    for (int i = 0; i < size; i++)
    {
        printf("Enter %dth number of array: ", i + 1);
        scanf("%d", &arr[i]);
    }

    printf("[", arr[0]);
    for (int i = 0; i < size; i++)
        printf(" %d ",arr[i]);
    
    printf("]");

    printf("\nEnter number to be searched: ");
    scanf("%d", &num);

    for (int i = 0; i < size; i++)
        if(num==arr[i]){
            printf("Number found at %dth position", i+1);
            found = 0;
            break;
        }

    if(found)
        printf("Number not found");
    
    
}