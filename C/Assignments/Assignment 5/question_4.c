/*
Q4. pyramid pattern
Input: n = 5
Output:
     *
    * *
   * * *
  * * * *
 * * * * *
*/

#include <stdio.h>
void main()
{

    int n, spaces;
    printf("Enter a number: ");
    scanf("%d", &n);
    spaces = n;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < spaces; j++)
        {
            printf(" ");
        }
        for (int k = 0; k <= i; k++)
        {
            printf("* ");
        }
        printf("\n");
        spaces--;
    }

    /*
    for(int i=0; i<n; i++){
        for(int j=n; j>i; j--){
            printf(" ");
        }
        for(int k=0; k<=i; k++){
            printf("* ");
        }
        printf("\n");
    }
    */
}