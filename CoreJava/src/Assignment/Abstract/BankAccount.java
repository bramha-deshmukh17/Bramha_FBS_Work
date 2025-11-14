package Assignment.Abstract;
import java.time.LocalDate;
import java.time.Period;

abstract class BankAccount {
    String accountHolderName;
    int accountNumber;
    double balance;
    LocalDate dateOpened;

    BankAccount() {
        this.accountHolderName = "Not Given";
        this.accountNumber = 100;
        this.balance = 5000;
        this.dateOpened = LocalDate.now();
    }

    BankAccount(String accountHolderName, int accountNumber, double balance, LocalDate dateOpened) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateOpened = dateOpened;
    }

    public String toString() {
        return "\nAccount Holder Name: " + accountHolderName + " Account Number: " + accountNumber + " Balance: " + balance + " Date Opened: " + dateOpened;
    }

    abstract double withdraw(double amt);
}

class SavingsAccount extends BankAccount {
    double minimumBalance;

    SavingsAccount(String name, int number, double balance, LocalDate dateOpened, double minimumBalance) {
        super(name, number, balance, dateOpened);
        this.minimumBalance = minimumBalance;
    }

    double getMinimumBalance() {
        return minimumBalance;
    }

    void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    double withdraw(double amt) {
        if (balance - amt >= minimumBalance) {
            balance -= amt;
            System.out.println("Savings Account: Withdrawal successful!");
        } else {
            System.out.println("Savings Account: Cannot withdraw, minimum balance violation!");
        }
        return balance;
    }

    public String toString() {
        return super.toString() + " Minimum Balance: " + minimumBalance;
    }
}

class CurrentAccount extends BankAccount {
    double overdraftLimit;

    double getOverdraftLimit() {
        return overdraftLimit;
    }

    void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    CurrentAccount(String name, int number, double balance, LocalDate dateOpened, double overdraftLimit) {
        super(name, number, balance, dateOpened);
        this.overdraftLimit = overdraftLimit;
    }

    double withdraw(double amt) {
        if (balance + overdraftLimit >= amt) {
            balance -= amt;
            System.out.println("Current Account: Withdrawal successful");
        } else {
            System.out.println("Current Account: Withdrawal exceeds overdraft limit!");
        }
        return balance;
    }

    public String toString() {
        return super.toString() + " Overdraft Limit: " + overdraftLimit;
    }
}

class SalaryAccount extends BankAccount {
    LocalDate lastTransactionDate = LocalDate.of(2025, 11, 1);

    SalaryAccount(String name, int number, double balance, LocalDate dateOpened) {
        super(name, number, balance, dateOpened);
    }

    double withdraw(double amt) {
        LocalDate today = LocalDate.now();
        int monthsDiff = Period.between(lastTransactionDate, today).getMonths();

        if (monthsDiff >= 2) {
            System.out.println("Salary Account: Withdrawal declined! Last transaction was " + monthsDiff + " months ago.");
            return balance;
        }

        balance -= amt;
        lastTransactionDate = today;
        System.out.println("Salary Account: Withdrawal successful!");
        return balance;
    }

    public String toString() {
        return super.toString() + " Last Transaction Date: " + lastTransactionDate;
    }
}

class TestBankAccount {
    public static void main(String[] args) {
        BankAccount acc1;

        acc1 = new SavingsAccount("ABC", 101, 20000, LocalDate.now(), 5000);
        System.out.println(acc1.toString());
        acc1.withdraw(12000);

        acc1 = new CurrentAccount("XYZ", 102, 10000, LocalDate.now(), 30000);
        System.out.println(acc1);
        acc1.withdraw(35000);

        acc1 = new SalaryAccount("PQR", 103, 60000, LocalDate.now());
        System.out.println(acc1.toString());
        acc1.withdraw(60000);
    }
}
