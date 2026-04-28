import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    // The adaptee instance
    private final Calendar calendar;

    public CalendarToNewDateAdapter() {
        // Initialize with the current date and time
        this.calendar = Calendar.getInstance();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        // Translate client's 1-indexed month (1-12) to Calendar's 0-indexed month (0-11)
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        // Translate Calendar's 0-indexed month back to standard 1-12 format for the client
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        // Calendar's add method safely handles month/year rollovers
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}