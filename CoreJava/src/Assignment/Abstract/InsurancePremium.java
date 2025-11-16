package Assignment.Abstract;

import java.util.Scanner;

abstract class InsurancePolicy {
    String policyHolderName;
    double basePremium;

    InsurancePolicy(String policyHolderName, double basePremium) {
        this.policyHolderName = policyHolderName;
        this.basePremium = basePremium;
    }

    String getPolicyHolderName() {
        return policyHolderName;
    }

    void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    double getBasePremium() {
        return basePremium;
    }

    void setBasePremium(double basePremium) {
        this.basePremium = basePremium;
    }

    abstract double calculatePremium();

    void printPolicyDetails() {
        System.out.println("Policy Holder: " + this.policyHolderName);
        System.out.println("Base Premium: Rs." + this.basePremium);
        System.out.println("Final Premium: Rs." + calculatePremium());
    }
}

class CarInsurance extends InsurancePolicy {
    final int carAgeInYears;
    final boolean hadAccidentInLastYear;
    final double carValue;

    CarInsurance(String policyHolderName, double basePremium, int carAgeInYears, boolean hadAccidentInLastYear,
            double carValue) {
        super(policyHolderName, basePremium);
        this.carAgeInYears = carAgeInYears;
        this.hadAccidentInLastYear = hadAccidentInLastYear;
        this.carValue = carValue;
    }

    double calculatePremium() {
        double premium = this.basePremium;
        if (carAgeInYears <= 3) {
            premium += this.basePremium * 0.10;
        } else if (carAgeInYears <= 7) {
            premium += this.basePremium * 0.20;
        } else {
            premium += this.basePremium * 0.30;
        }
        if (hadAccidentInLastYear) {
            premium += this.basePremium * 0.25;
        } else {
            premium -= this.basePremium * 0.10;
        }
        if (carValue > 1000000) {
            premium += 2000;
        }
        return premium;
    }
}

class HealthInsurance extends InsurancePolicy {
    final int age;
    final boolean isSmoker;
    final boolean hasPreExistingDisease;

    HealthInsurance(String policyHolderName, double basePremium, int age, boolean isSmoker,
            boolean hasPreExistingDisease) {
        super(policyHolderName, basePremium);
        this.age = age;
        this.isSmoker = isSmoker;
        this.hasPreExistingDisease = hasPreExistingDisease;
    }

    double calculatePremium() {
        double premium = this.basePremium;
        if (age < 30) {
            premium += this.basePremium * 0.10;
        } else if (age <= 45) {
            premium += this.basePremium * 0.25;
        } else {
            premium += this.basePremium * 0.40;
        }
        if (isSmoker) {
            premium += this.basePremium * 0.30;
        } else {
            premium -= this.basePremium * 0.05;
        }
        if (hasPreExistingDisease) {
            premium += this.basePremium * 0.20;
        }
        return premium;
    }
}

class InsurancePremiumDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose policy type: 1. Car Insurance  2. Health Insurance");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter policy holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter base premium (Rs.): ");
        double base = sc.nextDouble();

        InsurancePolicy policy;
        if (choice == 1) {
            System.out.print("Enter car age in years: ");
            int age = sc.nextInt();

            System.out.print("Had accident in last year? (y/n): ");
            boolean hadAcc = sc.next().trim().equalsIgnoreCase("y");


            System.out.print("Enter car value (Rs.): ");
            double value = sc.nextDouble();

            policy = new CarInsurance(name, base, age, hadAcc, value);
        } else {
            System.out.print("Enter age: ");
            int age = sc.nextInt();

            System.out.print("Is smoker? (y/n): ");
            boolean smoker = sc.next().trim().equalsIgnoreCase("y");

            System.out.print("Has pre-existing disease? (y/n): ");
            boolean pre = sc.next().trim().equalsIgnoreCase("y");
            
            policy = new HealthInsurance(name, base, age, smoker, pre);
        }
        System.out.println();
        policy.printPolicyDetails();
        sc.close();
    }
}