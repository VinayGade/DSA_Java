package sort.gfg;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {100, 90, 30, 20, 50, 70, 80, 10, 5, 40};

        InsertionSort insertion = new InsertionSort();
        insertion.insertionSort(arr);

        System.out.println("sorted array :");

        for(int x : arr)
            System.out.println(x);
    }

    public void insertionSort(int [] a) {

        int n = a.length;

        // initially i = 1, j = 0;
        for(int i=1; i<n; i++){

            int key = a[i];
            int j = i-1;       // 0.. j ... sorted range    ...(1)

            while(j>=0 && key<a[j]){
                a[j+1] = a[j];      // a[j] > key  ...shift right.
                j--;
            }
            a[j+1] = key;    // put next element to j+1    ... since(1)
        }
    }
}

/* Rule :
    1. Divide array in 2 parts, Sorted | Unsorted
    2. Pick up 1 element from Unsorted part and place it in Sorted (Correct position)
    3. Shift Sorted array to right
 */

/*
7  8  3  1  2

7 | 8  3  1  2     ... sorted [7]

7  8 | 3  1  2     ... sorted [7 8]

3  7  8 | 1  2     ... sorted [3 7 8]

1  3  7  8 | 2     ... sorted [1 3 7 8]

1  2  3  7  8     ... sorted [1 2 3 7 8]  ... final result

* */
