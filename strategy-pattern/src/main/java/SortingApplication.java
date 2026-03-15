import context.SortContext;
import strategy.BubbleSortStrategy;
import strategy.MergeSortStrategy;
import strategy.QuickSortStrategy;
import strategy.SortStrategy;

import java.util.Random;

public class SortingApplication {

    public static void main(String[] args) {

        int smallSize = 30;
        int largeSize = 100000;

        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        SortStrategy bubble = new BubbleSortStrategy();
        SortStrategy quick = new QuickSortStrategy();
        SortStrategy merge = new MergeSortStrategy();

        System.out.println("=== SMALL DATASET (" + smallSize + ") ===");

        testStrategy(bubble, smallArray.clone(), "Bubble Sort");
        testStrategy(quick, smallArray.clone(), "Quick Sort");
        testStrategy(merge, smallArray.clone(), "Merge Sort");

        System.out.println("\n=== LARGE DATASET (" + largeSize + ") ===");

        testStrategy(bubble, largeArray.clone(), "Bubble Sort");
        testStrategy(quick, largeArray.clone(), "Quick Sort");
        testStrategy(merge, largeArray.clone(), "Merge Sort");
    }

    private static int[] generateRandomArray(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        return array;
    }

    private static void testStrategy(SortStrategy strategy, int[] data, String name) {

        SortContext context = new SortContext();
        context.setStrategy(strategy);

        long start = System.nanoTime();

        context.executeSort(data);

        long end = System.nanoTime();

        long duration = end - start;

        System.out.println(name + " took " + duration / 1_000_000.0 + " ms");
    }
}