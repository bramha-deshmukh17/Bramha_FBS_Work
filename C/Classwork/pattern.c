#include<stdio.h>

void main(){
    
    for(int i=1; i<=5; i++){

        for(int k=5; k>=i; k--){
            printf(" ");
        }
        for(int j=1; j<=i; j++){
            if(j==1 || j==i || i==5)
                printf("* ");
            else
                printf("  ");

        }
        printf("\n");
    }
}

/*
output:
e:\Bramha_FBS_Work\C\Classwork>cd "e:\Bramha_FBS_Work\C\Classwork\" && gcc pattern.c -o pattern && "e:\Bramha_FBS_Work\C\Classwork\"pattern
     * 
    * * 
   *   * 
  *     * 
 * * * * * 
 * 
*/