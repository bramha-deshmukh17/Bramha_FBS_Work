void main(){
	//Q7. Write a C program to convert given minutes into hours and remaining minutes.
	int min=100, hours, remaining;

	hours=min/60;
	remaining = min%60;

	printf("Given mins=%d \n", min);
	printf("%d Hours : %d mins", hours, remaining);
}