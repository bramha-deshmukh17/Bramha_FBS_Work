package Assignment.Static;
class Employee{
    static double companyBonusRate = 10.0;

    String name;
    double basicSalary;

    Employee(String name, double basicSalary){
        this.name = name;
        this.basicSalary = basicSalary;
    }

    static void setCompanyBonusRate(double newRatePercent){
        companyBonusRate = newRatePercent;
    }

    static double getCompanyBonusRate(){
        return companyBonusRate;
    }

    
    double calculateTotalSalary(){
        return basicSalary + (basicSalary * companyBonusRate / 100.0);
    }

    String getName(){
        return name;
    }

    double getBasicSalary(){
        return basicSalary;
    }

}

class EmployeeTest{
    public static void main(String[] args){
        Employee emp1 = new Employee("ABC", 50000);
        Employee emp2 = new Employee("pqr", 60000);

        System.out.println("Initial Company Bonus Rate: " + Employee.getCompanyBonusRate() + "%");

        System.out.println(emp1.getName() + "'s Total Salary: " + emp1.calculateTotalSalary());
        System.out.println(emp2.getName() + "'s Total Salary: " + emp2.calculateTotalSalary());

        
        Employee.setCompanyBonusRate(15.0);
        System.out.println("Updated Company Bonus Rate: " + Employee.getCompanyBonusRate() + "%");

        System.out.println(emp1.getName() + "'s Total Salary after change: " + emp1.calculateTotalSalary());
        System.out.println(emp2.getName() + "'s Total Salary after change: " + emp2.calculateTotalSalary());
    }
}