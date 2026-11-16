package assignments.sorting;

/**
 * A utility class providing HeapSort for Comparable elements.
 * 
 * @param <T> the type of elements to sort, which must be Comparable
 */
public class HeapSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

    /**
     * Sorts an array of elements in ascending order using HeapSort.
     * 
     * @param array the array of elements to sort
     */
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;

        // Step 1: Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum element) to the end
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    /**
     * Helper method to maintain the max-heap property for a subtree rooted at index i.
     * 
     * @param array the array representing the heap
     * @param heapSize the current size of the heap
     * @param i the root index of the subtree
     */
    private void heapify(T[] array, int heapSize, int i) {
        int largest = i;          // Initialize largest as root
        int left = 2 * i + 1;     // Left child index
        int right = 2 * i + 2;    // Right child index

        // If left child is larger than root
        if (left < heapSize && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < heapSize && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying recursively
        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, heapSize, largest);
        }
    }

    public static void main(String[] args) 
    {
        SortingAlgorithm.validate(new HeapSort<>());    
        System.out.println("\nHeapSort passes all tests.");
    }
}