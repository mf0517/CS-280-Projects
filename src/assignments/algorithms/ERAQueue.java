package assignments.algorithms;

import assignments.datastructures.PriorityDequeue;
import assignments.datastructures.PriorityEnqueuer;
import assignments.datastructures.MinHeap;
import java.util.Random;

public class ERAQueue<T extends Comparable<T>> extends MinHeap<T> 
{
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("N, Runtime(ms)");


        for( int i = 10000; i < 100000; i += 10000)
        {
            //PriorityDequeue<Integer> queue = new PriorityDequeue<>();
            MinHeap<Integer> queue = new MinHeap<>();
            //PriorityEnqueuer<Integer> queue = new PriorityEnqueuer<>();
            for(int l = 0; l < i; l++)
            {
                queue.enqueue(random.nextInt(i) + 1);
            }

            long start = System.nanoTime();

            for(int m = 0; m < 1; m++)
            {
                queue.dequeue();
            }

            long end = System.nanoTime();

            long total = (end - start) / 100;

            System.out.println(i + "," + total);

        }
    }    
}
