package weather.app;

import weather.observer.PhoneDisplay;
import weather.observer.SmartHeaterController;
import weather.observer.WindowBillboard;
import weather.subject.WeatherStation;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation();
        Thread t = new Thread(station, "WeatherStation-Thread");
        t.start();

        PhoneDisplay phone = new PhoneDisplay("Alex", station);
        WindowBillboard billboard = new WindowBillboard("Downtown", station);
        SmartHeaterController heater = new SmartHeaterController("Living Room", station);

        Thread.sleep(12_000L);

        System.out.println("\n=== Removing Billboard observer ===\n");
        station.removeObserver(billboard);

        Thread.sleep(12_000L);

        System.out.println("\n=== Stopping simulation ===\n");
        station.stop();
        t.join();
    }
}
