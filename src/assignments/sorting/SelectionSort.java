package assignments.sorting;

/**
 * Picking out the smallest element one-by-one.
 */
public class SelectionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    
    /**
     * Sorting an array using Selection sorting.
     * 
     * post-condition: the array is in ascending order
     * 
     * @param array an array of comparable elements
     */
    public void sort(T[] array) {
        for (int k = 0; k < array.length - 1; k++) {
            int smallestElem = k; // assume the smallest element is at index k
            for (int j = k + 1; j < array.length; j++) {
                if (array[j].compareTo(array[smallestElem]) < 0) { // checks if the next element is smaller
                    smallestElem = j;
                }
            }
            check(array, k, smallestElem);
        }
    }

    /**
     * A private method that swaps values to ensure the array is sorted correctly.
     * 
     * @param array the array to swap values
     * @param i the first index to swap
     * @param small the second index to swap
     */
    private void check(T[] array, int i, int small) {
        T temp = array[small];
        array[small] = array[i];
        array[i] = temp;
    }

    /**
     * Run validation tests and optional timing benchmarks.
     * @param args command-line args
     */
    public static void main(String[] args) {
        SortingAlgorithm.validate(new SelectionSort<>());
        System.out.println("selection sort has passed all tests");

        // Fill an array with random numbers.
        int N = 10;
        Integer[] array = new Integer[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (N * Math.random());
        }

        // Measuring runtime.
        SortingAlgorithm<Integer> sorter = new SelectionSort<>();
        sorter.sort(array);

        /*
        long start = System.nanoTime();
        sorter.sort(array);
        long end = System.nanoTime();
        double duration = (end - start) / (1e9);

        System.out.println("Array size: " + N);
        System.out.println("Total duration: " + duration);
        */
    }
}