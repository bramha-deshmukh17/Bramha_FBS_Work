package employeeMiniProjectV2.controller;

import employeeMiniProjectV2.model.Employee;
import employeeMiniProjectV2.model.Admin;
import employeeMiniProjectV2.model.HR;
import employeeMiniProjectV2.model.SalesManager;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    List<Employee> eArr = new ArrayList<>();

    // default records
    public EmployeeDAO() {
        eArr.add(new Admin(101, "Bramha", 60000.0, 5000.0));
        eArr.add(new HR(102, "ABC", 45000.0, 2500.0));
        eArr.add(new SalesManager(103, "XYZ", 48000.0, 50, 7000.0));
        eArr.add(new HR(104, "PQR", 47000.0, 2000.0));
        eArr.add(new Admin(105, "Qwerty", 52000.0, 3000.0));
    }

    public boolean addEmployee(Employee e) {
        return eArr.add(e);
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
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < eArr.size(); i++) {
            if (eArr.get(i).getId() == id) {
                eArr.remove(i);
                return true;
            }
        }
        return false;
    }

    public void displayAll() {
        for (Employee e : eArr) {
            System.out.println(e);
        }
    }
}