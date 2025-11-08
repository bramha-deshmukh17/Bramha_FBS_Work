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
        
	Hr[] arr=new Hr[3];

	arr[0] = new Hr();
	arr[1] = new Hr(101, "ABC", 20000.0, 1000.0);
	arr[2] = new Hr(102, "PQR", 30000.0, 1500.0);

	for(int i = 0; i < arr.length; i++){
		arr[i].display();
	}

    }
}
