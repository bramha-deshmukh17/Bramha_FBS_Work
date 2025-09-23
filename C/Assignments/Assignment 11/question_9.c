//strstr()

#include<stdio.h>
#include<string.h>

char* mystrstr(char *str1, char *str2)
{
    int i = 0, j;
    char* ptr = NULL;
    
    while (str1[i] != '\0')
    {   
        if(str1[i]==str2[0]){
            j = 0;
            while(str2[j] != '\0'){
                // i+j to avoid incrementing of i so that i value can be reused
                //  if substring not matched for next iteration
                if (str1[i + j] == '\0' || str1[i + j] != str2[j]){
                    break;
                }
                j++;
            }
            if (str2[j] == '\0'){
                ptr = &str1[i];
                return ptr;
            }
        }
        i++;
    }

    return ptr;
}
int main(void){
    char str1[]="Bramha Deshmukh";
    char str2[]="";
    char* ptr = mystrstr(str1, str2);
    ptr ? printf("Found: %s",ptr) : printf("Not found");
    return 0;
}