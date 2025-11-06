/*
 1. Create a Class Calculator
Write functions to perform all arithmetic operations (add, subtract, multiply, divide) and
overload those functions for the following parameters:
• Two int values
• Two double values
• One int and one double value
• One double and one int value
 */

class Calculator{
	
	//addition
	void add(int a, int b){
		System.out.println("Addition: "+(a+a));
	}
	
	void add(int a, double b){
		System.out.println("Addition: "+(a+a));
	}

	void add(double a,int b){
		System.out.println("Addition: "+(a+a));
	}

	void add(double a, double b){
		System.out.println("Addition: "+(a+a));
	}

	//subtraction
	void sub(int a, int b){
		System.out.println("Subtraction: "+(a-a));
	}

	void sub(int a, double b){
		System.out.println("Subtraction: "+(a-a));
	}

	void sub(double a,int b){
		System.out.println("Subtraction: "+(a-a));
	}

	void sub(double a, double b){
		System.out.println("Subtraction: "+(a-a));
	}

	//multiplication
	void mul(int a, int b){
		System.out.println("Multiplication: "+(a*a));
	}
	
	void mul(int a, double b){
		System.out.println("Multiplication: "+(a*a));
	}

	void mul(double a,int b){
		System.out.println("Multiplication: "+(a*a));
	}

	void mul(double a, double b){
		System.out.println("Multiplication: "+(a*a));
	}

	void div(int a, int b){
		System.out.println("Division: "+(a/a));
	}
	
	void div(int a, double b){
		System.out.println("Division: "+(a/a));
	}

	void div(double a,int b){
		System.out.println("Division: "+(a/a));
	}

	void div(double a, double b){
		System.out.println("Division: "+(a/a));
	}


	public static void main(String[] args){
		Calculator c1=new Calculator();
		
		c1.add(10, 10);
		c1.add(10, 10.0);
		c1.add(10.0, 10);
		c1.add(10.0, 10.0);

		c1.sub(10, 10);
		c1.sub(10, 10.0);
		c1.sub(10.0, 10);
		c1.sub(10.0, 10.0);

		c1.mul(10, 10);
		c1.mul(10, 10.0);
		c1.mul(10.0, 10);
		c1.mul(10.0, 10.0);

		c1.div(10, 10);
		c1.div(10, 10.0);
		c1.div(10.0, 10);
		c1.div(10.0, 10.0);
		

	}
}