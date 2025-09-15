#include <stdio.h>

void storeArray(int *arr, int size)
{
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
}

void printArray(int *arr, int size)
{
    printf("\n[");
    for (int i = 0; i < size; i++)
        printf(" %d ", arr[i]);

    printf("]");
}

void replaceElements(int* arr, int size, int oldValue, int newValue)
{
    for(int i=0; i<size; i++){
        if(oldValue==arr[i]){
            arr[i]=newValue;
        }
    }
}

void main()
{
    int arr[10];

    printf("Enter array elements: ");
    storeArray(arr, 10);

    int choice = 1;

    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit\n");
        printf("Press 1: To display array numbers\n");
        printf("Press 2: To replace elements in array\n");

        printf("Enter choice: ");
        scanf("%d", &choice);
        printf("\n");

        if (choice == 1)
        {
            printf("Array elements: ");
            printArray(arr, 10);
        }

        else if (choice == 2)
        {
            int oldValue, newValue;
            printf("\nEnter number to be replaced: ");
            scanf("%d", &oldValue);

            printf("Enter number to be replaced: ");
            scanf("%d", &newValue);

            replaceElements(arr, 10, oldValue, newValue);
        }

        else
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");

    } while (choice != 0);
}