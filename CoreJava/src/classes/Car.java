package classes;
class Car {
    String model;
    String brand;
    int price;
    int fuelCapacity;
    String color;

    // Default constructor
    Car() {
        this.model = "";
        this.brand = "";
        this.price = 0;
        this.fuelCapacity = 0;
        this.color = "";
    }

    // Parameterized constructor
    Car(String model, String brand, int price, int fuelCapacity, String color) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.fuelCapacity = fuelCapacity;
        this.color = color;
    }

    // Getters
    String getModel() {
        return model;
    }

    String getBrand() {
        return brand;
    }

    int getPrice() {
        return price;
    }

    int getFuelCapacity() {
        return fuelCapacity;
    }

    String getColor() {
        return color;
    }

    // Setters
    void setModel(String model) {
        this.model = model;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    void setPrice(int price) {
        this.price = price;
    }

    void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    void setColor(String color) {
        this.color = color;
    }

    // Display method
    void display() {
        System.out.println("Car Details:");
        System.out.println("Model: " + model);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Fuel Capacity: " + fuelCapacity);
        System.out.println("Color: " + color);
    }
}

class CarDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Car c1 = new Car();
        c1.setModel("Civic");
        c1.setBrand("Honda");
        c1.setPrice(20000);
        c1.setFuelCapacity(45);
        c1.setColor("Red");
        c1.display();

        // Using getters
        System.out.println("Data: " + c1.getModel() + ", " + c1.getBrand() + ", " + c1.getPrice() + ", " + c1.getFuelCapacity() + ", " + c1.getColor());

        // Using parameterized constructor
        Car c2 = new Car("Model S", "Tesla", 80000, 75, "Blue");
        c2.display();

        // Update via setters and show getters
        c2.setModel("Model 3");
        c2.setBrand("Tesla");
        c2.setPrice(45000);
        c2.setFuelCapacity(60);
        c2.setColor("Black");
        System.out.println("Data: " + c2.getModel() + ", " + c2.getBrand() + ", " + c2.getPrice() + ", " + c2.getFuelCapacity() + ", " + c2.getColor());

       }
}