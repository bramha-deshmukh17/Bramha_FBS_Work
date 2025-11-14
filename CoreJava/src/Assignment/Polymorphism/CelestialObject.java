package Assignment.Polymorphism;

class CelestialObject {
    String name;
    double mass;
    double radius;
    double distanceFromEarth;

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

    double getDensity() {
        double radiusMeters = radius * 1000.0;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radiusMeters, 3);
        if (volume == 0.0)
            return 0.0;
        return mass / volume;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Mass (kg): " + mass);
        System.out.println("Radius (km): " + radius);
        System.out.println("Distance from Earth (light years): " + distanceFromEarth);
        System.out.println("Average Density (kg/m^3): " + getDensity());
    }

    void shine() {
        System.out.println(name + " interacts with light in space.");
    }

}

class Star extends CelestialObject {
    int no_of_planets_revolving;
    String starType;

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

    void shine() {
        System.out.println(name + " shines brightly in space.");
    }

}

class BlackHole extends CelestialObject {
    double eventHorizonRadius;
    double radiationEmitted;
    String blackHoleType;

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

    void shine() {
        System.out.println(name + " reflects sunlight in space.");
    }

}

class Planet extends CelestialObject {
    boolean hasLife;
    double orbitalPeriod;

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

    void shine() {
        System.out.println(name + " glows via accretion disk in space.");
    }

}

class CelestialDemo {
    public static void main(String[] args) {
        Star sun = new Star("Sun", 198900030, 696340, 0.0, 8, "Yellow Dwarf");
        BlackHole ton618 = new BlackHole("TON 618", 600000040, 0.0, 10400, 200000000, 858600013, "Quasar");
        Planet earth = new Planet("Earth", 511097224, 6371, 0.0, true, 1.0);

        System.out.println("Star Details:");
        sun.display();
        sun.shine();

        System.out.println("\nBlack Hole Details:");
        ton618.display();
        ton618.shine();

        System.out.println("\nPlanet Details:");
        earth.display();
        earth.shine();
    }
}
