package Classwork.Nov_12;


class Defence {

	int no_of_troops, no_of_dept, no_of_vehicle, manPowerCount, no_of_casulaties, no_of_mission;
	double budget;
	String locationOfHeadquater, countryCount, nameOfHead;

	Defence() {
	}

	Defence(int no_of_troops, int no_of_dept, int no_of_vehicle, int manPowerCount, int no_of_casulaties,
			int no_of_mission, double budget, String locationOfHeadquater, String countryCount, String nameOfHead) {
		this.no_of_troops = no_of_troops;
		this.no_of_dept = no_of_dept;
		this.no_of_vehicle = no_of_vehicle;
		this.manPowerCount = manPowerCount;
		this.no_of_casulaties = no_of_casulaties;
		this.no_of_mission = no_of_mission;
		this.budget = budget;
		this.locationOfHeadquater = locationOfHeadquater;
		this.countryCount = countryCount;
		this.nameOfHead = nameOfHead;
	}

	int getNo_of_troops() {
		return no_of_troops;
	}

	void setNo_of_troops(int no_of_troops) {
		this.no_of_troops = no_of_troops;
	}

	int getNo_of_dept() {
		return no_of_dept;
	}

	void setNo_of_dept(int no_of_dept) {
		this.no_of_dept = no_of_dept;
	}

	int getNo_of_vehicle() {
		return no_of_vehicle;
	}

	void setNo_of_vehicle(int no_of_vehicle) {
		this.no_of_vehicle = no_of_vehicle;
	}

	String getNameOfHead() {
		return nameOfHead;
	}

	void setNameOfHead(String nameOfHead) {
		this.nameOfHead = nameOfHead;
	}

	int getManPowerCount() {
		return manPowerCount;
	}

	void setManPowerCount(int manPowerCount) {
		this.manPowerCount = manPowerCount;
	}

	int getNo_of_casulaties() {
		return no_of_casulaties;
	}

	void setNo_of_casulaties(int no_of_casulaties) {
		this.no_of_casulaties = no_of_casulaties;
	}

	int getNo_of_mission() {
		return no_of_mission;
	}

	void setNo_of_mission(int no_of_mission) {
		this.no_of_mission = no_of_mission;
	}

	double getBudget() {
		return budget;
	}

	void setBudget(double budget) {
		this.budget = budget;
	}

	String getLocationOfHeadquater() {
		return locationOfHeadquater;
	}

	void setLocationOfHeadquater(String locationOfHeadquater) {
		this.locationOfHeadquater = locationOfHeadquater;
	}

	String getCountryCount() {
		return countryCount;
	}

	void setCountryCount(String countryCount) {
		this.countryCount = countryCount;
	}

	void display() {
		System.out.println("No. of troops: " + no_of_troops);
		System.out.println("No. of dept: " + no_of_dept);
		System.out.println("No. of vehicle: " + no_of_vehicle);
		System.out.println("Man PowerCount: " + manPowerCount);
		System.out.println("No of casulaties: " + no_of_casulaties);
		System.out.println("No of mission: " + no_of_mission);
		System.out.println("Budget: " + budget);
		System.out.println("Location Of Headquater: " + locationOfHeadquater);
		System.out.println("Country Count: " + countryCount);
		System.out.println("Name Of Head: " + nameOfHead);
	}
	
	void attack() {
		System.out.println("Attacked");
	}
}

class Army extends Defence {

	int no_of_tanks, no_of_guns, no_of_grrenade, no_of_batalin;

	Army() {
	}

	Army(int no_of_troops, int no_of_dept, int no_of_vehicle, int manPowerCount, int no_of_casulaties,
			int no_of_mission, double budget, String locationOfHeadquater, String countryCount, String nameOfHead,
			int no_of_tanks, int no_of_guns, int no_of_grrenade, int no_of_batalin) {

		super(no_of_troops, no_of_dept, no_of_vehicle, manPowerCount, no_of_casulaties, no_of_mission, budget,
				locationOfHeadquater, countryCount, nameOfHead);

		this.no_of_tanks = no_of_tanks;
		this.no_of_guns = no_of_guns;
		this.no_of_grrenade = no_of_grrenade;
		this.no_of_batalin = no_of_batalin;
	}

	int getNo_of_tanks() {
		return no_of_tanks;
	}

	void setNo_of_tanks(int no_of_tanks) {
		this.no_of_tanks = no_of_tanks;
	}

	int getNo_of_guns() {
		return no_of_guns;
	}

	void setNo_of_guns(int no_of_guns) {
		this.no_of_guns = no_of_guns;
	}

	int getNo_of_grrenade() {
		return no_of_grrenade;
	}

	void setNo_of_grrenade(int no_of_grrenade) {
		this.no_of_grrenade = no_of_grrenade;
	}

