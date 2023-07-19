package sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {100, 50, 20, 30, 10, 40, 70, 80, 65, 5};

        System.out.println("\n Before Sorting : ");
        display(arr);

        selectionSort(arr);

        System.out.println("\n After Sorting : ");
        display(arr);
    }

    // Selection sort :

    /*
    1. find min
       Find minimum element form unsorted part of array    ...(a[j] .. a[n-1])

    2. Sorted sub-array      ... (a[i] .. a[j])
       Place minimum found at (1) at end of sorted sub-array
    * */
     static void selectionSort( int[] a){
        int n = a.length;

        for(int i=0; i<n-1; i++){

            /*
            1. find min
                Find minimum element form unsorted part of array.    ...(a[j] .. a[n-1])

            * */

            int smallest = i;
            for(int j=i+1; j<n; j++){

                if(a[j] < a[smallest])
                    smallest = j;
            }

            /*
            2. Sorted sub-array      ... (a[i] .. a[j])
                Place minimum found at (1) at end of sorted sub-array.
            * */

            // swap (a[smallest], a[i])
            int temp = a[smallest];
            a[smallest] = a[i];
            a[i] = temp;
        }
    }
    public static void display(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.print(" "+a[i]);
    }
}
