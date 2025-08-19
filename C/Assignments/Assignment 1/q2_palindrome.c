//Q2. Write a program to check given 3 digit number is pallindrome or not.

void main(){

    int num = 121;
    int copy = num;

    int temp0 = num%10;
    num = num/10;

    int temp1 = num%10;
    num = num/10;

	num = (temp0*100)+(temp1*10)+num;

	if(copy == num){
		printf("Number is palindrome");
	}
	else{
		printf("Number is not palindrome");
	}
}