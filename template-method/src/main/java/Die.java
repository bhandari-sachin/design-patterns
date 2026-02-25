import java.util.Random;

public class Die {
    private final Random rng = new Random();

    // returns 1..6
    public int roll() {
        return rng.nextInt(6) + 1;
    }
}