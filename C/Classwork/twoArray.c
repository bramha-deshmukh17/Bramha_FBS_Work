//show brr elements which are not in arr1

#include<stdio.h>
void main(){

    int size1, size2, flag;

    printf("Enter size for 1st array: ");
    scanf("%d", &size1);

    printf("Enter size for 2nd array: ");
    scanf("%d", &size2);

    int arr[size1], brr[size2];

    printf("Enter array 1 elements: ");
    for (int i = 0; i < size1; i++)
        scanf("%d", &arr[i]);

    printf("Enter array 2 elements: ");
    for (int i = 0; i < size2; i++)
        scanf("%d", &brr[i]);

    printf("[");
    for(int i=0; i<size2; i++){
        
        flag=1;
        for(int j=0; j<size1; j++){
            if(brr[i]==arr[j]){
                flag=0;
                break;
            }
        }
        if(flag)
            printf(" %d ", brr[i]);
    }
    printf("]");
    
}