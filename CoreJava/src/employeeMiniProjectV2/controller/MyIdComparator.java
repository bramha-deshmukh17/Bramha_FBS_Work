package employeeMiniProjectV2.controller;

import java.util.Comparator;

import employeeMiniProjectV2.model.Employee;


public class MyIdComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		
		return o1.getId()-o2.getId();
		
	}


}
