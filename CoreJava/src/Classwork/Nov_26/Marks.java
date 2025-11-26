package Classwork.Nov_26;

class Student {
	double m1;
	int rollNo;
	String name;

	Student(double m1, int rollNo, String name) {
		this.m1 = m1;
		this.rollNo = rollNo;
		this.name = name;
	}

	void showResult() throws InvalidMarksException {

		if (m1 < 0 || m1 > 100) {
			throw new InvalidMarksException();
		} else if (m1 >= 75) {
			System.out.println("Distiction");
		} else if (m1 >= 60) {
			System.out.println("First class");
		} else if (m1 >= 50) {
			System.out.println("Second class");
		} else if (m1 >= 35) {
			System.out.println("Pass class");
		} else
			System.out.println("Fail");
	}

}

class StudentTest {
	public static void main(String[] args) {
		Student s = new Student(-35, 101, "Bramha");

		try {
			s.showResult();
		} catch (InvalidMarksException e) {
			System.out.println(e);
		}
	}
}