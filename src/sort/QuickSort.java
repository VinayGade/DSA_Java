package sort;

public class QuickSort extends CommonUtility{

    public void quickSort(int[] array, int low, int high){
        if(low < high){
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot-1);     // left sub-array   (<pivot)
            quickSort(array, pivot+1, high);    // right sub-array   (>pivot)
        }
    }

    private int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low;
        int j = low;

        //  [low .. j-1] < pivot
        //  [j .. i-1] > pivot

        // [i .. j] -> yet to be traversed

        while(i <= high){
            if(array[i] <= pivot){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;    // index of pivot after partitioning
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] numbers ={100, 10, 90, 80, 30, 50 ,70, 40, 1};

        int high = numbers.length-1;
        quickSort.quickSort(numbers, 0, high);

        System.out.println("Quick Sort :");
        quickSort.display(numbers);
    }
}
