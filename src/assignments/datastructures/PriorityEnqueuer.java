package assignments.datastructures;
import adt.PriorityQueue;


public class PriorityEnqueuer<T extends Comparable<T>> implements PriorityQueue<T> {
    private Vector<T> vector;

    public PriorityEnqueuer()
    {
        this.vector = new Vector<>();

    }
    public T dequeue()
    {
        int smallest = 0;

        for(int i = 1; i < vector.length(); i++)
        {
            if(vector.at(i).compareTo(vector.at(smallest)) < 0)
            {
                smallest = i;
            }
        }
        return vector.delete(smallest);


    }
    public void enqueue(T value)
    {
        vector.push(value);
    }

    public boolean isEmpty()
    {
        return vector.isEmpty();
    }

    public T peek()
    {
       int index = 0;
       //Find the index with the smallest value
       for(int i = 1; i < vector.length(); i++)
       {
        if(vector.at(i).compareTo(vector.at(index)) < 0)
        {
            index = i;
        }
       }
       return vector.at(index);
    }

    public static void main(String[] args) {
        PriorityQueue.validate(new PriorityEnqueuer<>());
        System.out.println("Priority Enqueue passes all tests");
    }
    
}
