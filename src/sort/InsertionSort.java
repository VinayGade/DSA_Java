package sort;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {100, 50, 20, 30, 10, 40, 70, 80, 65, 5};

        System.out.println("\n Before Sorting : ");
        display(arr);

        insertionSort(arr);

        System.out.println("\n After Sorting : ");
        display(arr);
    }

    public static void insertionSort(int [] a){

        int n = a.length;

        /*
        * 1. Unsorted array a[i] .. a[n]
        * */

        int i = 1;

        while(i<n){

            int temp = a[i];

            /*
            * 2. Sorted Array  ... a[j] .. a[0]
            *       compare (temp, a[j])
            *
            *       Right shift a[j] until temp > a[j]
            */

            int j = i-1;

            while(j>=0 && temp < a[j]){  //(2)
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = temp;  //(3)
            i++;
        }
    }

    public static void display(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.print(" "+a[i]);
    }
}
