package Classwork.Nov_12;


class Vehicle {
    String name;
    String model;

    Vehicle() {
    }

    Vehicle(String name, String model) {
        this.name = name;
        this.model = model;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    void display() {
        System.out.println("\nVehicle name:" + name );
        System.out.println("model:" + model);
    }
    
    void brake() {
    	System.out.println("Brake Applied");
    }
}
class Car extends Vehicle {
    int doors;
    boolean sunroof;
    String fuelType;

    Car() {
    }

    Car(String name, String model, int doors, boolean sunroof, String fuelType) {
        super(name, model);
        this.doors = doors;
        this.sunroof = sunroof;
        this.fuelType = fuelType;
    }

    int getDoors() {
        return doors;
    }

    void setDoors(int doors) {
        this.doors = doors;
    }

    boolean isSunroof() {
        return sunroof;
    }

    void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    String getFuelType() {
        return fuelType;
    }

    void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    void display() {
        super.display();
        System.out.println("no. of doors:" + this.doors);
        System.out.println("sunroof:" + this.sunroof);
        System.out.println("fuel type:" + this.fuelType);
    }
    
    void brake() {
    	System.out.println("Drum Brake Applied");
    }
}

class Bike extends Vehicle {
    int engineCC;
    boolean hasABS;

    Bike() {
    }

    Bike(String name, String model, int engineCC, boolean hasABS) {
        super(name, model);
        this.engineCC = engineCC;
        this.hasABS = hasABS;
    }


    void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    void setHasABS(boolean hasABS) {
        this.hasABS = hasABS;
    }

    int getEngineCC() {
        return engineCC;
    }
    boolean getHasABS() {
        return hasABS;
    }

    void display() {
        super.display();
        System.out.println("engine (cc):" + this.engineCC);
        System.out.println("has ABS:" + this.hasABS);
    }
    
    void brake() {
    	System.out.println("Disc Brake Applied");
    }
}

class Bus extends Vehicle {
    int seatingCapacity;
    boolean hasAC;
    String routeNumber;

    Bus() {
    }

    Bus(String name, String model, int seatingCapacity) {
        super(name, model);
        this.seatingCapacity = seatingCapacity;
    }

    Bus(String name, String model, int seatingCapacity, boolean hasAC, String routeNumber) {
        super(name, model);
        this.seatingCapacity = seatingCapacity;
        this.hasAC = hasAC;
        this.routeNumber = routeNumber;
    }

    int getSeatingCapacity() {
        return seatingCapacity;
    }

    void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    boolean isHasAC() {
        return hasAC;
    }

    void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    String getRouteNumber() {
        return routeNumber;
    }

    void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    void display() {
        super.display();
        System.out.println("seating capacity:" + seatingCapacity);
        System.out.println("has AC:" + hasAC);
        System.out.println("route number:" + routeNumber);
    }
    
    void brake() {
    	System.out.println("Air Brake Applied");
    }
}

class VehicleDemo {
	public static void main(String[] args) {
        Car car = new Car("Honda", "Civic", 4, true, "Petrol");
        car.display();
        car.brake();

        Bike bike = new Bike("Yamaha", "MT-15", 155, true);
        bike.display();
        bike.brake();
        
        Bus bus = new Bus("Volvo", "9400", 48, true, "B12");
        bus.display();
        bus.brake();
    }
}
