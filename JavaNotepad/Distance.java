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
        Distance dAbc = new Distance();
        dAbc.setKm(1);
        dAbc.setMtr(250);
        dAbc.display();

        // Using getters
        System.out.println("Getter check: " + dAbc.getKm() + " km, " + dAbc.getMtr() + " m");

        // Using parameterized constructor
        Distance dPQR = new Distance(2, 500);
        dPQR.display();

        // Update via setters and show getters
        dPQR.setKm(3);
        dPQR.setMtr(750);
        System.out.println("Updated via getters: " + dPQR.getKm() + " km, " + dPQR.getMtr() + " m");

        // Another object using setters
        Distance dBramha = new Distance();
        dBramha.setKm(0);
        dBramha.setMtr(100);
        dBramha.display();
    }
}
