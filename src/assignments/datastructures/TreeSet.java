package assignments.datastructures;
import adt.Set;
import java.util.Iterator;
/**
A set that stores unique values in a binary search tree.

<p>Values are compared using their natural ordering. Adding
a value already in the set does nothing. Iterating visits
values in sorted order. Null values are not supported.</p>

<p>Adding, removing, and searching take O(h) time, where h
is the tree's height. An unbalanced tree may have height O(n).</p>

@param <T> the type of value, which must be comparable
*/
public class TreeSet<T extends Comparable<T>> implements Set<T>{
// The binary search tree stores our values.
private final BinarySearchTree<T> tree;
/**
Creates an empty set.
*/
public TreeSet() {
tree = new BinarySearchTree<>();
}
/**
Adds a value if it is not already in the set.

@param value the value to add
@return true if added, false if already present
*/
public boolean add(T value) {
if(this.contains(value))
{
    return false;
}
tree.add(value);
return true;
}
/**
Removes a value from the set.

@param value the value to remove
@return true if removed, false if not found
*/
public boolean remove(T value) {
return tree.remove(value);
}
/**
Checks if the set contains a value.

@param value the value to find
@return true if found, false otherwise
*/
public boolean contains(T value) {
return tree.contains(value);
}
/**
Returns the number of values in the set.

@return the number of unique values
*/
public int length() {
return tree.length();
}
/**
Returns an iterator over the values in sorted order.

@return an iterator over a snapshot of the values
*/
public Iterator<T> iterator() {
return tree.iterator();
}
//Tests the TreeSet class using assertions.

//@param args command-line arguments (not used)

public static void main(String[] args){
// Run the instructor's Set interface validation.
Set.validate(new TreeSet<Integer>());
System.out.println("TreeSet passes all tests.");
}
}