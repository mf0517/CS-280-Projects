package assignments.sorting;
 
import java.util.Iterator;
 
import assignments.datastructures.BinarySearchTree;
 
public class TreeSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
 
    public void sort(T[] array) {
        // If there are less than 2 elements it will just return
        if (array == null || array.length < 2) {
            return;
        }
 
        // Insert every element into a binary search tree.
        BinarySearchTree<T> tree = new BinarySearchTree<>();
        for (int i = 0; i < array.length; i++) {
            tree.add(array[i]);
        }
 
        // An in-order traversal visits the elements in sorted order.
        Iterator<T> iterator = tree.inorder();
        int i = 0;
        while (iterator.hasNext()) {
            array[i++] = iterator.next();
        }
    }
 
    public static void main(String[] args) {
        SortingAlgorithm.validate(new TreeSort<Integer>());
        System.out.println("Tree sort passes all tests");
    }
}