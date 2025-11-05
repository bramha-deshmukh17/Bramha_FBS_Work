class Student {
    int rollno;
    String name;
    int marks;

    // Default constructor
    Student() {
        this.rollno = 0;
        this.name = "";
        this.marks = 0;
    }

    // Parameterized constructor
    Student(int rollno, String name, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    int getRollno() {
        return rollno;
    }

    String getName() {
        return name;
    }

    int getMarks() {
        return marks;
    }

    // Setters
    void setRollno(int rollno) {
        this.rollno = rollno;
    }

    void setName(String name) {
        this.name = name;
    }

    void setMarks(int marks) {
        this.marks = marks;
    }

    // Display method
    void display() {
        System.out.println("Student Details:");
        System.out.println("Roll No: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

class StudentDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Student sAbc = new Student();
        sAbc.setRollno(1);
        sAbc.setName("Abc");
        sAbc.setMarks(85);
        sAbc.display();

        // Using getters
        System.out.println("Getter check: " + sAbc.getRollno() + ", " + sAbc.getName() + ", " + sAbc.getMarks());

        // Using parameterized constructor
        Student sPQR = new Student(2, "PQR", 90);
        sPQR.display();

        // Update via setters and show getters
        sPQR.setRollno(3);
        sPQR.setName("Bramha");
        sPQR.setMarks(95);
        System.out.println("Updated via getters: " + sPQR.getRollno() + ", " + sPQR.getName() + ", " + sPQR.getMarks());
    }
}
