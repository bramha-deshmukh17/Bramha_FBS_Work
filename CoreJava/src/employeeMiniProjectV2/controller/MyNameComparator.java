package employeeMiniProjectV2.controller;

import java.util.Comparator;

import employeeMiniProjectV2.model.Employee;


public class MyNameComparator implements Comparator<Employee>{

	

	@Override
	public int compare(Employee o1, Employee o2) {

		return o1.getName().compareTo(o2.getName());
	}

}