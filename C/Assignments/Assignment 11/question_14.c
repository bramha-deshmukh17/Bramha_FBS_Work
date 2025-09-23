// strnstr()
#include <stdio.h>
#include <string.h>
char* mystrnstr(char *str1, char *str2, int n) {
    int i=0, j;

    while ( i < n && str1[i] != '\0') {
        if (str1[i] == str2[0]) {
            for (j = 0; i + j < n && str1[i + j] != '\0' && str2[j] != '\0'; j++) {
                if (str1[i + j] != str2[j]) {
                    break;
                }
            }
            if (str2[j] == '\0') {
                return (char *)&str1[i];
            }
        }
        i++;
    }

    return NULL;
}

void main() {
    char str1[] = "Bramha Deshmukh";
    char str2[] = "Bram";
    char *ptr = mystrnstr(str1, str2, 4);
    ptr ? printf("Found: %s\n", ptr) : printf("Not found\n");

}