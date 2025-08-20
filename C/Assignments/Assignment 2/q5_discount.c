/*Q5. Accept the price from user. Ask the user if he is a student (user may say y or n). If he
is a student and he has purchased more than 500 than discount is 20% otherwise
discount is 10%.But if he is not a student then if he has purchased more than 600
discount is 15% otherwise there is not discount.*/

#include<stdio.h>

void main(){
    float price; char student;

    printf("Enter price: ");
    scanf("%f",&price);
    
    printf("Are you a student? y-yes  n-No: ");
    scanf(" %c",&student);

    if(student == 'y'){
        if(price > 500.0){
            printf("Total price after 20 percent discount: %f", (price*0.80));
        }
        else{
            printf("No discount total price: %f", price);
        }
    }
    else{
        if (price > 600.0)
        {
            printf("Total price after 15 percent discount: %f", (price * 0.85));
        }
        else
        {
            printf("No discount total price: %f", price);
        }
    }
}