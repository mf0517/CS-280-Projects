package assignments.sorting;
/**
 * 
 * 
 * Picking out the smallest element one-by-one
 * 
 */
public class SelectionSort extends SortingAlgorithm<Integer> {
    /**
     * 
     * sorting an array using Selection sorting.
     * 
     * 
     * post-condition: the array is in ascending order
     * 
     * @param array an array of integers 
     * 
     * 
     */
    public void sort(Integer[] array)
    {
        for(int k = 0; k < array.length-1 ;k++)
        {
            int smallestElem = k; // assumethe smallest element is at index k
            for( int j = k+1; j < array.length; j++)
            {
                
                if(array[j].compareTo(array[smallestElem]) < 0) //checks if the next element of array is smaller than the element of where k is
                {
                    smallestElem = j;
                }
            }
            check(array,k,smallestElem);
        }
    }

    /**
     * creating a method that swaps the smallest number to the left
     */

    private void check(Integer[] array, int i, int small)
    {
        Integer temp = array[small];
        array [small] = array[i];
        array[i] = temp;
        
        

    }
        public static void main(String[] args)
    {
        SortingAlgorithm.validate(new SelectionSort());
        System.out.println("selection sort has passed all tests");

        

        // fill an array with random numbers.

        int N = 10;
        Integer[] array = new Integer[N];

        for(int i = 0; i < array.length; i++)
        {
            array[i] = (int)(N*Math.random());
        }
        
  
        

        // measuring runtime.

        SortingAlgorithm<Integer> sorter = new SelectionSort();

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
