// Q6. Accept array and print only prime numbers of array.

#include<stdio.h>
void main(){
    int size;

    printf("Enter size of array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter array elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &arr[i]);
    

    for (int i = 0; i < size; i++)
    {   
        int flag = 1;

        for(int j = 2; j<arr[i]; j++){
            if (arr[i] <= 1 || arr[i] % j == 0)
            {   
                flag=0;
                break;
            }
        }


        /* Here if the first two numbers are 1 or less it will print it as prime so one extra condition
           i.e. arr[i]>1 because our second loop starts with zero and if arr[0] or arr[1] is 1 or less
           then our condition arr[i]%j will return false which will ultimately print 1 as prime */
        if (arr[i] > 1 && flag)
            printf("\n%d is Prime", arr[i]);
    }
}