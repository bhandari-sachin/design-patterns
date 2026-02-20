package weather.observer;

import weather.subject.Subject;

public class SmartHeaterController implements Observer {
    private final String room;

    public SmartHeaterController(String room, Subject station) {
        this.room = room;
        station.addObserver(this);
    }

    @Override
    public void update(int temperature) {
        String action = (temperature < 18) ? "Turning HEAT ON" : "Heat OFF";
        System.out.println("SmartHeater (" + room + "): Temp=" + temperature + "°C -> " + action);
    }
}
