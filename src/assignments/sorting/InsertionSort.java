package assignments.sorting;

/**
 * An implementation of the Insertion Sort algorithm.
 * Insertion sort works by building a final sorted array one item at a time,
 * repeatedly taking the next element and inserting it into its correct position
 * among the previously sorted elements.
 * 
 * @param <T> the type of elements to be sorted, which must be Comparable
 */
public class InsertionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    
    /**
     * Sorts an array using the insertion sort technique.
     * 
     * Post-condition: the array is in ascending order.
     * 
     * @param array an array of comparable elements to be sorted
     */
    public void sort(T[] array) {
        // Iterate through each element starting from the second item
        for (int s = 1; s < array.length; s++) {
            int k = s;
            // Compare k with the value prior to it, swapping backwards until it's in place
            while (k > 0 && array[k].compareTo(array[k - 1]) < 0) {
                change(array, k, k - 1);
                k--;
            }
        }
    }

    /**
     * A private method that swaps two elements to ensure 
     * that the array order is adjusted correctly during sorting.
     * 
     * @param array the array to swap values within
     * @param i the first index to swap
     * @param l the second index to swap
     */
    private void change(T[] array, int i, int l) {
        T temp = array[i];
        array[i] = array[l];
        array[l] = temp;
    }

    /**
     * Runs validation tests and optional performance benchmarking for InsertionSort.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SortingAlgorithm.validate(new InsertionSort<>());
        System.out.println("Insertion sort has passed all tests.");

        // Fill an array with random numbers for testing.
        int N = 10;
        Integer[] array = new Integer[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (N * Math.random());
        }
        
        // Measuring runtime.
        SortingAlgorithm<Integer> sorter = new InsertionSort<>();
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