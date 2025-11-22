package Classwork.Nov_18;


abstract class Employee {
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
    
    public String toString() {
    	return "\nId: " + this.id + " Employee name: " + this.name;
    }

    abstract double calSalary();
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

    public String toString() {
    	return super.toString() + " Commision: " + this.commision;
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
    
    public String toString() {
    	return super.toString() + " allowance: " + this.allowance;
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
    
    public String toString() {
    	return super.toString() + " Target: " + this.target + " Incentive" + this.incentive;
    }

    double calSalary() {
        return salary + incentive;
    }
}

class EmployeeDemo {
	
	static void giveBonus(Employee e) {
		if(e instanceof SalesManager) {
			SalesManager s = (SalesManager) e;
			s.setIncentive(1000.0);
		}
		else if(e instanceof Admin) {
			Admin a = (Admin) e;
			a.setAllowance(2000.0);
		}
		else if(e instanceof Hr) {
			Hr h = (Hr) e;
			h.setCommision(2500.0);
		}
		
	}
	
    public static void main(String[] args) {
    	Employee e;
        e= new Hr("ABC", 1, 10000.0, 100.0);
        System.out.println(e.toString());
        System.out.println("Salary: " + e.calSalary());
        EmployeeDemo.giveBonus(e);
        System.out.println(e.toString());

        e = new Admin("LMN", 2, 20000.0, 120.0);
        System.out.println(e);
        System.out.println("Salary: " + e.calSalary());
        EmployeeDemo.giveBonus(e);
        System.out.println(e.toString());

        e = new SalesManager("PQR", 3, 500000.0, 500.0, 100);
        System.out.println(e.toString());
        System.out.println("Salary: " + e.calSalary());
        EmployeeDemo.giveBonus(e);
        System.out.println(e.toString());

    }
}
