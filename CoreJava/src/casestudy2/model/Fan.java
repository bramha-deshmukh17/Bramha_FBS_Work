package casestudy2.model;

public class Fan extends Device implements BedRoomDevices, HallDevices, KitchenDevices {

    int noOfBlades;
    int speed;

    public Fan(int deviceId, int noOfBlades, int speed) {
        super(deviceId);
        this.noOfBlades = noOfBlades;
        this.speed = speed;
    }

    public int getNoOfBlades() {
        return noOfBlades;
    }

    public int getSpeed() {
        return speed;
    }

    public void changeSpeed(int newspeed) {
        this.speed = newspeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nnoOfBlades :" + noOfBlades +
                "\nspeed :" + speed;
    }
}
