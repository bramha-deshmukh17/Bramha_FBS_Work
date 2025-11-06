/*
 * 3. Create Classes for Student and Employee
• Student: Attributes - rollno, name, percentage
• Employee: Attributes - id, name, annualSalary
Create a class Bank and write overloaded functions to approve loans based on the following
conditions:
For Students (Based on Percentage):
• Above 80: 2 Lakh
• Between 60-80: 1 Lakh
• Between 40-60: 50K
• Below 40: No loan approved
For Employees (Based on Annual Salary):
• Above 12 LPA: 7 Lakh
• Between 10-12 LPA: 6 Lakh

• Between 6-10 LPA: 5 Lakh

• Between 4-6 LPA: 4 Lakh
• Below 4 LPA: No loan approved
 */

class Student {
    int rollno;
    String name;
    double percentage;

    Student(int rollno, String name, double percentage) {
        this.rollno = rollno;
        this.name = name;
        this.percentage = percentage;
    }
}

class Employee {
    int id;
    String name;
    double annualSalary;

    Employee(int id, String name, double annualSalary) {
        this.id = id;
        this.name = name;
        this.annualSalary = annualSalary;
    }
}

class Bank {
    // for Student
    void approveLoan(Student s) {
        double p = s.percentage;
        if (p > 80) {
            System.out.println(200000); 
        }
        else if (p >= 60) {
            System.out.println(100000); 
        }
        else if (p >= 40) {
            System.out.println(50000);
        }
        else {
            System.out.println(0);
        }
    }

    // for Employee
    void approveLoan(Employee e) {
        double sal = e.annualSalary;
        if (sal > 12) {
            System.out.println(700000); 
        }
        else if (sal >= 10) {
            System.out.println(600000); 
        }
        else if (sal >= 6) {
            System.out.println(500000); 
        }
        else if (sal >= 4) {
            System.out.println(400000); 
        }
        else {
            System.out.println(0); 
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Student s = new Student(1, "Bramha", 75);
        Employee e = new Employee(101, "Abc", 11);
        bank.approveLoan(s);
        bank.approveLoan(e);
    }
}
