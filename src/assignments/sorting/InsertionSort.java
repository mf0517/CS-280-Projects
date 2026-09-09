package assignments.sorting;

//**
// Putting elements one-by-one into a guaranteed-sorted list
// 


public class InsertionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    /**
     * Sort an array using Insertion
     * 
     * 
     * post-condition: array is in ascending order
     * 
     * @param array is an array of numbers
     * 
     * 
     */
    public void sort(T[] array)
    {
        /**
         * creating the for loops
         * 
         */
        for(int s = 1; s < array.length; s++) 
        {
            int k = s;
            while(k > 0 &&  array[k].compareTo(array[k-1]) < 0) //compares k and the value prior to it to see if k is smaller than its previous.1
            {
                change(array, k, k-1);
                k--;
            }
        }
    }


        /**
         * creating a private method that changes around the order to ensure that the array is sorted correctly.
         * @param array the array to swap values
         * @param i the first index to swap
         * @param l the second index to swap
         */
    private void change(T[] array, int i, int l)
    {
        T temp = array[i];
        array[i] = array[l];
        array[l] = temp;
    }
        /**
         * Run validiation tests.
        * @param args command-line args
         */


    public static void main(String[] args)
    {
        SortingAlgorithm.validate(new InsertionSort<>());
        System.out.println("insertion sort has passed all tests");

        

        // fill an array with random numbers.

        int N = 10;
        Integer[] array = new Integer[N];

        for(int i = 0; i < array.length; i++)
        {
            array[i] = (int)(N*Math.random());
        }
        
  
        

        // measuring runtime.

        SortingAlgorithm<Integer> sorter = new InsertionSort<>();

       // long start = System.nanoTime();

        sorter.sort(array);
        /**
         * long end = System.nanoTime();
        double duration = (end - start) / (1e9);
        
        System.out.println("Array size: " + N);
        System.out.println("Total duration: " + duration);
        */


    }
}
