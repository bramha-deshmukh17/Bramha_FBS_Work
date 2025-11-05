class Distance {
    int km;
    int mtr;

    // Default constructor
    Distance() {
        this.km = 0;
        this.mtr = 0;
    }

    // Parameterized constructor
    Distance(int km, int mtr) {
        this.km = km;
        this.mtr = mtr;
    }

    // Getters
    int getKm() {
        return km;
    }

    int getMtr() {
        return mtr;
    }

    // Setters
    void setKm(int km) {
        this.km = km;
    }

    void setMtr(int mtr) {
        this.mtr = mtr;
    }

    // Display method
    void display() {
        System.out.println("Distance:");
        System.out.println("Km: " + km);
        System.out.println("Mtr: " + mtr);
    }
}

class DistanceDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Distance d1 = new Distance();
        d1.setKm(1);
        d1.setMtr(250);
        d1.display();

        // Using getters
        System.out.println("Data: " + d1.getKm() + " km, " + d1.getMtr() + " m");

        // Using parameterized constructor
        Distance d2 = new Distance(2, 500);
        d2.display();

        // Update via setters and show getters
        d2.setKm(3);
        d2.setMtr(750);
        System.out.println("Data: " + d2.getKm() + " km, " + d2.getMtr() + " m");

    }
}
