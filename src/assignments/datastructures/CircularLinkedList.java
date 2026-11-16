package assignments.datastructures;

import java.util.Iterator;
import adt.List;
import adt.Queue;

/**
 * A circular linked list implementation of a List and Stack.
 * The tail node points back to the head node instead of null.
 */
public class CircularLinkedList<T> implements List<T>,Queue<T>, Iterable<T>{
    private Node tail;
    private int size;

    // Helper method to get the head of the list from the tail pointer
    private Node getHead() {
        if (tail == null) {
            return null;
        }
        return tail.link;
    }

    /**
     * Initializes an empty circular linked list.
     */
    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    /**
     * Checks if the list is empty.
     */
    public boolean isEmpty() {
        return tail == null;
    }

    /**
     * This is implementing my queue methods
     */
    public void enqueue(T value)
    {
        this.insert(size, value);
    }

    public T dequeue()
    {
        return this.delete(0);
    }

    public T peek()
    {
        return getHead().data;
    }

    /**
     * Returns the current number of elements in the list.
     */
    public int length() {
        return size;
    }
    
    /**
     * Retrieves the element at the specified index.
     */
    public T at(int index) {
        assert 0 <= index && index < size;
        Node curr = getHead();
        for (int i = 0; i < index; i++) {
            curr = curr.link;
        }
        return curr.data;
    }
    
    /**
     * Replaces the element at the specified index with a new value.
     */
    public void set(int index, T value) {
        assert 0 <= index && index < size;
        Node curr = getHead();
        for (int i = 0; i < index; i++) {
            curr = curr.link;
        }
        curr.data = value;
    }
    
    /**
     * Checks if the list contains the given value.
     */
    public boolean contains(T value) {
        if (isEmpty()) {
            return false;
        }
        Node curr = getHead();
        for (int i = 0; i < size; i++) {
            if (curr.data == value || (value != null && value.equals(curr.data))) {
                return true;
            }
            curr = curr.link;
        }
        return false;
    }
    
    /**
     * Inserts a value at the specified index, maintaining circular linkage.
     */
    public void insert(int index, T value) {
        assert 0 <= index && index <= size;
        
        if (isEmpty()) {
            Node n = new Node(value, null);
            n.link = n;
            tail = n;
        } else if (index == 0) {
            Node n = new Node(value, tail.link);
            tail.link = n;
        } else if (index == size) {
            Node n = new Node(value, tail.link);
            tail.link = n;
            tail = n;
        } else {
            Node curr = getHead();
            for (int i = 0; i < index - 1; i++) {
                curr = curr.link;
            }
            Node n = new Node(value, curr.link);
            curr.link = n;
        }
        size++;
    }
    
    /**
     * Removes and returns the element at the specified index.
     */
    public T delete(int index) {
        assert 0 <= index && index < size;
        T removedVal;
        
        if (size == 1) {
            removedVal = tail.data;
            tail = null;
        } else if (index == 0) {
            Node head = tail.link;
            removedVal = head.data;
            tail.link = head.link;
        } else {
            Node curr = getHead();
            for (int i = 0; i < index - 1; i++) {
                curr = curr.link;
            }
            Node target = curr.link;
            removedVal = target.data;
            curr.link = target.link;
            
            if (target == tail) {
                tail = curr;
            }
        }
        size--;
        return removedVal;
    }
    

    /**
     * Returns an iterator to traverse the circular list safely.
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node curr = getHead();
            private int count = 0;

            public boolean hasNext() {
                return count < size;
            }

            public T next() {
                if (!hasNext()) {
                    return null;
                }
                T val = curr.data;
                curr = curr.link;
                count++;
                return val;
            }
        };
    }

    // Node inner class
    private class Node {
        T data;
        Node link;

        Node(T data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    /**
     * Main method for testing list functionality.
     */
    public static void main(String[] args) {
        List.validate(new CircularLinkedList<>());        
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 5; i++) {
            Iterator<Integer> iter = list.iterator();
            for (int j = 5; j > 0; j--) {
                assert !iter.hasNext();
            }
        }
        System.out.println("CircularLinkedList passes all tests.");
    }
}