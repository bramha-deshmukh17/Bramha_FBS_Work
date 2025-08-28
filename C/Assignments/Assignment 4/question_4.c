//Q4. Print strong numbers in the given range 1 to n.

#include<stdio.h>

void main(){
    int n, fact, newNum, sum, j, k;

    printf("Enter range: ");
    scanf("%d", &n);

    for(int i=1; i<=n; i++){
        
        sum=0;
        newNum=0;
        j=i;
        while(j>0){
            k=1;
            fact = 1;
            newNum = j%10;
            while(k<=newNum){
                fact *= k;
                k++;
            }
    
            sum += fact;
            j /= 10;
        }

        if(i==sum)
            printf("%d is a strong number\n", i);
    }
}