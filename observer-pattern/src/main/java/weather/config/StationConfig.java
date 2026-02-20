package weather.config;

public final class StationConfig {
    private StationConfig() {}

    public static final int MIN_TEMP = -10;
    public static final int MAX_TEMP = 35;

    //  ±1 degree
    public static final int MIN_SLEEP_SECONDS = 1;
    public static final int MAX_SLEEP_SECONDS = 5;
}
