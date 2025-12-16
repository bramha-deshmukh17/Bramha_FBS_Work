package casestudy2.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Device implements Serializable {

    int deviceId;
    boolean isOn;
    String timeLastOn;
    String timeLastoff;

    public Device(int deviceId) {
        this.deviceId = deviceId;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        this.setTimeLastOn(LocalTime.now());
    }

    public void turnOff() {
        this.isOn = false;
        this.setTimeLastoff(LocalTime.now());
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public String getTimeLastOn() {
        return timeLastOn;
    }

    public void setTimeLastOn(LocalTime timeLastOn) {
        this.timeLastOn = timeLastOn.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getTimeLastoff() {
        return timeLastoff;
    }

    public void setTimeLastoff(LocalTime timeLastoff) {
        this.timeLastoff = timeLastoff.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String toString() {

        return "Device Id is :" + this.deviceId
                + "\nDevice On or Off are " + this.isOn
                + "\nDevice Last Time On " + this.timeLastOn
                + "\nDevice Last Time Off " + this.timeLastoff;
    }
}
