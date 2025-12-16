package casestudy2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class House implements Serializable {

    private List<Room> rooms;
    private double area;
    private double price;

    public House() {
        this.rooms = new ArrayList<>();
        this.area = 0.0;
        this.price = 0.0;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        area += room.getArea();
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
        area -= room.getArea();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
