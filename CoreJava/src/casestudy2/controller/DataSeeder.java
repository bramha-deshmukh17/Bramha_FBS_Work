package casestudy2.controller;

import casestudy2.model.*;

import java.util.concurrent.atomic.AtomicInteger;

public class DataSeeder {

    public static House createDefaultHouse(AtomicInteger roomCounter) {
        House house = new House();

        // --- Bedroom ---
        Room bedroom = new Room(20.5, "bedroom");
        bedroom.setRoomId(roomCounter.getAndIncrement());
        bedroom.addDevice(new Light(1, "White", 80));
        bedroom.addDevice(new Fan(2, 3, 2));
        bedroom.addDevice(new Ac(3, 24, 3, "Cool"));
        house.addRoom(bedroom);

        // --- Kitchen ---
        Room kitchen = new Room(15.0, "kitchen");
        kitchen.setRoomId(roomCounter.getAndIncrement());
        kitchen.addDevice(new Light(1, "Warm White", 90));
        kitchen.addDevice(new Tv(2, 10, 25, "Kitchen TV", Tv.ipSource.HDMI1));
        house.addRoom(kitchen);

        // --- Bathroom ---
        Room bathroom = new Room(9.2, "bathroom");
        bathroom.setRoomId(roomCounter.getAndIncrement());
        bathroom.addDevice(new Light(1, "Blue", 50));
        bathroom.addDevice(new Shower(2, 38.5, 7));
        house.addRoom(bathroom);

        // --- Hall ---
        Room hall = new Room(30.0, "hall");
        hall.setRoomId(roomCounter.getAndIncrement());
        hall.addDevice(new Light(1, "Yellow", 100));
        hall.addDevice(new Tv(2, 5, 40, "Living Room TV", Tv.ipSource.HDMI2));
        hall.addDevice(new Ac(3, 22, 4, "Auto"));
        house.addRoom(hall);

        return house;
    }
}
