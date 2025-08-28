//Q1. Print armstrong number in the given range 1 to n

#include<stdio.h>
void main(){
    int n, copy, sum, r;
    printf("Enter range: ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        copy=i;
        sum=0;
        while(copy>0){
            r = copy%10;
            sum+=(r*r*r);
            copy/=10;
        }
        if(sum==i){
            printf("%d is Armstrong\n", i);
        }
    }
}