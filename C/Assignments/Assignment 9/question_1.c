// Q1. Do all the questions of ASS_8 using function.

#include<stdio.h>

void minMaxInArray(int *arr, int size)
{
    int min, max;

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

    printf("Max = %d \nMin = %d", max, min);
}

void searchArray(int *arr, int size)
{
    int num;
    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    printf("Enter a number to be searched: ");
    scanf("%d", &num);

    for (int i = 0; i < size; i++)
        if (num == arr[i])
            printf("Number found at %d position", i + 1);
}

void arraySum(int *arr, int size)
{
    int sum = 0;
    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    for (int i = 0; i < size; i++)
        sum += arr[i];

    printf("Sum = %d", sum);
}

void findOddEven(int* arr, int size)
{
    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    for (int i = 0; i < size; i++)
        arr[i] % 2 == 0 ? printf("\n%d is Even", arr[i]) : printf("\n%d is Odd", arr[i]);
}

void printAlternate(int* arr, int size)
{
    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);

    printf("[", arr[0]);
    for (int i = 0; i < size; i += 2)
        printf(" %d ", arr[i]);
    printf("]");
}

void printPrimes(int* arr, int size)
{
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

void addTwoArrays(int* arr, int size)
{
    int arr1[size], arr2[size];

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

void mergeArrays(int* arr, int size)
{
    int size1, size2, size3;

    printf("Enter size for 1st array: ");
    scanf("%d", &size1);

    printf("Enter size for 2nd array: ");
    scanf("%d", &size2);

    size3 = size1 + size2;
    int arr1[size1], arr2[size2];

    printf("Enter array 1 elements: ");
    for (int i = 0; i < size1; i++)
        scanf("%d", &arr1[i]);

    printf("Enter array 2 elements: ");
    for (int i = 0; i < size2; i++)
        scanf("%d", &arr2[i]);

    for (int i = 0; i < size3; i++)
    {
        if (i < size1)
            arr[i] = arr1[i];
        else
            arr[i] = arr2[i - size1];
    }

    printf("Elements after merging into 3rd array: [");
    for (int i = 0; i < size3; i++)
        printf(" %d ", arr[i]);
    printf("]");
}

void reverseArray(int* arr, int size)
{
    int temp;

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

void sortArray(int* arr, int size)
{
    int temp;

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
    int arr[10];
    int size = 10;

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
            minMaxInArray(arr, size);
        else if (choice == 2)
            searchArray(arr, size);
        else if (choice == 3)
            arraySum(arr, size);
        else if (choice == 4)
            findOddEven(arr, size);
        else if (choice == 5)
            printAlternate(arr, size);
        else if (choice == 6)
            printPrimes(arr, size);
        else if (choice == 7)
            addTwoArrays(arr, size);
        else if (choice == 8)
            mergeArrays(arr, size);
        else if (choice == 9)
            reverseArray(arr, size);
        else if (choice == 10)
            sortArray(arr, size);
        else
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");

    } while (choice != 0);
}
