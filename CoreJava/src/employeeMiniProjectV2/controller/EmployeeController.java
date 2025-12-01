package employeeMiniProjectV2.controller;

import employeeMiniProjectV2.model.Employee;

public class EmployeeController {
	EmployeeDAO ed=new EmployeeDAO();
	
	public boolean addEmployee(Employee e) {

		return ed.addEmployee(e);
	}

	public Employee searchEmployeeById(int id) {

		Employee e1=ed.searchEmployee(id);
		if(e1!=null) {
			return e1;
		}
		return null;
	}

	public boolean updateEmployee(int id, double salary) {

		if(ed.updateEmployee(id,salary)) {
			return true;
		}
		return false;
	}

	public boolean deleteEmployee(int id) {

		if(ed.deleteEmployee(id)) {
			return true;
		}
		return false;
	}

	public void displayAll() {

		ed.displayAll();
		
	}

	

}
