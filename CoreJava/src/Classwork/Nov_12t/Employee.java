package Classwork.Nov_12t;

class Employee {
    String name;
    int id;
    double salary;

    Employee() {
    }

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    void display() {
        System.out.println("\nId: " + this.id);
        System.out.println("Employee name: " + this.name);
        System.out.println("Company: " + this.salary);
    }
}

class Hr extends Employee {

    double commision;

    Hr() {
    }

    Hr(String name, int id, double commision, double salary) {
        super(name, id, salary);
        this.commision = commision;
    }

    double getCommision() {
        return commision;
    }

    void setCommision(double commision) {
        this.commision = commision;
    }

    void display() {
        super.display();
        System.out.println("Region: " + this.commision);
    }
}

class Admin extends Employee {

    double allowance;

    Admin() {
    }

    Admin(String name, int id, double allowance, double salary) {
        super(name, id, salary);
        this.allowance = allowance;
    }

    double getAllowance() {
        return allowance;
    }

    void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    void display() {
        super.display();
        System.out.println("Department: " + this.allowance);
    }
}

class SalesManager extends Employee {

    double incentive;
    int target;

    SalesManager() {
    }

    SalesManager(String name, int id, double salary, double incentive, int target) {
        super(name, id, salary);
        this.incentive = incentive;
        this.target = target;

    }

    double getTarget() {
        return target;
    }

    void setTarget(int target) {
        this.target = target;
    }

    double getIncentive() {
        return incentive;
    }

    void setIncentive(double incentive) {
        this.incentive = incentive;
    }

    void display() {
        super.display();
        System.out.println("Target: " + this.target);
        System.out.println("Incentive" + this.incentive);
    }
}

class AreaSalesManager extends SalesManager {
    String areaName;

    AreaSalesManager() {
    }

    AreaSalesManager(String name, int id, double salary, double incentive, int target, String areaName) {
        super(name, id, salary, incentive, target);
        this.areaName = areaName;
    }

    String getAreaName() {
        return areaName;
    }

    void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    void display() {
        super.display();
        System.out.println("Area: " + this.areaName);
    }

}

class EmployeeDemo {
    public static void main(String[] args) {

        Employee e1 = new Employee("ABC", 101, 10000.0);
        e1.display();

        e1 = new Hr("ABC", 1, 10000.0, 100.0);
        e1.display();

        e1 = new Admin("LMN", 2, 20000.0, 120.0);
        e1.display();

        e1 = new SalesManager("PQR", 3, 500000.0, 500.0, 100);
        e1.display();

        e1 = new AreaSalesManager("XYz", 4, 500000.0, 500.0, 100, "Pune");
        e1.display();
    }
}
