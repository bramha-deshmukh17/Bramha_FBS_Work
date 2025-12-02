package Classwork.Dec_02;



import java.util.*;

public class Employee implements Comparable<Employee>{
	int id;
	String name;
	double salary;

	public Employee() {

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

	public String toString() {

		return "\nID: " + this.id + " Name: " + this.name + " Salary: " + this.salary;
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee e1 = (Employee)obj;
		if(this.id==e1.id) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}


}
