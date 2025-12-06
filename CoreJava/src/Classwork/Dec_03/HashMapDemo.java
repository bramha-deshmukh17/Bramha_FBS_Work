package Classwork.Dec_03;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<MyKey, Employee> tm = new HashMap<MyKey, Employee>();

		tm.put(new MyKey(10), new Employee(10, "Bramha", 5454545));
		tm.put(new MyKey(11), new Employee(11, "hjh", 757));
		tm.put(new MyKey(9), new Employee(9, "dwwdha", 1214));
		tm.put(new MyKey(12), new Employee(12, "bbvbc", 87878));

		if (tm.containsKey(new MyKey(9))) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}

	}

}
