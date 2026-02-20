package weather.observer;

import weather.subject.Subject;

public class WindowBillboard implements Observer {
    private final String location;

    public WindowBillboard(String location, Subject station) {
        this.location = location;
        station.addObserver(this);
    }

    @Override
    public void update(int temperature) {
        System.out.println("Billboard [" + location + "]: It's now " + temperature + "°C");
    }
}
