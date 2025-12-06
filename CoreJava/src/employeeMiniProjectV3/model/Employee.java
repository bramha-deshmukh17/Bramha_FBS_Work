package employeeMiniProjectV3.model;

import java.io.Serializable;

public abstract class Employee implements Serializable {
	int id;
	String name;
	double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.name = "Not Given";
		this.salary = 10000;
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public abstract double calculateSalary();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nID: " + this.id + " Name: " + this.name + " Salary: " + this.salary;
	}
	
	@Override
	public boolean equals(Object obj) {
	   
	    Employee e = (Employee) obj;
	    return this.id == e.id;  
	}

	@Override
	public int hashCode() {
	    return this.id;
	}

}
