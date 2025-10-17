package Assignment_2;

import java.util.Scanner;
public class question_3{
    // Q3. Write a program to find greatest of three numbers using nested if-else.


public static void main(String args[]){
    int a, b, c;
    System.out.printf("Enter 3 numbers:\n");

    Scanner sc=new Scanner(System.in);
    a=sc.nextInt();
    b=sc.nextInt();
    c=sc.nextInt();

    
    if(a>b && a>c){
        System.out.printf("a is greater");
    }
    else{
        if(b>a && b>c){
            System.out.printf("b is greater");
        }
        else{
            System.out.printf("c is greater");
        }
    }
    sc.close();
}
}