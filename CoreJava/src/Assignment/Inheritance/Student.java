package Assignment.Inheritance;

class Student {
    String name;
    int roll;

    Student() {
    }

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getRoll() {
        return roll;
    }

    void setRoll(int roll) {
        this.roll = roll;
    }

    void display() {
        System.out.println("Student name: " + name );
        System.out.println("roll: " + roll);
    }
}

class PlacedStudent extends Student {
    String company, designation;

    PlacedStudent() {
    }

    PlacedStudent(String name, int roll, String company, String designation) {
        super(name, roll);
        this.company = company;
        this.designation = designation;
    }

    String getCompany() {
        return company;
    }

    void setCompany(String company) {
        this.company = company;
    }

    String getDesignation() {
        return designation;
    }

    void setDesignation(String designation) {
        this.designation = designation;
    }

    void display() {
        super.display();
        System.out.println("company=" + company );
        System.out.println("designation=" + designation);
    }
}

class CommiteeStudent extends Student{
	
	String role;
	
	

	CommiteeStudent() {

	}

	public CommiteeStudent(String name, int roll, String role) {
		super(name, roll);
		this.role = role;
	}

	String getRole() {
		return role;
	}

	void setRole(String role) {
		this.role = role;
	}
	void display() {
        super.display();
        System.out.println("Role in commitee: " + this.role);
    }
}


class StudentDemo {
	public static void main(String[] args) {
        PlacedStudent ps = new PlacedStudent("Abc", 101, "ABC Corp", "Software Engineer");
        ps.display();
        
        CommiteeStudent cs = new CommiteeStudent("pqr", 102, "Member");
        cs.display();

    }
}
