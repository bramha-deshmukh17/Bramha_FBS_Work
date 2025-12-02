package employeeMiniProjectV2.controller;

import java.util.Comparator;

import employeeMiniProjectV2.model.Employee;


public class MySalaryComparator implements Comparator<Employee>{

	

	@Override
	public int compare(Employee o1, Employee o2) {

		return (int) (o1.getSalary()-o2.getSalary());
	}

}