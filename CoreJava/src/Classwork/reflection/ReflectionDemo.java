package Classwork.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Employee {
	int id;
	String name;
	double salary;

	// Default constructor
	public Employee() {
		this.id = 0;
		this.name = "NA";
		this.salary = 0.0;
	}

	// Parameterized constructor
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}

public class ReflectionDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cname;
		System.out.println("Enter class name: ");
		cname = sc.next();

		// part 1
		try {
			Class c1 = Class.forName(cname);
			Object obj = c1.newInstance();
			Employee e1 = (Employee) obj;
			System.out.println(e1.getName());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}

		// part 2
		try {
			Class c1 = Class.forName(cname);
			Constructor[] c = c1.getConstructors();
			System.out.println("\n\nConstructors");
			for (int i = 0; i < c.length; i++) {
				System.out.println(c[i]);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// part 3
		try {
			Class c1 = Class.forName(cname);
			Method[] m = c1.getMethods();
			System.out.println("\nMethods");
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i]);
			}

			Method[] dm = c1.getDeclaredMethods();
			System.out.println("\nDeclared Methods");
			for (int i = 0; i < dm.length; i++) {
				System.out.println(dm[i]);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// part 4
		try {
			Class c1 = Class.forName(cname);
			Object obj = c1.newInstance();
			Employee e1 = (Employee) obj;
			Method m1 = c1.getMethod("getName", null);
			System.out.println("Name: " + m1.invoke(e1, null));

			Method m2 = c1.getMethod("setName", String.class);
			m2.invoke(e1, "Bramha");

			System.out.println("Name: " + m1.invoke(e1, null));

		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
