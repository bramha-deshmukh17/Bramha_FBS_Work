package Classwork.Nov_12;

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

    double calSalary() {
        return salary;
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

    double calSalary() {
        return salary + commision;
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

    double calSalary() {
        return salary + allowance;
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

    double calSalary() {
        return salary + incentive;
    }
}

class EmployeeDemo {
    public static void main(String[] args) {

        Hr hr = new Hr("ABC", 1, 10000.0, 100.0);
        hr.display();
        System.out.println("Salary: " + hr.calSalary());

        Admin admin = new Admin("LMN", 2, 20000.0, 120.0);
        admin.display();
        System.out.println("Salary: " + admin.calSalary());

        SalesManager sm = new SalesManager("PQR", 3, 500000.0, 500.0, 100);
        sm.display();
        System.out.println("Salary: " + sm.calSalary());

    }
}
