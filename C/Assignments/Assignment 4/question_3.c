//Q3. Print perfect numbers in the given range 1 to n.

#include<stdio.h>
void main(){

    int j, n, sum;

    printf("Enter range: ");
    scanf("%d", &n);

    for(int i=1; i<=n; i++){
        sum=0;
        j=1;
        while(j<i){
            if(i%j==0)
                sum += j;
                j++;
        }

        if(sum==i)
            printf("%d is perfect number\n", i);
        
    }
}