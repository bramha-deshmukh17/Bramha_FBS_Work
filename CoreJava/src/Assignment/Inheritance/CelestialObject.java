package Assignment.Inheritance;

class CelestialObject {
    String name;
    double mass; // in kilograms
    double radius; // in kilometers
    double distanceFromEarth; // in light years

    CelestialObject() {
    }

    CelestialObject(String name, double mass, double radius, double distanceFromEarth) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.distanceFromEarth = distanceFromEarth;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getMass() {
        return mass;
    }

    void setMass(double mass) {
        this.mass = mass;
    }

    double getRadius() {
        return radius;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    void setDistanceFromEarth(double distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Mass (kg): " + mass);
        System.out.println("Radius (km): " + radius);
        System.out.println("Distance from Earth (light years): " + distanceFromEarth);
    }
}

class Star extends CelestialObject {
    int no_of_planets_revolving;
    String starType; // e.g. Red Dwarf, Yellow Dwarf, Supergiant

    Star() {
    }

    Star(String name, double mass, double radius, double distanceFromEarth, int no_of_planets_revolving,
            String starType) {
        super(name, mass, radius, distanceFromEarth);
        this.no_of_planets_revolving = no_of_planets_revolving;
        this.starType = starType;
    }

    int getNo_of_planets_revolving() {
        return no_of_planets_revolving;
    }

    void setNo_of_planets_revolving(int no_of_planets_revolving) {
        this.no_of_planets_revolving = no_of_planets_revolving;
    }

    String getStarType() {
        return starType;
    }

    void setStarType(String starType) {
        this.starType = starType;
    }

    void display() {
        super.display();
        System.out.println("No. of Planets Revolving: " + no_of_planets_revolving);
        System.out.println("Star Type: " + starType);
    }
}

class BlackHole extends CelestialObject {
    double eventHorizonRadius; // in kilometers
    double radiationEmitted; // in watts
    String blackHoleType; // e.g., Stellar, Supermassive, Quasar

    BlackHole() {
    }

    BlackHole(String name, double mass, double radius, double distanceFromEarth,
            double eventHorizonRadius, double radiationEmitted, String blackHoleType) {
        super(name, mass, radius, distanceFromEarth);
        this.eventHorizonRadius = eventHorizonRadius;
        this.radiationEmitted = radiationEmitted;
        this.blackHoleType = blackHoleType;
    }

    double getEventHorizonRadius() {
        return eventHorizonRadius;
    }

    void setEventHorizonRadius(double eventHorizonRadius) {
        this.eventHorizonRadius = eventHorizonRadius;
    }

    double getRadiationEmitted() {
        return radiationEmitted;
    }

    void setRadiationEmitted(double radiationEmitted) {
        this.radiationEmitted = radiationEmitted;
    }

    String getBlackHoleType() {
        return blackHoleType;
    }

    void setBlackHoleType(String blackHoleType) {
        this.blackHoleType = blackHoleType;
    }

    void display() {
        super.display();
        System.out.println("Event Horizon Radius (km): " + eventHorizonRadius);
        System.out.println("Radiation Emitted (W): " + radiationEmitted);
        System.out.println("Black Hole Type: " + blackHoleType);
    }
}

class Planet extends CelestialObject {
    boolean hasLife;
    double orbitalPeriod; // in Earth years

    Planet() {
    }

    Planet(String name, double mass, double radius, double distanceFromEarth, boolean hasLife, double orbitalPeriod) {
        super(name, mass, radius, distanceFromEarth);
        this.hasLife = hasLife;
        this.orbitalPeriod = orbitalPeriod;
    }

    boolean getHasLife() {
        return hasLife;
    }

    void setHasLife(boolean hasLife) {
        this.hasLife = hasLife;
    }

    double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    void display() {
        super.display();
        System.out.println("Has Life: " + hasLife);
        System.out.println("Orbital Period (Earth years): " + orbitalPeriod);
    }
}

class CelestialDemo {
    public static void main(String[] args) {
        Star sun = new Star("Sun", 10000003000.054, 696340, 0, 8, "Yellow Dwarf");
        BlackHole quasar = new BlackHole("TON 618", 6.6e40, 0, 10400, 200000000, 78586000003000.230, "Quasar");

        Planet earth = new Planet("Earth", 5000000.545, 6371, 0, true, 1.0);

        System.out.println("Star Details:");
        sun.display();

        System.out.println("\nBlack Hole Details:");
        quasar.display();

        System.out.println("\nPlanet Details:");
        earth.display();
    }
}
