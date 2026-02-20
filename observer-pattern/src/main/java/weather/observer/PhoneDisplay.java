package weather.observer;

import weather.subject.Subject;

public class PhoneDisplay implements Observer {
    private final String owner;

    public PhoneDisplay(String owner, Subject station) {
        this.owner = owner;
        station.addObserver(this); // self-registration
    }

    @Override
    public void update(int temperature) {
        System.out.println("PhoneDisplay (" + owner + "): " + temperature + "°C");
    }
}
