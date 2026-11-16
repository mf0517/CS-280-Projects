package assignments.sorting;
/**
 * 
 * BucketSort
 * prepare an array of "buckets" that maintains a runtime complexity of O(N)
 * Put each item in its bucket, maintains a runtime of O(N)
 * Take each item out of the bucket, maintains a runtime complexity of O(M+N)
 */
public class BucketSort extends SortingAlgorithm<Integer> {

    public BucketSort(){}

    public void sort(Integer[] array)
    {
        /**
         * Sorts the array using bucketsort
         * 
         * @param array the array to be sorted
         */
        int minimumIndex = array[0];
        int maximumIndex = array[0];

        //finding minimum and maximum values in the array
        for(int i = 1; i <array.length; i++)
        {
            if(array[i] < minimumIndex)
            {
                minimumIndex = array[i];
            }
            if(array[i] > maximumIndex)
            {
                maximumIndex = array[i];
            }
        }
        //how many buckets are needed
        int totalBuckets = maximumIndex - minimumIndex + 1;

        //initializing the array of buckets
        int[] bucket = new int[totalBuckets];
        

        //Count whenever a value comes up.

        for(int i = 0; i < array.length; i++)
        {
            int bIndex = array[i] - minimumIndex;
            bucket[bIndex]++;
        }


        int arrayIndex = 0;

        //Visit every bucket from smallest to biggest

        for(int bIndex = 0; bIndex < totalBuckets; bIndex++)
        {
            //putting elemenets back into the array

            while(bucket[bIndex] > 0)
            {
                array[arrayIndex] = bIndex + minimumIndex;
                arrayIndex++;
                bucket[bIndex]--;
            }
        }




    }



    /**
     * Run validation tests
     * @param args command-line args
     */
    public static void main(String[] args) {
        SortingAlgorithm.validate(new BucketSort());
        System.out.println("Bucket Sort has passed all tests");
    }
    
}
