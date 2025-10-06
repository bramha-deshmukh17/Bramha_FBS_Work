#include <stdio.h>

struct Time
{
    int hrs;
    int min;
    int sec;
};

// Function to convert a Time structure into total seconds
int convertToSeconds(struct Time t)
{
    return t.hrs * 3600 + t.min * 60 + t.sec;
}

void main()
{
    struct Time t1, t2, sum;

    printf("Enter first time (HH MM SS): ");
    scanf("%d %d %d", &t1.hrs, &t1.min, &t1.sec);
    printf("Enter second time (HH MM SS): ");
    scanf("%d %d %d", &t2.hrs, &t2.min, &t2.sec);

    sum.sec = t1.sec + t2.sec;
    sum.min = t1.min + t2.min;
    sum.hrs = t1.hrs + t2.hrs;

    if (sum.sec >= 60)
    {
        sum.min += sum.sec / 60;
        sum.sec %= 60;
    }
    if (sum.min >= 60)
    {
        sum.hrs += sum.min / 60;
        sum.min %= 60;
    }

    printf("\nSum of times is: %d hours, %d minutes, %d seconds\n", sum.hrs, sum.min, sum.sec);

    int totalSeconds = convertToSeconds(sum);
    printf("\nThe Total time (%d:%d:%d) is equal to %d seconds.\n", sum.hrs, sum.min, sum.sec, totalSeconds);

}