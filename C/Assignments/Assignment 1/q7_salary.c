/*Q7. Calculating total salary based on basic. If basic <=5000 da, ta and hra will be
10%,20% and 25% respectively otherwise da, ta and hra will be 15%,25% and 30%
respectively.
*/

void main(){
	float basic = 570.0, salary, da, ta, hra;

	if(basic<=500){
		da=0.10; ta=0.20; hra=0.25;
		printf("Assigened");
	}
	else{
		da=0.15; ta=0.25; hra=0.30;
	}

	salary = basic + (basic * da) + (basic * ta) + (basic * hra);

    printf("Total salary is: %f\n", salary);
}
