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
        System.out.println("\nEmployee Details:");
        System.out.print("Id: " + id);
        System.out.print("Name: " + name);
        System.out.print("Salary: " + salary);
    }
}

class EmployeeDemo {
    public static void main(String[] args) {
		
	Employee[] arr=new Employee[3];

	arr[0] = new Employee();
	arr[1] = new Employee(101, "ABC", 20000.0);
	arr[2] = new Employee(102, "PQR", 30000.0);

	for(int i = 0; i < arr.length; i++){
		arr[i].display();
	}


    }
}