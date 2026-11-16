package assignments.datastructures;

import java.util.Vector;

import adt.PriorityQueue;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T>
{
    private Vector<T> items;

    public MinHeap()
    {
        this.items = new Vector<>();
    }

    public T dequeue()
    {
        if(this.items.isEmpty())
        {
            return null;
        }
        T result = this.items.get(0);
        T last = this.items.remove(this.items.size() - 1);

        if(!this.items.isEmpty())
        {
            this.items.set(0,last);
            int n = 0;

            while(2 * n + 1 < this.items.size())
            {
                int child = n * 2 + 1;
                if(child + 1 < this.items.size() && this.items.get(child + 1).compareTo(this.items.get(child)) < 0)
                    {
                        child += 1;
                    }
                    if(this.items.get(child).compareTo(this.items.get(n)) < 0)
                    {
                        T temp = this.items.get(n);
                        this.items.set(n, this.items.get(child));
                        this.items.set(child, temp);
                        n = child;

                    }
                    else
                    {
                        break;
                    }
            }
        }
        return result;
    }

    public void enqueue(T value)
    {
        this.items.add(value);
        int i = this.items.size() - 1;

        while(i > 0)
        {
            int parent = (i - 1) / 2;
            if(this.items.get(i).compareTo(this.items.get(parent)) < 0)
            {
                T temp = this.items.get(i);
                this.items.set(i , this.items.get(parent));
                this.items.set(parent, temp);
                i = parent;

            }
            else
            {
                break;
            }
        }
    }




    public boolean isEmpty()
    {
        return this.items.isEmpty();
    }

    public T peek()
    {
        if(this.items.isEmpty())
        {
            return null;
        }
        return this.items.get(0);
    }



    public static void main(String[] args) {
        PriorityQueue.validate(new MinHeap<>());
        System.out.println("Min Heap passes all tests");
    }
}

