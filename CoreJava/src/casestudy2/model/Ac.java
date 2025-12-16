package casestudy2.model;

public class Ac extends Device implements BedRoomDevices, HallDevices {
    int temperature;
    int fanspeed;
    String mode;

    public Ac(int deviceId, int temperature, int fanspeed, String mode) {
        super(deviceId);
        this.temperature = temperature;
        this.fanspeed = fanspeed;
        this.mode = mode;
    }

    public int getTemperature() {
        return temperature;
    }

    public void changeTemperature(int newtemperature) {
        this.temperature = newtemperature;
    }

    public int getFanspeed() {
        return fanspeed;
    }

    public void changeFanspeed(int newfanspeed) {
        this.fanspeed = newfanspeed;
    }

    public String getMode() {
        return mode;
    }

    public void changeMode(String newmode) {
        this.mode = newmode;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntemperature :" + temperature + "\nfanspeed :" + fanspeed + "\n mode " + mode;
    }

}
