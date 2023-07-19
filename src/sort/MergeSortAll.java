package sort;

import java.util.Scanner;

public class MergeSortAll {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = {500, 100, 25, 50, 20, 15, 200, 30, 10, 40, 70, 80, 300, 150, 65, 5, 2, 1};

        System.out.println("\n Display array before sorting ...");
        display(arr);

        System.out.println("\n Enter choice of sort type");
        System.out.println("0. single array");
        System.out.println("1. sub-arrays");

        int choice = scanner.nextInt();

        System.out.println("\n Display array after sorting ...");
        selectMergeSort(arr, choice);
    }

    public static void selectMergeSort(int[] arr, int choice){

        int low = 0;
        int high = arr.length-1;

        MergeSortAll mSort = new MergeSortAll();

        switch(choice){
            case 0:
                mSort.mergeSort(arr, low, high);
                display(arr);
                break;

            case 1:
                mSort.recursiveMergeSort(arr, low, high);
                display(arr);
                break;

            default:
                System.out.println("\nYou have entered a invalid choice !!");
        }
    }

    public void mergeSort(int[] a, int low, int high){
        if(low < high) {  // a.length >= 2
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    public void recursiveMergeSort(int[] a, int low, int high){
        if(low < high) {  // a.length >= 2

            //int mid = low + (high - low) / 2;

            int mid = (low + high)  / 2;

            // int mid = arr.length / 2;

            recursiveMergeSort(a, low, mid);
            recursiveMergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    public void merge(int[] a, int low, int mid, int high){

        int n = a.length;

        // buffer array where elements are kept in sorted order
        int c[] = new int[n];
        int i = low;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=high){

            // pick smaller element from 2 sub-arrays
            if(a[i] <= a[j]){
                c[k] = a[i];
                i++;
            } else {
                c[k] = a[j];
                j++;
            }
            k++;
        }

        // copy remaining elements from sub-arrays
        while(i<=mid){
           c[k] = a[i];
           i++;
           k++;
        }

        while(j<=high){
            c[k] = a[j];
            j++;
            k++;
        }

        // buffer array c is sorted.
        // Copy all elements from buffer array c to original array a
        // source array a is sorted now

        for(i=low, j=0; i<=high; i++, j++){
            a[i] = c[j];
        }
    }

    public void mergeSubArrays(int[] a, int low, int mid, int high){

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0; i<n1; i++)
            left[i] = a[low+i];

        for(int j=0; j<n2; j++)
            right[j] = a[high+j+1];

        // Maintain current index of sub-arrays and main array
        int i = 0;
        int j = 0;
        int k = low;

        while(i<=mid && j<=high){

            // pick smaller element from 2 sub-arrays
            if(left[i] <= right[j]){
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        // copy remaining elements from sub-arrays
        while(i<=mid){
            a[k] = left[i];
            i++;
            k++;
        }

        while(j<=high){
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void display(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.print(" "+a[i]);
    }

}