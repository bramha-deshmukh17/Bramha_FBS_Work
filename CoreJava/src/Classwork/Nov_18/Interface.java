package Classwork.Nov_18;

interface Racer {
	void toRace();
}

interface Product {
	void buy();

	void sell();
}

class Vehicle {

	void ride() {
		System.out.println("Riding in vehicle");
	}

	void travel() {
		System.out.println("Traveling in vehicle");
	}

	void brake() {
		System.out.println("brake applied");
	}
}

abstract class Animal {

	abstract void eat();

	abstract void walk();
}

class SportsCar extends Vehicle implements Racer, Product {
	public void buy() {
		System.out.println("buying sports car ");

	}

	public void sell() {
		System.out.println("selling sports car");

	}

	public void toRace() {
		System.out.println("Racing in sports car");

	}

}

class Horse extends Animal implements Racer, Product {

	public void buy() {
		System.out.println("buying horse ");

	}

	public void sell() {
		System.out.println("selling horse");

	}

	public void toRace() {
		System.out.println("Racing on horse");

	}

	void eat() {
		System.out.println("Horse eating");

	}

	void walk() {
		System.out.println("Hore walking");

	}
}

class Lion extends Animal {

	void eat() {
		System.out.println("Lion eating");

	}

	void walk() {
		System.out.println("Lion walk");

	}

}

class DemoInterface {

	public static void main(String[] args) {
		SportsCar s = new SportsCar();
		s.toRace();
		s.brake();
	}

}