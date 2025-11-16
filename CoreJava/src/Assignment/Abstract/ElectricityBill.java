package Assignment.Abstract;

import java.util.Scanner;

abstract class ElectricityBill {
    int units;
    String customerName;

    ElectricityBill(String customerName, int units) {
        this.customerName = customerName;
        this.units = units;
    }

    int getUnits() {
        return units;
    }

    void setUnits(int units) {
        this.units = units;
    }

    String getCustomerName() {
        return customerName;
    }

    void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    void showUsage() {
        System.out.println("Customer: " + customerName);
        System.out.println("Units consumed: " + units);
    }

    abstract double calculateBill();

    final void generateBill() {
        showUsage();
        double unitCharge = calculateBill();
        double tax = unitCharge * 0.05;
        double fixed = 50.0;
        double finalAmount = unitCharge + tax + fixed;
        System.out.println("Units charge: Rs. " + unitCharge);
        System.out.println("Tax (5%): Rs. " + tax);
        System.out.println("Fixed charge: Rs. " + fixed);
        System.out.println("Final bill amount: Rs. " + finalAmount);
    }
}

class ResidentialBill extends ElectricityBill {
    final double firstSlabCharge = 2.5, secondSlabCharge = 3.5, thirdSlabCharge = 5.0;

    ResidentialBill(String customerName, int units) {
        super(customerName, units);
    }

    double calculateBill() {
        double bill = 0.0;
        int u = units;
        if (u <= 100) {
            bill = u * firstSlabCharge;
        } else if (u <= 300) {
            bill = 100 * firstSlabCharge + (u - 100) * secondSlabCharge;
        } else {
            bill = 100 * firstSlabCharge + 200 * secondSlabCharge + (u - 300) * thirdSlabCharge;
        }
        if (units > 500) {
            bill += 150;
        }
        return bill;
    }
}

class CommercialBill extends ElectricityBill {
    CommercialBill(String customerName, int units) {
        super(customerName, units);
    }

    double calculateBill() {
        double unitCharge = units * 6.5;
        if (units < 200) {
            unitCharge = Math.max(unitCharge, 1500);
        }
        if (units > 1000) {
            unitCharge = (units * 6.5) * 1.08;
        }
        return unitCharge;
    }
}

class ElectricityBillDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select customer type: \n1. Residential  \n2. Commercial");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Exiting.");
            sc.close();
            return;
        }

        System.out.print("Enter customer name: ");
        sc.nextLine();
        String name = sc.nextLine().trim();

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();
        ElectricityBill bill;

        if (choice == 1) {
            bill = new ResidentialBill(name, units);
        } else {
            bill = new CommercialBill(name, units);
        }
        
        System.out.println();
        bill.generateBill();
        sc.close();
    }
}
