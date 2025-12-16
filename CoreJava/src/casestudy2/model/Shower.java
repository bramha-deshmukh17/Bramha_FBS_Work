package casestudy2.model;

public class Shower extends Device implements BathRoomDevices {

    double currentwatertemp;
    int flowrate;

    public Shower(int deviceId, double currentwatertemp, int flowrate) {
        super(deviceId);
        this.currentwatertemp = currentwatertemp;
        this.flowrate = flowrate;
    }

    public double getCurrentwatertemp() {
        return currentwatertemp;
    }

    public void setCurrentwatertemp(double currentwatertemp) {
        this.currentwatertemp = currentwatertemp;
    }

    public int getFlowrate() {
        return flowrate;
    }

    public void setFlowrate(int flowrate) {
        this.flowrate = flowrate;
    }

    @Override
    public String toString() {
        return super.toString() + " \ncurrentwatertemp :" + currentwatertemp + "\nflowrate :" + flowrate;
    }

}
