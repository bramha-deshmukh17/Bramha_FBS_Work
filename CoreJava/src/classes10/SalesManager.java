package classes10;
class SalesManager {
    int id;
    String name;
    double salary;
    double incentive;
    int target;

    // Default constructor
    SalesManager() {
        this.id = 0;
        this.name = "";
        this.salary = 0.0;
        this.incentive = 0.0;
        this.target = 0;
    }

    // Parameterized constructor
    SalesManager(int id, String name, double salary, double incentive, int target) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.incentive = incentive;
        this.target = target;
    }

    // Getters
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    double getIncentive() {
        return incentive;
    }

    int getTarget() {
        return target;
    }

    // Setters
    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    void setIncentive(double incentive) {
        this.incentive = incentive;
    }

    void setTarget(int target) {
        this.target = target;
    }

    // Display method
    void display() {
        System.out.println("SalesManager Details:");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Incentive: " + incentive);
        System.out.println("Target: " + target);
    }
}

class SalesManagerDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        SalesManager s1 = new SalesManager();
        s1.setId(301);
        s1.setName("Abc");
        s1.setSalary(60000.0);
        s1.setIncentive(5000.0);
        s1.setTarget(50);
        s1.display();

        // Using getters
        System.out.println("Data: " + s1.getId() + ", " + s1.getName() + ", " + s1.getSalary() + ", " + s1.getIncentive() + ", " + s1.getTarget());

        // Using parameterized constructor
        SalesManager s2 = new SalesManager(302, "PQR", 65000.0, 6000.0, 60);
        s2.display();

        // Update via setters and show getters
        s2.setId(303);
        s2.setName("Bramha");
        s2.setSalary(70000.0);
        s2.setIncentive(7000.0);
        s2.setTarget(70);
        System.out.println("Data: " + s2.getId() + ", " + s2.getName() + ", " + s2.getSalary() + ", " + s2.getIncentive() + ", " + s2.getTarget());
    }
}
