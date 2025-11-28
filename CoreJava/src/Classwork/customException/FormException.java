package Classwork.customException;

class EmptyNameException extends Exception {

	@Override
	public String toString() {
		return " Name is empty or contains only spaces.";
	}
}

class UnderAgeException extends Exception {
	@Override
	public String toString() {
		return "Student should be at least 17 year old.";
	}
}

class InvalidPercentageException extends Exception {

	@Override
	public String toString() {

		return "Percentage can't be more than 100% or less than 0";

	}
}

class NotFitForAdmissionException extends Exception {
	@Override
	public String toString() {

		return "Not fit for admission percentage should be at least 35";
	}
}

class FeesNotPaidException extends Exception {
	@Override
	public String toString() {
		return "Pay some fees";
	}
}

class InsufficientFeesException extends Exception {
	@Override
	public String toString() {
		return "Pay at least 30% course fees";
	}
}
