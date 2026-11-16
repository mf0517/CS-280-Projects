package assignments.datastructures;

import adt.Set;
import java.util.Iterator;

/**
 * 
 * @param <T> the type of elements maintained by this set, which must be comparable
 */
public class VectorSet<T extends Comparable<T>> implements Set<T> {
    
    /** The underlying vector buffer used to store set elements. */
    Vector<T> array = new Vector<>();

    /**
     * Adds the specified element to the set if it is not already present.
     * 
     * @param value the element to add to the set
     * @return true if the element was successfully added, false if it was already present
     */
    public boolean add(T value) {
        if (array.contains(value)) {
            return false;
        }
        array.push(value);
        return true;
    }

    /**
     * Returns an iterator over the elements in this set.
     * 
     */
    public Iterator<T> iterator() {
        return this.array.iterator();
    }

    /**
     * Checks if the set contains a given value.
     * 
     * @param value the value to look for
     * @return true if the set contains the specified value, false otherwise
     */
    public boolean contains(T value) {
        return array.contains(value);
    }

    /**
     * Returns the number of elements currently in the set.
     * 
     * @return the size of the set
     */
    public int length() {
        return array.length();
    }

    /**
     * Removes the specified value from the set if it is present.
     * 
     * @param value the value to remove
     * @return true if the set contained the specified element and removed it, false otherwise
     */
    public boolean remove(T value) {
        if (array.contains(value)) {
            array.delete(array.find(value));
            return true;
        }
        return false;
    }

    /**
     * Runs automated validation tests for the VectorSet implementation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Set.validate(new VectorSet<Integer>());
        System.out.println("Vector Set passes all tests");
    }
}