class Employee {
    int id;
    String name;
    double salary;

    // Default constructor
    Employee() {
        this.id = 0;
        this.name = "";
        this.salary = 0.0;
    }

    // Parameterized constructor
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    // Display method
    void display() {
        System.out.println("Employee Details:");
        System.out.print("Id: " + id);
        System.out.print("Name: " + name);
        System.out.print("Salary: " + salary);
    }
}

class EmployeeDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Bramha");
        e1.setSalary(50000.0);
        e1.display();

        // Using getters
        System.out.println("Data: " + e1.getId() + ", " + e1.getName() + ", " + e1.getSalary());

        // Using parameterized constructor
        Employee e2 = new Employee(2, "Xyz", 65000.0);
        e2.display();

        // Update via setters and show getters
        e2.setId(3);
        e2.setName("ABC");
        e2.setSalary(70000.0);
        System.out.println("Data: " + e2.getId() + ", " + e2.getName() + ", " + e2.getSalary());
    }
}