package employeeMiniProject.controller;

import employeeMiniProject.model.Employee;
import employeeMiniProject.model.Admin;
import employeeMiniProject.model.HR;
import employeeMiniProject.model.SalesManager;

public class EmployeeDAO {
	static Employee[] eArr;
	static int count;
	
	static {
		eArr=new Employee[11];
		count=0;
		eArr[count++] = new HR(101, "Ranjit", 50000, 5000);
	    eArr[count++] = new HR(102, "Amit", 48000, 4500);
	    eArr[count++] = new HR(103, "Sneha", 47000, 4000);
	    eArr[count++] = new SalesManager(201, "Karan", 60000, 12, 8000);
	    eArr[count++] = new SalesManager(202, "Meena", 58000, 15, 7500);
	    eArr[count++] = new SalesManager(203, "Rohit", 62000, 10, 9000);
	    eArr[count++] = new Admin(301, "Pragati", 70000, 10000);
	    eArr[count++] = new Admin(302, "Isha", 68000, 9500);
	    eArr[count++] = new Admin(303, "Pooja", 72000, 11000);
	    eArr[count++] = new Admin(304, "Shubham", 75000, 12000);
	}

	public boolean addEmployee(Employee e) {

		if(count<eArr.length) {
			eArr[count++] = e;
			return true;
		}
		return false;
		
	}

	public Employee searchEmployee(int id) {

		for (int i = 0; i < count; i++) {
            if (eArr[i].getId() == id) {
                return eArr[i];
            }
        }
        return null;
		
		
	}

	public boolean updateEmployee(int id,double salary) {

		for (int i = 0; i < count; i++) {
            if (eArr[i].getId() == id) {
            	eArr[i].setSalary(salary);
                return true;
            }
            
        }
		return false;
		
	}

	public boolean deleteEmployee(int id) {

		for (int i = 0; i < count; i++) {
            if (eArr[i].getId() == id) {
                for (int j = i; j < count; j++) {
                    eArr[j] = eArr[j + 1];
                }
                eArr[--count] = null;
                return true;
            }
        }
        return false;
		
	}

	public void displayAll() {

		for (int i = 0; i < count; i++) {
			System.out.println(eArr[i]);
           }
	}
	

}
