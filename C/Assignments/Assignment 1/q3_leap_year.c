//Q3. Write a program to check whether a given year is a leap year.

void main(){
    int year = 1900;

    if(year%4 == 0&& year%100 != 0 || year%400 == 0){
        printf("Year is a leap year");
    }
    else{
        printf("Year is not a leap year");
    }
}