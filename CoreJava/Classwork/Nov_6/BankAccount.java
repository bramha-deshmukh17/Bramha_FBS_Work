import java.util.Scanner;

class BankAccount{
	
	int accountNumber;
	String accountHolderName;
	double currentBalance, interestRate;
	
	//parameterised constructor
	BankAccount(int accountNumber, String accountHolderName, double currentBalance, double interestRate){
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.currentBalance=currentBalance;
		this.interestRate=interestRate;	
	}

	//setters
	void setAccountHolderName(String name){
		this.accountHolderName=name;
	}

	void setCurrentBalance(double amt){
		this.currentBalance=amt;
	}

	void setInterestRate(double interestRate){
		this.interestRate=interestRate;
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
		System.out.println("Account Number:" + getAccountNumber() + " Name: " + getAccountHolderName() + " Current Balance: " + getCurrentBalance() + " Interest Rate: " + getInterestRate());
			
	}

	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);

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
		b1.display();
		
	}

}