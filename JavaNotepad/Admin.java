class Admin {
    int id;
    String name;
    double salary;
    double allowance;

    // Default constructor
    Admin() {
        this.id = 0;
        this.name = "";
        this.salary = 0.0;
        this.allowance = 0.0;
    }

    // Parameterized constructor
    Admin(int id, String name, double salary, double allowance) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.allowance = allowance;
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

    double getAllowance() {
        return allowance;
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

    void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    // Display method
    void display() {
        System.out.println("Admin Details:");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Allowance: " + allowance);
    }
}

class AdminDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Admin a1 = new Admin();
        a1.setId(101);
        a1.setName("Bramha");
        a1.setSalary(80000.0);
        a1.setAllowance(10000.0);
        a1.display();

        // Using getters
        System.out.println("Data: " + a1.getId() + ", " + a1.getName() + ", " + a1.getSalary() + ", " + a1.getAllowance());

        // Using parameterized constructor
        Admin a2 = new Admin(102, "XYZ", 90000.0, 12000.0);
        a2.display();

        // Update via setters and show getters
        a2.setId(103);
        a2.setName("ABC");
        a2.setSalary(95000.0);
        a2.setAllowance(15000.0);
        System.out.println("Data: " + a2.getId() + ", " + a2.getName() + ", " + a2.getSalary() + ", " + a2.getAllowance());
    }
}
