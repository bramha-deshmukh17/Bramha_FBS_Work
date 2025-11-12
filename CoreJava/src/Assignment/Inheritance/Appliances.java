package Assignment.Inheritance;

class Appliance {
    String brand;
    double powerRating;
    int warrantyYears;
    double price;

    Appliance() {
    }

    Appliance(String brand, double powerRating, int warrantyYears, double price) {
        this.brand = brand;
        this.powerRating = powerRating;
        this.warrantyYears = warrantyYears;
        this.price = price;
    }

    String getBrand() {
        return brand;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    double getPowerRating() {
        return powerRating;
    }

    void setPowerRating(double powerRating) {
        this.powerRating = powerRating;
    }

    int getWarrantyYears() {
        return warrantyYears;
    }

    void setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Power Rating (W): " + powerRating);
        System.out.println("Warranty Years: " + warrantyYears);
        System.out.println("Price: " + price);
    }
}

class Refrigerator extends Appliance {
    int capacityLiters;
    boolean hasFreezer;

    Refrigerator() {
    }

    Refrigerator(String brand, double powerRating, int warrantyYears, double price, int capacityLiters,
            boolean hasFreezer) {
        super(brand, powerRating, warrantyYears, price);
        this.capacityLiters = capacityLiters;
        this.hasFreezer = hasFreezer;
    }

    int getCapacityLiters() {
        return capacityLiters;
    }

    void setCapacityLiters(int capacityLiters) {
        this.capacityLiters = capacityLiters;
    }

    boolean isHasFreezer() {
        return hasFreezer;
    }

    void setHasFreezer(boolean hasFreezer) {
        this.hasFreezer = hasFreezer;
    }

    void display() {
        super.display();
        System.out.println("Capacity (liters): " + capacityLiters);
        System.out.println("Has Freezer: " + hasFreezer);
    }
}

class Washer extends Appliance {
    double drumSizeKg;
    int spinSpeedRpm;

    Washer() {
    }

    Washer(String brand, double powerRating, int warrantyYears, double price, double drumSizeKg, int spinSpeedRpm) {
        super(brand, powerRating, warrantyYears, price);
        this.drumSizeKg = drumSizeKg;
        this.spinSpeedRpm = spinSpeedRpm;
    }

    double getDrumSizeKg() {
        return drumSizeKg;
    }

    void setDrumSizeKg(double drumSizeKg) {
        this.drumSizeKg = drumSizeKg;
    }

    int getSpinSpeedRpm() {
        return spinSpeedRpm;
    }

    void setSpinSpeedRpm(int spinSpeedRpm) {
        this.spinSpeedRpm = spinSpeedRpm;
    }

    void display() {
        super.display();
        System.out.println("Drum Size (kg): " + drumSizeKg);
        System.out.println("Spin Speed (RPM): " + spinSpeedRpm);
    }
}

class Oven extends Appliance {
    String fuelType;
    int numberOfRacks;

    Oven() {
    }

    Oven(String brand, double powerRating, int warrantyYears, double price, String fuelType, int numberOfRacks) {
        super(brand, powerRating, warrantyYears, price);
        this.fuelType = fuelType;
        this.numberOfRacks = numberOfRacks;
    }

    String getFuelType() {
        return fuelType;
    }

    void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    int getNumberOfRacks() {
        return numberOfRacks;
    }

    void setNumberOfRacks(int numberOfRacks) {
        this.numberOfRacks = numberOfRacks;
    }

    void display() {
        super.display();
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Number Of Racks: " + numberOfRacks);
    }
}

class ApplianceDemo {
    public static void main(String[] args) {
        Refrigerator fridge = new Refrigerator("Haier", 120.0, 2, 599.99, 320, true);
        Washer washer = new Washer("LG", 200.0, 3, 449.99, 7.5, 1400);
        Oven oven = new Oven("Samsung", 1500.0, 1, 299.99, "Electric", 3);

        System.out.println("Refrigerator:");
        fridge.display();

        System.out.println("\nWasher:");
        washer.display();

        System.out.println("\nOven:");
        oven.display();
    }
}
