import java.util.Scanner;
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
	
	Admin[] arr=new Admin[3];

	arr[0] = new Admin();
	arr[1] = new Admin(101, "ABC", 20000.0, 1000.0);
	arr[2] = new Admin(102, "PQR", 30000.0, 2000.0);

	for(int i = 0; i < arr.length; i++){
		arr[i].display();
	}

	
    }
}
