package assignments.sorting;

public class QuickSort<T extends Comparable<T>> extends SortingAlgorithm<T>  {
    
    public void sort(T[] array) {
        if (array != null && array.length > 1) {
            quickSort(array, 0, array.length - 1);
        }
    }
    public void quickSort(T[] array, int low, int high)
    {
        if(low < high)
        {
            //getting the pivot
            int pi = partition(array,low,high);
            

            quickSort(array,low,pi-1);
            quickSort(array,pi+1,high);
        }
    }
    private int partition(T[] array, int low, int high)
    {
        T pivot = array[high];
        int i = low - 1;

        for(int j = low; j < high; j++)
        {
            if(array[j].compareTo(pivot) <= 0)
            {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i+1;
    }

    public static void main(String[] args) {
        SortingAlgorithm.validate(new QuickSort<>());
        System.out.println("Quick sort passes all tests");
    }
}