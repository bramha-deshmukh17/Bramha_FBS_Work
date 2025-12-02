package Classwork.Dec_02;


import java.util.Comparator;

public class MySalaryComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		Employee e1 = (Employee)o1;
		Employee e2 = (Employee)o2;
		
		return Double.compare(e1.salary, e2.salary);
		
	}

}
