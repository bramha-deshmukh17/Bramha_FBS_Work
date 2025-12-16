package casestudy2.model;

public class Tv extends Device implements BedRoomDevices, KitchenDevices, HallDevices {
    int currentChannel;
    int volume;
    String deviceName;
    ipSource inputSource;

    public enum ipSource {
        HDMI1, HDMI2, AV, USB
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public ipSource getInputSource() {
        return inputSource;
    }

    public void setInputSource(ipSource inputSource) {
        this.inputSource = inputSource;
    }

    public Tv(int deviceId, int currentChannel, int volume, String deviceName, ipSource inputSource) {
        super(deviceId);
        this.currentChannel = currentChannel;
        this.volume = volume;
        this.deviceName = deviceName;
        this.inputSource = inputSource;
    }

    public void changeVolume(int v) {
        // if(volume>=0 && volume<=100) {
        // if((volume+v)<=100 && (volume+v)>=0)volume+=v;
        // }
        volume = Math.max(0, Math.min(100, volume + v));
    }

    public void changeChannel(int ch) {
        if (ch >= 1 && ch <= 800) {
            currentChannel = ch;
        }

    }

    public void inputSource(ipSource ip) {

        inputSource = ip;

    }

}
