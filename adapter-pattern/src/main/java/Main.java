import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        NewDateInterface myDate = new CalendarToNewDateAdapter();

        myDate.setYear(2024);
        myDate.setMonth(2);
        myDate.setDay(26);

        logger.info("--- Calendar Adapter Test ---");

        logger.info("Initial Date: {}-{}-{}",
                myDate.getYear(),
                myDate.getMonth(),
                myDate.getDay());

        int daysToAdvance = 5;

        logger.info("Advancing by {} days...", daysToAdvance);

        myDate.advanceDays(daysToAdvance);

        logger.info("New Date: {}-{}-{}",
                myDate.getYear(),
                myDate.getMonth(),
                myDate.getDay());
    }
}