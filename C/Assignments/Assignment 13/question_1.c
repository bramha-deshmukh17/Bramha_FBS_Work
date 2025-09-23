// Q1. Do all the questions of ASS_8 using function.

#include <stdio.h>
#include<stdlib.h>
void minMaxInArray(int size)
{
    int min, max;

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
        
    min = arr[0];
    max = arr[0];

    for (int i = 1; i < size; i++)
    {
        if (arr[i] < min)
            min = arr[i];
        if (arr[i] > max)
            max = arr[i];
    }

    printf("\nMax = %d \nMin = %d", max, min);
}

void searchArray(int size)
{
    int num;

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
        
    printf("Enter a number to be searched: ");
    scanf("%d", &num);

    for (int i = 0; i < size; i++)
        if (num == arr[i])
            printf("Number found at %d position", i + 1);
}

void arraySum(int size)
{
    int sum = 0;

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
    for (int i = 0; i < size; i++)
        sum += arr[i];

    printf("Sum = %d", sum);
}

void findOddEven(int size)
{

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
    for (int i = 0; i < size; i++)
        arr[i] % 2 == 0 ? printf("\n%d is Even", arr[i]) : printf("\n%d is Odd", arr[i]);
}

void printAlternate(int size)
{

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    printf("[", arr[0]);
    for (int i = 0; i < size; i += 2)
        printf(" %d ", arr[i]);
    printf("]");
}

void printPrimes(int size)
{

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    for (int i = 0; i < size; i++)
    {
        int flag = 1;
        for (int j = 2; j < arr[i]; j++)
        {
            if (arr[i] <= 1 || arr[i] % j == 0)
            {
                flag = 0;
                break;
            }
        }
        if (arr[i] > 1 && flag)
            printf("\n%d is Prime", arr[i]);
    }
}

void addTwoArrays(int size)
{
    int *arr1 = (int *)malloc(size * sizeof(int));

    printf("Enter array 1 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr1[i]);

    int *arr2 = (int *)malloc(size * sizeof(int));

    printf("Enter array 2 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr2[i]);

    int *arr = (int *)malloc(size * sizeof(int));

    for (int i = 0; i < size; i++)
        arr[i] = arr1[i] + arr2[i];

    printf("Elements after addition into 3rd array: [");
    for (int i = 0; i < size; i++)
        printf(" %d ", arr[i]);
    printf("]");
}

void mergeArrays(int size)
{

    int *arr1 = (int *)malloc(size * sizeof(int));

    printf("Enter array 1 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr1[i]);

    int *arr2 = (int *)malloc(size * sizeof(int));

    int *arr = (int *)malloc((size * 2) * sizeof(int));

    printf("Enter array 2 elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr2[i]);

    for (int i = 0; i < size*2; i++)
    {
        if (i < size)
            arr[i] = arr1[i];
        else
            arr[i] = arr2[i - size];
    }

    printf("Elements after merging into 3rd array: [");
    for (int i = 0; i < size*2; i++)
        printf(" %d ", arr[i]);
    printf("]");
}

void reverseArray(int size)
{
    int temp;

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    int end = size - 1;
    for (int i = 0; i < size; i++)
    {
        if (i < end)
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

void sortArray(int size)
{
    int temp;

    int *arr = (int *)malloc(size * sizeof(int));

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    for (int i = 0; i < size; i++)
    {
        for (int j = i; j < size; j++)
        {
            if (arr[i] > arr[j])
            {
                // bubble sort algorithm
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }

    printf("Sorted array: [");
    for (int i = 0; i < size; i++)
        printf(" %d ", arr[i]);
    printf("]");
}

void main()
{
    int choice = 1;
    int size ;

    printf("Enter size of array: ");
    scanf("%d", &size);

    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit\n");
        printf("Press 1: To find min max in array\n");
        printf("Press 2: To search number in array\n");
        printf("Press 3: To print sum of array elements\n");
        printf("Press 4: Find odd/even in array\n");
        printf("Press 5: Print alternate elements\n");
        printf("Press 6: Print primes in array\n");
        printf("Press 7: Add two arrays into third\n");
        printf("Press 8: Merge two arrays\n");
        printf("Press 9: Reverse the array\n");
        printf("Press 10: Sort the array\n");
        printf("Enter choice: ");
        scanf("%d", &choice);
        printf("\n");

        if (choice == 1)
            minMaxInArray(size);
        else if (choice == 2)
            searchArray(size);
        else if (choice == 3)
            arraySum(size);
        else if (choice == 4)
            findOddEven(size);
        else if (choice == 5)
            printAlternate(size);
        else if (choice == 6)
            printPrimes(size);
        else if (choice == 7)
            addTwoArrays(size);
        else if (choice == 8)
            mergeArrays(size);
        else if (choice == 9)
            reverseArray(size);
        else if (choice == 10)
            sortArray(size);
        else
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");

    } while (choice != 0);
}
