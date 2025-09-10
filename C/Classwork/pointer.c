#include <stdio.h>

int getCount(int *no){

    int count = 0;
    while (*no != 0)
    {
        *no /= 10;
        count++;
    }
    return count;
}

void main(){

    int no = 12345;
    int cout = getCount(&no);

    printf("Count: %d", cout);
}