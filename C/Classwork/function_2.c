
#include<stdio.h>
#include<math.h>

int greatest(int a, int b, int c){
    if(a>b && a>c)
        return a;
    else if(b>c && b>a)
        return b;
    else   
        return c;
}



void main(){

    int a, b, c;
    printf("Enter three nums: ");
    scanf("%d %d %d", &a, &b, &c);

    printf("%d is greatest", greatest(a, b, c));

    printf("%d", a=pow(10,5));
}

