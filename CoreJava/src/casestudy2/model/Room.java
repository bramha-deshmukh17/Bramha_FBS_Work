package casestudy2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private static final List<String> ALLOWED_TYPES = List.of("bedroom", "bathroom", "kitchen", "hall");

    private int roomId;
    private double area;
    private String roomType;
    private List<Device> devices;

    public Room(double area, String roomType) {
        // Validate type
        if (!ALLOWED_TYPES.contains(roomType.trim().toLowerCase())) {
            throw new IllegalArgumentException("Invalid room type. Allowed: Bedroom, Bathroom, Kitchen, Hall.");
        }
        this.area = area;
        this.roomType = roomType.toLowerCase();
        this.devices = new ArrayList<>();
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    public double getArea() {
        return area;
    }

    public String getRoomType() {
        return roomType;
    }

    public List<Device> getDevices() {
        return devices;
    }
}
