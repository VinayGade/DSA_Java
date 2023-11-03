package sort;

import sort.common.CommonUtility;

public class MergeSort extends CommonUtility {

    // Create auxiliary array (with same length of original array)
    // less time and memory efficient than merge sort with 2 sub-arrays (if array is too big).
    public void mergeSort(int[] a, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort( a, left, mid);
            mergeSort( a, mid+1, right);
            merge(a, left, mid, right);
        }
    }

    private void merge(int[] a, int left, int mid, int right){

        int[] c = new int[a.length];
        int i = left;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= right){

            if(a[i] < a[j]){
                c[k] = a[i];
                i++;
            }else{
                c[k] = a[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            c[k]=a[i];
            i++;
            k++;
        }

        while(j <= right){
            c[k]=a[j];
            j++;
            k++;
        }

        for( i=left, j=0; i<=right; i++, j++)
            a[i]=c[j];

    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] array = { 100, 15, 10, 50 ,20, 40, 80, 90, 70};
        System.out.println("Before Merge Sort array :");
        sort.display(array);
        sort.mergeSort(array, 0, array.length-1);
        System.out.println("Merge Sorted Array :");
        sort.display(array);

        int[] array1 = {100, 10, 40, 30, 20, 50, 90, 60, 80, 70};
        System.out.println("Before Merge Sort array1 :");
        sort.display(array1);
        sort.mergeSort(array1, 0, array1.length-1);
        System.out.println("Merge Sorted Array1 :");
        sort.display(array1);

        int[] array2 = {15, 110, 24, 33, 12, 99, 200, 150, 180, 77};
        System.out.println("Before Merge Sort array2 :");
        sort.display(array2);
        sort.mergeSort(array2, 0, array2.length-1);
        System.out.println("Merge Sorted Array2 :");
        sort.display(array2);

    }
}
