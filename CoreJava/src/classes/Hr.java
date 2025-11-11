package classes;
class Hr {
    int id;
    String name;
    double salary;
    double commision;

    // Default constructor
    Hr() {
        this.id = 0;
        this.name = "";
        this.salary = 0.0;
        this.commision = 0.0;
    }

    // Parameterized constructor
    Hr(int id, String name, double salary, double commision) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.commision = commision;
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

    double getCommision() {
        return commision;
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

    void setCommision(double commision) {
        this.commision = commision;
    }

    // Display method
    void display() {
        System.out.println("Hr Details:");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Commision: " + commision);
    }
}

class HrDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Hr h1 = new Hr();
        h1.setId(201);
        h1.setName("Bramha");
        h1.setSalary(70000.0);
        h1.setCommision(8000.0);
        h1.display();

        // Using getters
        System.out.println("Data: " + h1.getId() + ", " + h1.getName() + ", " + h1.getSalary() + ", " + h1.getCommision());

        // Using parameterized constructor
        Hr h2 = new Hr(202, "ABC", 75000.0, 9000.0);
        h2.display();

        // Update via setters and show getters
        h2.setId(203);
        h2.setName("PQR");
        h2.setSalary(80000.0);
        h2.setCommision(9500.0);
        System.out.println("Data: " + h2.getId() + ", " + h2.getName() + ", " + h2.getSalary() + ", " + h2.getCommision());
    }
}
