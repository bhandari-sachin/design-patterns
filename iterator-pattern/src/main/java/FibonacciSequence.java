import java.util.Iterator;

/**
 * Represents a Fibonacci sequence generator.
 * This class does NOT store sequence state.
 * It only creates new independent iterators.
 */
public class FibonacciSequence implements Sequence {

    private final int limit; // number of elements to generate

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}