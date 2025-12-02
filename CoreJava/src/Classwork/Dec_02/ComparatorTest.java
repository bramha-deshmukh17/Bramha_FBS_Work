package Classwork.Dec_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ComparatorTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "bhbhb", 1000);
		Employee e2 = new Employee(102, "bramha", 51000);
		Employee e3 = new Employee(103, "bhbjhb", 40000);
		List l1 = new ArrayList();
		l1.add(e1);
		l1.add(e2);
		l1.add(e3);
		
		int choice = 1;
		while(choice!=0) {
			System.out.println("\n1. Sort by Id");
			System.out.println("\n2. Sort by Name");
			System.out.println("\n3. Sort by Salary");
			System.out.println("Enter choice: ");
			Scanner sc=new Scanner(System.in);
			choice = sc.nextInt();
			
			System.out.println("Before sort:");
			System.out.println(l1);

			switch(choice) {
			case 0:
				System.out.println("Exited");
			case 1:
				MyIdComparator mic = new MyIdComparator();
				Collections.sort(l1, mic);
				break;
			case 2:
				MyNameComparator mnc = new MyNameComparator();
				Collections.sort(l1, mnc);
				break;
			case 3:
				MySalaryComparator msc = new MySalaryComparator();
				Collections.sort(l1, msc);
				break;
				
			}
			System.out.println("After sort:");
			System.out.println(l1);

		}
	}

}
