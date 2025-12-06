package employeeMiniProjectV3.controller;

import employeeMiniProjectV3.model.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeDAO {

	ArrayList<Employee> eArr = new ArrayList<>();

	// default records
	public EmployeeDAO() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.txt"));
			eArr = (ArrayList<Employee>) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("No saved file found. Starting with empty list.");
		}
	}

	public boolean addEmployee(Employee e) {
		//just to check if the give id already exist
		if (eArr.contains(e)) {
			System.out.println("Employee with same ID already exists!");
			return false;
		}

	    eArr.add(e);
	    save();
	    return true;
	}

	public Employee searchEmployee(int id) {
		for (Employee e : eArr) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public boolean updateEmployee(int id, double salary) {
		for (Employee e : eArr) {
			if (e.getId() == id) {
				e.setSalary(salary);
				save();
				return true;
			}
		}
		return false;
	}

	public boolean deleteEmployee(int id) {
		for (int i = 0; i < eArr.size(); i++) {
			if (eArr.get(i).getId() == id) {
				eArr.remove(i);
				save();
				return true;
			}
		}
		return false;
	}

	public void sortEmployee(int choice) {

		ArrayList<Employee> copy = new ArrayList<Employee>(eArr);
		//creating the copy of the original array just to avoid the modifications in original after sorting

		switch (choice) {

		case 1: // ID Ascending
			Collections.sort(copy, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					return o1.getId() - o2.getId();
				}
			});
			break;

		case 2: // ID Descending
			Collections.sort(copy, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					return o2.getId() - o1.getId();
				}
			});
			break;

		case 3: // Name Ascending
			Collections.sort(copy, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			break;

		case 4: // Name Descending
			Collections.sort(copy, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					return o2.getName().compareTo(o1.getName());
				}
			});
			break;

		case 5: // Salary Ascending
			Collections.sort(copy, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					return Double.compare(o1.getSalary(), o2.getSalary());
				}
			});
			break;

		case 6: // Salary Descending
			Collections.sort(copy, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					return Double.compare(o2.getSalary(), o1.getSalary());
				}
			});
			break;

		default:
			System.out.println("Invalid choice!");
			return;
		}

		System.out.println("\nSorted Employees:");
		for (Employee e : copy) {
			System.out.println(e);
		}
	}

	public void displayAll() {
		for (Employee e : eArr) {
			System.out.println(e);
		}

	}

	private void save() {

		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.txt"));
			oos.writeObject(eArr);


		} catch (IOException e) {
			System.out.println("Something went wrong...!!");
		}
	}
}