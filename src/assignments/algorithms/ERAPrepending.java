package assignments.algorithms;
import assignments.datastructures.LinkedList;
import assignments.datastructures.CircularLinkedList;
import assignments.datastructures.Vector;
import java.util.Random;


public class ERAPrepending<T extends Comparable<T>> extends CircularLinkedList<T> {
    public static void main(String[] args)
    {
        

        System.out.println("N, T(ns)");

        for(int i = 10000; i <= 100000;  i += 10000)
        {
            CircularLinkedList<Integer> vec = new CircularLinkedList<>();

            for(int l = 0; l < i; l++)
            {
                vec.insert(0,0);
            }

            long start = System.nanoTime();

            vec.insert(0,0);

            long end = System.nanoTime();

            System.out.println(i + ", " + (end - start));
        }



    }

}
