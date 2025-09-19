// Q1. Use around 21 built-in functions of string in program.
#include <stdio.h>
#include <string.h>

void main()
{

    char str1[] = "Bramha Deshmukh";
    char str2[30];
    printf("\nLength of str1: %d", strlen(str1));
    printf("\nCopied to str2: %s", strcpy(str2, str1));
    printf("\nUpper case str1: %s", strupr(str1));
    printf("\nLower case str1: %s", strlwr(str1));
    printf("\nString comparison result: %d", strcmp(str1, str2));

    char *ptr1 = strchr(str1, 'a');
    printf("\nFirst 'a' in str1: %s", ptr1 ? ptr1 : "NULL");
    char *ptr2 = strrchr(str1, 'a');
    printf("\nLast 'a' in str1: %s", ptr2 ? ptr2 : "NULL");

    char str3[10];
    strncpy(str3, str2, 3);
    str3[3] = '\0';
    printf("\nstrncpy to str3: %s", str3);

    char str4[40] = "Bramha ";
    char str5[40] = "Deshmukh";
    printf("\nstrcat: %s", strcat(str4, str5));

    char str6[50] = "Bramha ";
    printf("\nstrncat: %s", strncat(str6, "Deshmukh", 3));

    printf("\nstrncmp 7: %d", strncmp(str2, "Bramha Deshmukh", 7));
    printf("\nstrncmp 16: %d", strncmp(str2, "Bramha Deshmukh", 16));

    char str7[] = "Bramha Deshmukh";
    char *ptr3 = strstr(str7, "Desh");
    printf("\nstrstr: %s", ptr3 ? ptr3 : "NULL");

    char str8[50] = "Bramha Deshmukh";
    char *ptr4 = strtok(str8, " ");
    printf("\nTokens:");
    while (ptr4)
    {
        printf(" %s", ptr4);
        ptr4 = strtok(NULL, " ");
    }

    char str9[] = "Bramha Deshmukh";
    int n1 = strspn(str9, "Bramha Deshmukh");
    printf("\nstrspn: %d", n1);

    int n2 = strcspn(str9, "Deshmukh");
    printf("\nstrcspn: %d", n2);

    char *ptr5 = strpbrk(str9, "Deshmukh");
    printf("\nstrpbrk: %s", ptr5 ? ptr5 : "NULL");

    char str10[] = "Bramha Deshmukh";
    char *ptr6 = memchr(str10, 'D', sizeof(str10));
    printf("\nmemchr: %s", ptr6 ? ptr6 : "NULL");

    char str11[30] = "Bramha Deshmukh";
    char str12[30];
    memcpy(str12, str11, strlen(str11) + 1);
    printf("\nmemcpy: %s", str12);

    char str13[40] = "Bramha Deshmukh";
    memmove(str13 + 2, str13, 6);
    printf("\nmemmove: %s", str13);

    char str14[25] = "Bramha Deshmukh";
    memset(str14 + 7, '*', 3);
    printf("\nmemset: %s", str14);

    printf("\nmemcmp: %d", memcmp("Bramha Deshmukh", "Bramha Deshmukh", 17));
    
}