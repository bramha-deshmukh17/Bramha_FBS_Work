//import java.util.Scanner;
package Classwork.Nov_7;
class BankAccount{
	
	int accountNumber;
	String accountHolderName;
	double currentBalance; 
	static double interestRate = 12.0;
	
	//default constructor
	BankAccount(){
		this.accountNumber=0;
		this.accountHolderName="";
		this.currentBalance=0.0;
	}
	
	//parameterised constructor
	BankAccount(int accountNumber, String accountHolderName, double currentBalance){
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.currentBalance=currentBalance;	
	}

	//setters
	void setAccountHolderName(String name){
		this.accountHolderName=name;
	}

	void setCurrentBalance(double amt){
		this.currentBalance=amt;
	}

	static void setInterestRate(double rate){
		interestRate=rate;
	}

	//getter
	int getAccountNumber(){
		return accountNumber;
	}
	
	String getAccountHolderName(){
		return accountHolderName;
	}

	double getCurrentBalance(){
		return currentBalance;
	}

	double getInterestRate(){
		return interestRate;
	}
		
	void display(){
		System.out.println("\nAccount Number:" + this.accountNumber + " Name: " + this.accountHolderName + " Current Balance: " + this.currentBalance + " Interest Rate: " + interestRate);
			
	}

}

class Test{
	public static void main(String[] args){

		/*Scanner sc=new Scanner(System.in);

		System.out.println("Enter Account number: ");
		int num = sc.nextInt();

		System.out.println("Enter Name:");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.println("Enter Current Balance:");
		double bal = sc.nextDouble();

		System.out.println("Enter interest Rate:");
		double rate = sc.nextDouble();

		BankAccount b1=new BankAccount(num, name, bal, rate);
		b1.display();*/



		BankAccount b1=new BankAccount(101, "ABC", 2000.0);
		b1.display();

		BankAccount b2=new BankAccount(102, "LMN", 2000.0);
		b2.display();
		
		BankAccount b3=new BankAccount(103, "PQR", 2000.0);
		b3.display();

		BankAccount.setInterestRate(5.0);
		//b3.setInterestRate(15.0);
		
		b3.display();
		b2.display();
		b1.display();
		
	}
}