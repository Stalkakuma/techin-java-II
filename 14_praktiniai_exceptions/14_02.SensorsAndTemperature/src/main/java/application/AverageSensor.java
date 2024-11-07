package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensorList;
    private List<Integer> readings;


    public AverageSensor() {
        sensorList = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensorList.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return sensorList.stream().allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensorList.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensorList.forEach(Sensor::setOff);
    }

    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public int read() {
        if (isOn()) {
            int reading = (int) sensorList.stream().mapToInt(Sensor::read).average().orElseThrow(IllegalStateException::new);
            readings.add(reading);
            return reading;
        }
        else throw new IllegalStateException();
    }
}
