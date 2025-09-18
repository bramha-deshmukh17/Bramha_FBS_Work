#include <stdio.h>
#include <string.h>

void main()
{

    char str[] = "Bramha";
    char str2[10];

    printf("Length of str: %d", strlen(str));

    printf("\nCopied to another string: %s", strcpy(str2, str));

    printf("\nUpper case string: %s", strupr(str));

    printf("\nLower case string: %s", strlwr(str));

    printf("\nString comparison result: %d", strcmp(str, str2)); // 1: for str ascii > str2 ascii 0: for exact same -1:  for str ascii < str2 ascii

    printf("\nOccurance of a in str: %s", strchr(str, 'a')); // returns address of first occurance
    printf("\nOccurance of a in str(reverse): %s", strrchr(str, 'a')); // returns address of first occurance
}