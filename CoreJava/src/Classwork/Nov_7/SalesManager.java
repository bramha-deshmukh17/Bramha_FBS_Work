package Classwork.Nov_7;
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
	SalesManager[] arr=new SalesManager[3];

	arr[0] = new SalesManager();
	arr[1] = new SalesManager(101, "ABC", 20000.0, 1000.0, 50);
	arr[2] = new SalesManager(102, "PQR", 30000.0, 1500.0, 75);

	for(int i = 0; i < arr.length; i++){
		arr[i].display();
	}

        
    }
}
