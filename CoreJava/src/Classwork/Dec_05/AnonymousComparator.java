package Classwork.Dec_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnonymousComparator {

	public static void main(String[] args) {
		Employee e1 = new Employee(10, "Sachin", 1000);
		Employee e2 = new Employee(18, "Virat", 51000);
		Employee e3 = new Employee(12, "Yuvi", 40000);
		Employee e4 = new Employee(5, "Rahul", 40000);
		List<Employee> l1 = new ArrayList<>();
		l1.add(e1);
		l1.add(e2);
		l1.add(e3);
		l1.add(e4);
		
		int choice = 1;
		while(choice!=0) {
			System.out.println("\n1. Sort by Id");
			System.out.println("2. Sort by Name");
			System.out.println("3. Sort by Salary");
			System.out.println("Enter choice: ");
			Scanner sc=new Scanner(System.in);
			choice = sc.nextInt();
			
			System.out.println("Before sort:");
			System.out.println(l1);

			switch(choice) {
			case 0:
				System.out.println("Exited");
				break;
				
			case 1:
				Collections.sort(l1, new Comparator<Employee>() {

					@Override
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return o1.getId() - o2.getId();
					}
				});
				break;
				
			case 2:
				Collections.sort(l1, new Comparator<Employee>() {

					@Override
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return o1.getName().compareTo(o2.getName());
					}
				});
				break;
				
			case 3:
				Collections.sort(l1, new Comparator<Employee>() {

					@Override
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return (int) (o1.getSalary() - o2.getSalary());
					}
				});
				break;
				
			}
			System.out.println("After sort:");
			System.out.println(l1);

		}

	}

}
