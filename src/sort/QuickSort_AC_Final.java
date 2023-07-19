package sort;

public class QuickSort_AC_Final {

    public static void main(String[] args) {
        int[] arr = {100, 50, 20, 30, 10, 40, 70, 80, 65, 5};

        System.out.println("\n Before Sorting : ");
        display(arr);

        quickSort(arr, 0, arr.length-1);

        System.out.println("\n After Sorting : ");
        display(arr);
    }

    public static void quickSort(int[] a, int low, int high){
        if(low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high){

        int pivot = a[high];
        int i = low-1;

        for(int j=low; j<high; j++){    // ...elements before pivot

            if(a[j] < pivot){
                i++;

                swap(a, i, j);
                /*
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                */
            }
        }

        i++;

        // swap (a[i], pivot)  or  swap (a[i], a[high])
        swap(a, i, high);
        /*
        int temp = a[i];
        a[i] = a[high];    //a[i] = pivot;
        a[high] = temp;
         */
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.print(" "+a[i]);
    }
}
