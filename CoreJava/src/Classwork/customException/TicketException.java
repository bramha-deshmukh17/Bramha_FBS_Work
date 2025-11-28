package Classwork.customException;

class InvalidTicketNumberException extends Exception {

	@Override
	public String toString() {
		return "Invalid ticket number. Enter more than 0.";
	}
}

class TicketsSoldOutException extends Exception {

	@Override
	public String toString() {
		return "Requested number of tickets exceeds availability! ";
	}
}
