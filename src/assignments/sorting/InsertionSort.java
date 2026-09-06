package assignments.sorting;

//**
// Putting elements one-by-one into a guaranteed-sorted list
// 


public class InsertionSort extends SortingAlgorithm<Integer> {
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
    public void sort(Integer[] array)
    {
        /**
         * creating the for loops
         * 
         */
        for(int s = 0; s < array.length-1; s++) 
        {
            int special = s;
            for(int k = s+1; k < array.length; k++) // we are saying the arrays first element "s" is correctly sorted
            {
                while(array[k].compareTo(array[special]) < 0)
                {
                    change(array,k,special);
                }
            }
        }
    }


        /**
         * creating a private method that changes around the order to ensure that the array is sorted correctly.
         */
        private void change(Integer[] array, int i, int l)
        {
            Integer temp = array[i];
            array[i] = array[l];
            array[l] = temp;
        }
        /**
         * making my main for insertion sort.
         */

            public static void main(String[] args)
    {
        SortingAlgorithm.validate(new InsertionSort());
        System.out.println("insertion sort has passed all tests");

        

        // fill an array with random numbers.

        int N = 10;
        Integer[] array = new Integer[N];

        for(int i = 0; i < array.length; i++)
        {
            array[i] = (int)(N*Math.random());
        }
        
  
        

        // measuring runtime.

        SortingAlgorithm<Integer> sorter = new InsertionSort();

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
