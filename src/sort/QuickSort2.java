package sort;

public class QuickSort2 {

    /*
    * Quick Sort :
    *
    * Divide and Conquer Algorithm
    * Recursive Algorithm
    *
    * Partitioning :
    *
    * Use pivot element to partition the array into 2 half parts      ... pivot = start / end element of array (sub-array)
    * smaller elements < pivot < larger elements
    * pivot will be in correct sorted position.     ... left and right sub-arrays are not necessarily sorted.
    *
    * sorting :
    *
    * Repeat above process for left and right sub-arrays.
    * Every element will be considered as pivot and all elements will be in correct sorted position.
    *
    * */

    public static void quickSort(int []a, int low, int high){

        if(low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);    // sort left sub-array
            quickSort(a, pivot + 1, high);    // sort right sub-array
        }
    }

    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];
        int i = start;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, start, i);
        return i;
    }

    // Function to swap two elements
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.print(" "+a[i]);
    }

    public static void main(String[] args) {

        QuickSort2 sort = new QuickSort2();

        int[] a = {100, 80, 90, 70, 5, 20, 50, 150, 10, 60};

        System.out.println("Before sort:");

        display(a);

        quickSort(a, 0, a.length-1);

        System.out.println("\nAfter sort:");
        display(a);
    }
}
