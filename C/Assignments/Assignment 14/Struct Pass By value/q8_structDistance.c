#include <stdio.h>

typedef struct Distance
{
    int feet, inch;
} Distance;

Distance store()
{
    Distance temp;
    printf("Enter feet: ");
    scanf("%d", &temp.feet);
    printf("Enter inch: ");
    scanf("%d", &temp.inch);

    return temp;
}

void display(Distance temp)
{
    printf("\nDistance - %dft. %din.", temp.feet, temp.inch);
}
void main()
{

    Distance d;

    d = store();
    display(d);
}