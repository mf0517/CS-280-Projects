package assignments.algorithms;
import assignments.sorting.InsertionSort;
public class ERADemo {
    private static Integer[] randomArray(int n)
    {
        Integer[] array = new Integer[n];
        for ( int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random() * n);
        }
        return array;
    }
    public static void main(String[] args)
    {
        InsertionSort<Integer> sorter = new InsertionSort<>();
        for(int n = 10; n < 100; n+= 10)
        {
            Integer[] array = randomArray(n);
            long start = System.nanoTime();
            sorter.sort(array);
            long end = System.nanoTime();
            double duration = (end - start) / 1e9;
            System.out.println(n + "\t" + duration);
        }

    }
}
