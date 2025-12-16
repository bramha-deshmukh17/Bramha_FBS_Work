package casestudy2.model;

public class Light extends Device implements BedRoomDevices, HallDevices, BathRoomDevices, KitchenDevices {

    String color;
    int intensity;

    public Light(int deviceId, String color, int intensity) {
        super(deviceId);
        this.color = color;
        this.intensity = intensity;
    }

    public String getColor() {
        return color;
    }

    public void changeColor(String newcolor) {
        this.color = newcolor;
    }

    public int getIntensity() {
        return intensity;
    }

    public void changeIntensity(int newintensity) {
        this.intensity = newintensity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ncolor :" + color +
                "\nintensity :" + intensity;
    }
}
