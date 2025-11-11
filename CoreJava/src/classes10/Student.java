package classes10;
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
        Student s1 = new Student();
        s1.setRollno(1);
        s1.setName("Abc");
        s1.setMarks(85);
        s1.display();

        // Using getters
        System.out.println("Data: " + s1.getRollno() + ", " + s1.getName() + ", " + s1.getMarks());

        // Using parameterized constructor
        Student s2 = new Student(2, "PQR", 90);
        s2.display();

        // Update via setters and show getters
        s2.setRollno(3);
        s2.setName("Bramha");
        s2.setMarks(95);
        System.out.println("Data: " + s2.getRollno() + ", " + s2.getName() + ", " + s2.getMarks());
    }
}