	int getNo_of_batalin() {
		return no_of_batalin;
	}

	void setNo_of_batalin(int no_of_batalin) {
		this.no_of_batalin = no_of_batalin;
	}

	void display() {
		super.display();
		System.out.println("No. of tanks: " + no_of_tanks);
		System.out.println("No. of guns: " + no_of_guns);
		System.out.println("No. of grrenade: " + no_of_grrenade);
		System.out.println("No. of batalin: " + no_of_batalin);
	}
	
	void attack() {
		System.out.println("Attacked using guns and granade");
	}
}

class Navy extends Defence {

	int no_of_ships, no_of_submarine, no_of_torpedo;

	Navy() {
	}

	Navy(int no_of_troops, int no_of_dept, int no_of_vehicle, int manPowerCount, int no_of_casulaties,
			int no_of_mission, double budget, String locationOfHeadquater, String countryCount, String nameOfHead,
			int no_of_ships, int no_of_submarine, int no_of_torpedo) {
		super(no_of_troops, no_of_dept, no_of_vehicle, manPowerCount, no_of_casulaties, no_of_mission, budget,
				locationOfHeadquater, countryCount, nameOfHead);
		this.no_of_ships = no_of_ships;
		this.no_of_submarine = no_of_submarine;
		this.no_of_torpedo = no_of_torpedo;
	}

	int getNo_of_ships() {
		return no_of_ships;
	}

	void setNo_of_ships(int no_of_ships) {
		this.no_of_ships = no_of_ships;
	}

	int getNo_of_submarine() {
		return no_of_submarine;
	}

	void setNo_of_submarine(int no_of_submarine) {
		this.no_of_submarine = no_of_submarine;
	}

	int getNo_of_torpedo() {
		return no_of_torpedo;
	}

	void setNo_of_torpedo(int no_of_torpedo) {
		this.no_of_torpedo = no_of_torpedo;
	}

	void display() {
		super.display();
		System.out.println("No. of ships: " + no_of_ships);
		System.out.println("No. of submarine: " + no_of_submarine);
		System.out.println("No. of torpedo: " + no_of_torpedo);
	}
	
	void attack() {
		System.out.println("Attacked using torpedo");
	}
}

class AirForce extends Defence {

	int no_of_missiles, no_of_aircrafet, no_of_sqadron;

	AirForce() {
	}

	AirForce(int no_of_troops, int no_of_dept, int no_of_vehicle, int manPowerCount, int no_of_casulaties,
			int no_of_mission, double budget, String locationOfHeadquater, String countryCount, String nameOfHead,
			int no_of_missiles, int no_of_aircrafet, int no_of_sqadron) {
		super(no_of_troops, no_of_dept, no_of_vehicle, manPowerCount, no_of_casulaties, no_of_mission, budget,
				locationOfHeadquater, countryCount, nameOfHead);
		this.no_of_missiles = no_of_missiles;
		this.no_of_aircrafet = no_of_aircrafet;
		this.no_of_sqadron = no_of_sqadron;
	}

	int getNo_of_missiles() {
		return no_of_missiles;
	}

	void setNo_of_missiles(int no_of_missiles) {
		this.no_of_missiles = no_of_missiles;
	}

	int getNo_of_aircrafet() {
		return no_of_aircrafet;
	}

	void setNo_of_aircrafet(int no_of_aircrafet) {
		this.no_of_aircrafet = no_of_aircrafet;
	}

	int getNo_of_sqadron() {
		return no_of_sqadron;
	}

	void setNo_of_sqadron(int no_of_sqadron) {
		this.no_of_sqadron = no_of_sqadron;
	}

	void display() {
		super.display();
		System.out.println("No. of missiles: " + no_of_missiles);
		System.out.println("No. of aircrafet: " + no_of_aircrafet);
		System.out.println("No. of sqadron: " + no_of_sqadron);
	}
	
	void attack() {
		System.out.println("Attacked using aircrafts");
	}
}

class DefenceDemo{
	public static void main(String[] args) {
		
		Army army = new Army(
				800000, 7, 4500, 650000, 300, 120,
				4500000.0, "New Delhi", "35", "Gen. Rao",
				3500, 500000, 200000, 60);

		Navy navy = new Navy(
				250000, 3, 1200, 200000, 100, 60,
				1800000.0, "Mumbai", "35", "Adm. Singh",
				150, 20, 300);

		AirForce airForce = new AirForce(
				300000, 4, 1500, 250000, 120, 80,
				2200000.0, "Bengaluru", "35", "ACM Kumar",
				500, 200, 30);

		System.out.println("Army:");
		army.display();
		army.attack();

		System.out.println("\nNavy:");
		navy.display();
		navy.attack();

		System.out.println("\nAirForce:");
		airForce.display();
		airForce.attack();
	}
}