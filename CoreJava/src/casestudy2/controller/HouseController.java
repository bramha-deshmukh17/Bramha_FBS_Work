package casestudy2.controller;

import java.util.List;

import casestudy2.model.Device;
import casestudy2.model.Room;

public class HouseController {

    HouseDao dao;

    public HouseController(HouseDao dao) {
        this.dao = dao;
    }

    public int addRoom(Room room) {
        return dao.addRoom(room);
    }

    public int removeRoom(int roomId) {
        return dao.removeRoom(roomId);
    }

    public List<Room> getRooms() {
        return dao.getRooms();
    }

    public int addDevice(int roomId, Device device) {
        return dao.addDevice(roomId, device);
    }

    public int removeDevice(int roomId, int deviceId) {
        return dao.removeDevice(roomId, deviceId);
    }

    public int turnOnDevice(int roomId, int deviceId) {
        return dao.turnOnDevice(roomId, deviceId);
    }

    public int turnOffDevice(int roomId, int deviceId) {
        return dao.turnOffDevice(roomId, deviceId);
    }

    public int checkDeviceStatus(int roomId, int deviceId) {
        return dao.checkDeviceStatus(roomId, deviceId);
    }

    public long totalTimeTillLastStateChange(int roomId, int deviceId) {
        return dao.totalTimeTillLastStateChange(roomId, deviceId);
    }

    public Device findDevice(int roomId, int deviceId) {
        return dao.findDevice(roomId, deviceId);
    }

    // --- Methods for Operating Devices ---

    public void changeLightColor(int roomId, int deviceId, String color) {
        dao.changeLightColor(roomId, deviceId, color);
    }

    public void changeLightIntensity(int roomId, int deviceId, int intensity) {
        dao.changeLightIntensity(roomId, deviceId, intensity);
    }

    public void changeFanSpeed(int roomId, int deviceId, int speed) {
        dao.changeFanSpeed(roomId, deviceId, speed);
    }

    public void changeAcTemperature(int roomId, int deviceId, int temp) {
        dao.changeAcTemperature(roomId, deviceId, temp);
    }

    public void changeAcFanSpeed(int roomId, int deviceId, int speed) {
        dao.changeAcFanSpeed(roomId, deviceId, speed);
    }

    public void changeAcMode(int roomId, int deviceId, String mode) {
        dao.changeAcMode(roomId, deviceId, mode);
    }

    public void changeTvChannel(int roomId, int deviceId, int channel) {
        dao.changeTvChannel(roomId, deviceId, channel);
    }

    public void changeTvVolume(int roomId, int deviceId, int volume) {
        dao.changeTvVolume(roomId, deviceId, volume);
    }

    public void changeTvInputSource(int roomId, int deviceId, String source) {
        dao.changeTvInputSource(roomId, deviceId, source);
    }

    public void changeShowerWaterTemp(int roomId, int deviceId, double temp) {
        dao.changeShowerWaterTemp(roomId, deviceId, temp);
    }

    public void changeShowerFlowRate(int roomId, int deviceId, int rate) {
        dao.changeShowerFlowRate(roomId, deviceId, rate);
    }
}