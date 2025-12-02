package Classwork.Dec_02;

import java.util.*;

public class EqualsDemo {

	public static void main(String[] args) {

		ArrayList<Employee> l1 = new ArrayList<Employee>();

		l1.add(new Employee(101, "ABC", 1000));
		l1.add(new Employee(105, "bramha", 51000));
		l1.add(new Employee(103, "PQR", 40000));
		l1.add(new Employee(104, "XYZ", 40000));

		if (l1.contains(new Employee(103, "PQR", 40000))) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}

	}

	public static void main1(String[] args) {

		TreeSet<Employee> l1 = new TreeSet<Employee>();

		l1.add(new Employee(101, "ABC", 1000));
		l1.add(new Employee(105, "bramha", 51000));
		l1.add(new Employee(103, "PQR", 40000));
		l1.add(new Employee(104, "XYZ", 40000));

		if (l1.contains(new Employee(103, "PQR", 40000))) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}

	}

	public static void main2(String[] args) {

		HashSet<Employee> l1 = new HashSet<Employee>();

		l1.add(new Employee(101, "ABC", 1000));
		l1.add(new Employee(105, "bramha", 51000));
		l1.add(new Employee(103, "PQR", 40000));
		l1.add(new Employee(104, "XYZ", 40000));

		if (l1.contains(new Employee(103, "PQR", 40000))) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}

	}

}
