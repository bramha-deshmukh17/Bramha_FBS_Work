package Classwork.customException;

class AdmissionForm {
	String studentName;

	int age;

	double percentage, courseFees, feesPaid;

	AdmissionForm(String studentName, int age, double percentage, double courseFees, double feesPaid) {
		super();
		this.studentName = studentName;
		this.age = age;
		this.percentage = percentage;
		this.courseFees = courseFees;
		this.feesPaid = feesPaid;
	}

	void validateForm() throws EmptyNameException, UnderAgeException, InvalidPercentageException,
			NotFitForAdmissionException, FeesNotPaidException, InsufficientFeesException {

		if (studentName.trim().isEmpty()) {
			throw new EmptyNameException();
		} else if (age < 17) {
			throw new UnderAgeException();
		} else if (percentage < 0 || percentage > 100) {
			throw new InvalidPercentageException();
		} else if (percentage < 35) {
			throw new NotFitForAdmissionException();
		} else if (feesPaid <= 0) {
			throw new FeesNotPaidException();
		} else if (feesPaid < (courseFees * 0.3)) {
			throw new InsufficientFeesException();
		} else {
			System.out.println("Admission Successful!");
		}

	}

}

class AdmissionFormTest {
	public static void main(String[] args) {
		AdmissionForm a1 = new AdmissionForm("Bramha", 15, 45, 10000, 5000);
		try {
			a1.validateForm();
		} catch (EmptyNameException | UnderAgeException | InvalidPercentageException | NotFitForAdmissionException
				| FeesNotPaidException | InsufficientFeesException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
