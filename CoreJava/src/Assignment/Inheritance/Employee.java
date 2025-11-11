package Assignment.Inheritance;

class Employee {
    String name;
    int id;
    static String companyName="ABC Corp";

    Employee() {
    }

    Employee(String name, int id) {
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

    static String getCompanyName() {
        return companyName;
    }

    void display() {
        System.out.println("Id: " + this.id);
        System.out.println("Employee name: " + this.name );
        System.out.println("Company: " + Employee.companyName);
    }
}

class Hr extends Employee {
    String region;

    Hr() {
    }

    Hr(String name, int id, String region) {
        super(name, id);
        this.region = region;
    }

    String getRegion() {
        return region;
    }

    void setRegion(String region) {
        this.region = region;
    }

    void display() {
        super.display();
        System.out.println("Region: " + this.region);
    }
}

class Admin extends Employee {
    String department;

    Admin() {
    }

    Admin(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    void display() {
        super.display();
        System.out.println("Department: " + this.department);
    }
}

class SalesManager extends Employee {
    double target;

    SalesManager() {
    }

    SalesManager(String name, int id, double target) {
        super(name, id);
        this.target = target;
    }

    double getTarget() {
        return target;
    }

    void setTarget(double target) {
        this.target = target;
    }

    void display() {
        super.display();
        System.out.println("Target: " + this.target);
    }
}

class EmployeeDemo {
	public static void main(String[] args) {
        Hr hr = new Hr("ABC", 1, "Central");
        hr.display();

        Admin admin = new Admin("LMN", 2, "IT");
        admin.display();

        SalesManager sm = new SalesManager("PQR", 3, 500000);
        sm.display();
    }
}
