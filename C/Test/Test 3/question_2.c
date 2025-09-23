//WAP to add alternate numbers from give range
#include <stdio.h>

void main()
{

    int start, end, sum=0;
    printf("Enter start and end: ");
    scanf("%d %d", &start, &end);

    for (int i = start; i <= end; i++){
        sum+=i;
        i++;
}
    printf("Sum = %d", sum);
}