package weather.subject;

import weather.config.StationConfig;
import weather.observer.Observer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation implements Subject, Runnable {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final Random random = new Random();

    private volatile int temperature;
    private volatile boolean running = true;

    public WeatherStation() {
        // initial random temperature within bounds
        this.temperature = StationConfig.MIN_TEMP
                + random.nextInt(StationConfig.MAX_TEMP - StationConfig.MIN_TEMP + 1);
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void addObserver(Observer o) {
        if (o != null) observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("[WeatherStation] Starting at " + temperature + "°C");
        notifyObservers(); //  initial notification

        while (running) {
            try {
                int sleepSeconds = StationConfig.MIN_SLEEP_SECONDS
                        + random.nextInt(StationConfig.MAX_SLEEP_SECONDS - StationConfig.MIN_SLEEP_SECONDS + 1);
                Thread.sleep(sleepSeconds * 1000L);

                int delta = random.nextBoolean() ? 1 : -1;
                int next = temperature + delta;

                if (next < StationConfig.MIN_TEMP) next = StationConfig.MIN_TEMP;
                if (next > StationConfig.MAX_TEMP) next = StationConfig.MAX_TEMP;

                temperature = next;
                System.out.println("[WeatherStation] Temperature changed to " + temperature + "°C");
                notifyObservers();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }

        System.out.println("[WeatherStation] Stopped.");
    }
}
