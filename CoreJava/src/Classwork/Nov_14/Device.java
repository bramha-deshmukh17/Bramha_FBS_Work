package Classwork.Nov_14;

abstract class Device {
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

    public String toString() {
        return "Brand: " + brand + " Power (W): " + powerRatingWatts;
    }

    abstract void operate();
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

    public String toString() {
        return super.toString() + " Temperature (°C): " + temperatureCelsius + " Mode: " + mode;
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

    public String toString() {
        return super.toString() + " Speed Level: " + speedLevel;
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

    public String toString() {
        return super.toString() + " Water Level (L): " + waterLevelLiters;
    }

    void operate() {
        System.out.println("Cooler is operating with water level " + waterLevelLiters + " L");
    }
}

class TestDevices {
    public static void main(String[] args) {
        Device d;

        d = new AC("LG", 1800, 22.5, "Cool");
        System.out.println(d.toString());
        d.operate();

        d = new Fan("Bajaj", 75, 2);
        System.out.println(d);
        d.operate();

        d = new Cooler("Symphony", 200, 5.0);
        System.out.println(d.toString());
        d.operate();
    }
}
