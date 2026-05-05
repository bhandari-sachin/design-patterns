import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator that generates Fibonacci numbers on demand.
 *
 * DESIGN DECISION:
 * State is stored HERE (not in FibonacciSequence).
 * This ensures each iterator is independent.
 */
public class FibonacciIterator implements Iterator<Integer> {

    private int count = 0;
    private final int limit;

    private int prev = 0;
    private int curr = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int result;

        if (count == 0 || count == 1) {
            result = 1;
        } else {
            int next = prev + curr;
            prev = curr;
            curr = next;
            result = next;
        }

        // Initialize prev/curr properly after first two calls
        if (count == 0) {
            prev = 1;
        } else if (count == 1) {
            curr = 1;
        }

        count++;
        return result;
    }
}