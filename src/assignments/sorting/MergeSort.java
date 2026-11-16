package assignments.sorting;
 
import java.util.Vector;
 
public class MergeSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
 
    public void sort(T[] array) {
        // If there are less than 2 elements it will just return
        if (array == null || array.length < 2) {
            return;
        }
 
        // Copy the array into a vector, sort it, then copy the result back.
        Vector<T> list = new Vector<>();
        for (T item : array) {
            list.add(item);
        }
 
        mergeSort(list);
 
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }
 
    private void mergeSort(Vector<T> list) {
        if (list.size() < 2) {
            return;
        }
 
        // Finding the midpoint and splitting the vector into 2.
        int mid = list.size() / 2;
        Vector<T> left = new Vector<>(list.subList(0, mid));
        Vector<T> right = new Vector<>(list.subList(mid, list.size()));
 
        mergeSort(left);
        mergeSort(right);
 
        merge(list, left, right);
    }
 
    private void merge(Vector<T> list, Vector<T> left, Vector<T> right) {
        int i = 0;
        int j = 0;
        int k = 0;
 
        while (i < left.size() && j < right.size()) {
            // Using compareTo for generic object comparison.
            // <= keeps equal items in their original order (stable).
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
 
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
 
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
 
    public static void main(String[] args) {
        SortingAlgorithm.validate(new MergeSort<Integer>());
        System.out.println("Merge sort passes all tests");
    }
}