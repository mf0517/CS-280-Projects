package assignments.datastructures;
import adt.PriorityQueue;
import java.util.Vector;

public class PriorityDequeue<T extends Comparable<T>> implements PriorityQueue<T> {
    private Vector<T> items;
 
    public PriorityDequeue() {
        this.items = new Vector<>();
    }
 
    public T dequeue() {
        if (this.items.isEmpty()) {
            return null;
        }
        return this.items.remove(this.items.size() - 1);
    }
 
    public void enqueue(T value) {
        // Walk toward the front past every item that is <= value,
        // then insert at that spot. Vector grows on its own.
        int spot = this.items.size();
        while (spot > 0 && this.items.get(spot - 1).compareTo(value) <= 0) {
            spot--;
        }
        this.items.add(spot, value);
    }
 
    public boolean isEmpty() {
        return this.items.isEmpty();
    }
 
    public T peek() {
        if (this.items.isEmpty()) {
            return null;
        }
        return this.items.get(this.items.size() - 1);
    }
 
    public static void main(String[] args) {
        PriorityQueue.validate(new PriorityDequeue<>());
        System.out.println("Priority Dequeuer passes all tests");
    }
}