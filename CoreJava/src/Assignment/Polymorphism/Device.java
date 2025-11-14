package Assignment.Polymorphism;

class Device {
    String brand;
    double powerRatingWatts;

    Device() {
    }

    Device(String brand, double powerRatingWatts) {
        this.brand = brand;
        this.powerRatingWatts = powerRatingWatts;
    }

    String getBrand() {
        return brand;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    double getPowerRatingWatts() {
        return powerRatingWatts;
    }

    void setPowerRatingWatts(double powerRatingWatts) {
        this.powerRatingWatts = powerRatingWatts;
    }

    void display() {
        System.out.println("\nBrand: " + brand);
        System.out.println("Power (W): " + powerRatingWatts);
    }

    void operate() {
        System.out.println("Operating a generic device...");
    }
}

class AC extends Device {
    double temperatureCelsius;
    String mode;

    AC(String brand, double powerRatingWatts, double temperatureCelsius, String mode) {
        super(brand, powerRatingWatts);
        this.temperatureCelsius = temperatureCelsius;
        this.mode = mode;
    }

    double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    void setTemperatureCelsius(double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    String getMode() {
        return mode;
    }

    void setMode(String mode) {
        this.mode = mode;
    }

    void display() {
        super.display();
        System.out.println("Temperature (°C): " + temperatureCelsius);
        System.out.println("Mode: " + mode);
    }

    void operate() {
        System.out.println("AC is operating at " + temperatureCelsius + "°C in " + mode + " mode.");
    }
}

class Fan extends Device {
    int speedLevel;

    Fan(String brand, double powerRatingWatts, int speedLevel) {
        super(brand, powerRatingWatts);
        this.speedLevel = speedLevel;
    }

    int getSpeedLevel() {
        return speedLevel;
    }

    void setSpeedLevel(int speedLevel) {
        this.speedLevel = speedLevel;
    }

    void display() {
        super.display();
        System.out.println("Speed Level: " + speedLevel);
    }

    void operate() {
        System.out.println("Fan is running at speed level " + speedLevel);
    }
}

class Cooler extends Device {
    double waterLevelLiters;

    Cooler(String brand, double powerRatingWatts, double waterLevelLiters) {
        super(brand, powerRatingWatts);
        this.waterLevelLiters = waterLevelLiters;
    }

    double getWaterLevelLiters() {
        return waterLevelLiters;
    }

    void setWaterLevelLiters(double waterLevelLiters) {
        this.waterLevelLiters = waterLevelLiters;
    }

    void display() {
        super.display();
        System.out.println("Water Level (L): " + waterLevelLiters);
    }

    void operate() {

        System.out.println("Cooler is operating with water level " + waterLevelLiters + " L");

    }
}

class TestDevices {
    public static void main(String[] args) {
        Device d;

        d = new AC("LG", 1800, 22.5, "Cool");
        d.display();
        d.operate();

        d = new Fan("Bajaj", 75, 2);
        d.display();
        d.operate();

        d = new Cooler("Symphony", 200, 5.0);
        d.display();
        d.operate();
    }
}
