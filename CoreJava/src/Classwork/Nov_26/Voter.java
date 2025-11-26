package Classwork.Nov_26;

public class Voter {
	int age;

	Voter(int age) {
		this.age = age;
	}

	void validate() throws InvalidAgeException {

		if (age < 18)
			throw new InvalidAgeException();
		else
			System.out.println("You can vote");

	}

}

class VoterTest {

	public static void main(String[] args) {
		Voter v1 = new Voter(50);
		try {
			v1.validate();
		} catch (InvalidAgeException e) {
			System.out.println(e);
		}
	}
}
