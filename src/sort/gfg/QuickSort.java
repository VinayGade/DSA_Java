package sort.gfg;

public class QuickSort {

    /* * * * * Final Solution | Java Placement Course | Apna College * * * * */

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int i=low-1;

        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;

                //swap a[i], a[j]
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j] = temp;
            }
        }
        i++;

        //swap arr[high], a[i]      ... pivot = arr[high]
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;  /// pivot = temp

        return i; // index of new pivot
    }

    public static void main(String[] args) {

        QuickSort sort = new QuickSort();

        int[] array1 = {100, 10, 40, 30, 20, 50, 90, 60, 80, 70};
        int n1 =array1.length;
        sort.quickSort(array1, 0, n1-1);

        System.out.println("\nSorted array 1 :\n");
        for(int x : array1)
            System.out.print(" "+x);

        System.out.println("\n\nSorted array 2 :\n");
        int[] array2 = {15, 110, 24, 33, 12, 99, 200, 150, 180, 77};
        int n2 =array2.length;
        sort.quickSort(array2, 0, n2-1);

        for(int y : array2)
            System.out.print(" "+y);
    }
}
