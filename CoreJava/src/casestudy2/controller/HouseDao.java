package casestudy2.controller;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import casestudy2.model.*;

public class HouseDao {

    private House house;

    // Room ID auto generator starting from 100
    AtomicInteger ROOM_COUNTER = new AtomicInteger(100);

    final String FILE_NAME = "house.txt";
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    /*
     * ========================= Constructor & Persistence =========================
     */

    public HouseDao() {
        File file = new File(FILE_NAME);

        try {
            if (!file.exists() || file.length() == 0) {
                System.out.println("No existing data found. Seeding initial data...");
                house = DataSeeder.createDefaultHouse(ROOM_COUNTER);
                saveToFile();
                return;
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

                Object obj = ois.readObject();
                house = (obj instanceof House && obj != null) ? (House) obj : new House();

            } catch (ClassNotFoundException e) {
                System.out.println("Invalid data format. Initializing empty house.");
                house = new House();
            }

            // Find the highest existing room ID to set the counter correctly
            int maxId = 99;
            for (Room room : house.getRooms()) {
                if (room.getRoomId() > maxId) {
                    maxId = room.getRoomId();
                }
            }
            // Set the counter to one more than the highest found ID
            ROOM_COUNTER.set(maxId + 1);

        } catch (IOException e) {
            System.out.println("Error initializing storage. Creating empty house.");
            house = new House();
        }
    }

    public void saveToFile() {
        if (house == null) {
            house = new House();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(house);

        } catch (IOException e) {
            System.out.println("Error saving data to file.");
        }
    }

    /*
     * ========================= Room Operations =========================
     */

    public int addRoom(Room room) {
        int newId = ROOM_COUNTER.getAndIncrement();
        room.setRoomId(newId);
        house.addRoom(room);
        saveToFile();
        return newId;
    }

    public int removeRoom(int roomId) {
        Room room = findRoomById(roomId);

        if (room != null) {
            house.removeRoom(room);
            saveToFile();
            return roomId;
        }

        System.out.println("Room not found with ID: " + roomId);
        return -1;
    }

    public List<Room> getRooms() {
        return house.getRooms();
    }

    /*
     * ========================= Device Operations =========================
     */
    public int addDevice(int roomId, Device device) {

        Room room = findRoomById(roomId);
        if (room == null)
            return -1;

        if (!isDeviceCompatible(room, device)) {
            System.out.println(
                    "Device " + device.getClass().getSimpleName() + " is not compatible with " + room.getRoomType());
            return -1;
        }

        if (findDevice(roomId, device.getDeviceId()) != null) {
            System.out.println("Device ID already exists: " + device.getDeviceId());
            return -1;
        }

        room.addDevice(device);
        saveToFile();
        return device.getDeviceId();
    }

    public int removeDevice(int roomId, int deviceId) {
        Room room = findRoomById(roomId);
        if (room == null)
            return -1;

        for (Device d : room.getDevices()) {
            if (d.getDeviceId() == deviceId) {
                room.removeDevice(d);
                saveToFile();
                return deviceId;
            }
        }

        System.out.println("Device not found: " + deviceId);
        return -1;
    }

    public int turnOnDevice(int roomId, int deviceId) {
        Device device = findDevice(roomId, deviceId);
        if (device == null)
            return -1;

        device.turnOn();
        saveToFile();
        return deviceId;
    }

    public int turnOffDevice(int roomId, int deviceId) {
        Device device = findDevice(roomId, deviceId);
        if (device == null)
            return -1;

        device.turnOff();
        saveToFile();
        return deviceId;
    }

    public int checkDeviceStatus(int roomId, int deviceId) {
        Device device = findDevice(roomId, deviceId);
        if (device == null)
            return -1;

        return device.isOn() ? 1 : 0;
    }

    public String totalTimeTillLastStateChange(int roomId, int deviceId) {
        Device device = findDevice(roomId, deviceId);
        if (device == null)
            return null;

        String time = device.isOn() ? device.getTimeLastOn() : device.getTimeLastoff();

        if (time == null)
            return "00:00:00";

        try {
            LocalTime last = LocalTime.parse(time, TIME_FORMAT);
            Duration duration = Duration.between(last, LocalTime.now());

            if (duration.isNegative()) {
                return "00:00:00";
            }

            long seconds = duration.getSeconds();
            long hours = seconds / 3600;
            long minutes = (seconds % 3600) / 60;
            long secs = seconds % 60;

            return String.format("%02d:%02d:%02d", hours, minutes, secs);
        } catch (Exception e) {
            return "00:00:00";
        }
    }

    public void changeLightColor(int roomId, int deviceId, String color) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Light) {
            ((Light) d).changeColor(color);
            saveToFile();
        }
    }

    public void changeLightIntensity(int roomId, int deviceId, int intensity) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Light) {
            ((Light) d).changeIntensity(intensity);
            saveToFile();
        }
    }

    public void changeFanSpeed(int roomId, int deviceId, int speed) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Fan) {
            ((Fan) d).changeSpeed(speed);
            saveToFile();
        }
    }

    public void changeAcTemperature(int roomId, int deviceId, int temp) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Ac) {
            ((Ac) d).changeTemperature(temp);
            saveToFile();
        }
    }

    public void changeAcFanSpeed(int roomId, int deviceId, int speed) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Ac) {
            ((Ac) d).changeFanspeed(speed);
            saveToFile();
        }
    }

    public void changeAcMode(int roomId, int deviceId, String mode) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Ac) {
            ((Ac) d).changeMode(mode);
            saveToFile();
        }
    }

    public void changeTvChannel(int roomId, int deviceId, int channel) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Tv) {
            ((Tv) d).changeChannel(channel);
            saveToFile();
        }
    }

    public void changeTvVolume(int roomId, int deviceId, int volume) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Tv) {
            ((Tv) d).changeVolume(volume);
            saveToFile();
        }
    }

    public void changeTvInputSource(int roomId, int deviceId, String source) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Tv) {
            try {
                Tv.ipSource ip = Tv.ipSource.valueOf(source.toUpperCase());
                ((Tv) d).inputSource(ip);
                saveToFile();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid TV input source.");
            }
        }
    }

    public void changeShowerWaterTemp(int roomId, int deviceId, double temp) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Shower) {
            ((Shower) d).setCurrentwatertemp(temp);
            saveToFile();
        }
    }

    public void changeShowerFlowRate(int roomId, int deviceId, int rate) {
        Device d = findDevice(roomId, deviceId);
        if (d instanceof Shower) {
            ((Shower) d).setFlowrate(rate);
            saveToFile();
        }
    }

    /*
     * ========================= Helper Methods =========================
     */

    private boolean isDeviceCompatible(Room room, Device device) {
        switch (room.getRoomType()) {
            case "bedroom":
                return device instanceof BedRoomDevices;
            case "bathroom":
                return device instanceof BathRoomDevices;
            case "kitchen":
                return device instanceof KitchenDevices;
            case "hall":
                return device instanceof HallDevices;
            default:
                return false;
        }
    }

    public Device findDevice(int roomId, int deviceId) {
        Room room = findRoomById(roomId);
        if (room == null)
            return null;

        for (Device d : room.getDevices()) {
            if (d.getDeviceId() == deviceId) {
                return d;
            }
        }

        System.out.println("Device not found: " + deviceId);
        return null;
    }

    public Room findRoomById(int roomId) {
        for (Room r : house.getRooms()) {
            if (r.getRoomId() == roomId) {
                return r;
            }
        }
        System.out.println("Room not found with ID: " + roomId);
        return null;
    }
}
