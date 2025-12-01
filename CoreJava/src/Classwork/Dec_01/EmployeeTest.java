package Classwork.Dec_01;


import java.util.*;

class Employee implements Comparable{
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
	public int compareTo(Object o) {

		Employee e1=(Employee)o;
		
		return Double.compare(this.salary, e1.salary);
		
		//return e1.name.compareTo(this.name);
		//return (int) (e1.salary-this.salary);
	}

}

public class EmployeeTest {

	/*
	 * public static void main(String[] args) {

		Employee e1 = new Employee(101, "bhbhb", 1000);
		Employee e2 = new Employee(102, "bramha", 51000);
		Employee e3 = new Employee(103, "bhbhb", 40000);

		List l1 = new LinkedList();
		l1.add(e1);
		l1.add(e2);
		l1.add(e3);
		
		System.out.println(l1);

	}
	 */

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "bhbhb", 1000);
		Employee e2 = new Employee(102, "bramha", 51000);
		Employee e3 = new Employee(103, "bhbjhb", 40000);

		Set s1 = new TreeSet();
		s1.add(e1);
		s1.add(e2);
		s1.add(e3);
		
		System.out.println(s1);
	}
}
