package sort;

import java.util.Scanner;

public class HeapSort_All extends CommonUtility{

    /*
    private int parent( int i){
        return i/2;
    }
     */

    private int left(int i){
        return 2*i + 1;
    }

    private int right(int i){
        return 2*i + 2;
    }

    private void maxHeapify( int []a, int i, int n){

        int largest = i;
        //int n = a.length;

        int l = left(i);
        int r = right(i);

        if( l<n && a[l]>a[largest])
            largest = l;

        //else largest = i;

        if(r<n && a[r]>a[largest])
            largest = r;

        if(largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, n);
        }
    }

    private void buildMaxHeap(int[] a, int n){

        //int i=(n%2==0) ? n/2 : n/2+1;

        /*
        10  5
        11  6
        */
        /*
        while(i>=0) {
            maxHeapify(a, i, n);
            i--;
        }
        */

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, n);
        }
    }

    public void maxHeapSort(int[] a, int n){

        buildMaxHeap(a, n);

        //int heapSize = n;

        for(int i=n-1; i>=0; i--){
            swap(a, 0, i);
            //heapSize--;
            maxHeapify(a, 0, i);
        }
    }

    private void minHeapSort(int[] a, int n) {
        buildMinHeap(a, n);

        for(int i=n-1; i>=0; i--){
            swap(a, 0, i);
            minHeapify(a, 0, i);
        }
    }

    private void buildMinHeap(int[] a, int n) {

        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(a, i, n);
        }
    }

    private void minHeapify(int []a, int i, int n) {

        int smallest = i;

        int l = left(i);
        int r = right(i);

        if( l<n && a[l]<a[smallest])
            smallest = l;

        if(r<n && a[r]<a[smallest])
            smallest = r;

        if(smallest != i){
            swap(a, i, smallest);
            maxHeapify(a, smallest, n);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HeapSort_All maxHeap = new HeapSort_All();

        int[] arr = {500, 100, 25, 50, 20, 15, 200, 30, 10, 40, 70, 80, 300, 150, 65, 5, 2, 1};

        int n = arr.length;

        System.out.println("\n Display array before sorting ...");
        maxHeap.display(arr);

        System.out.println("\n Enter choice of Heap sort sort type");
        System.out.println("0. Max Heap");
        System.out.println("1. Min Heap");

        int choice = scanner.nextInt();

        //while(choice < 2) {
            switch (choice) {
                case 0:
                    System.out.println("\n Display array after Max sorting ...");
                    maxHeap.maxHeapSort(arr, n);
                    maxHeap.display(arr);
                    break;

                case 1:
                    HeapSort_All minHeap = new HeapSort_All();
                    minHeap.minHeapSort(arr, n);
                    minHeap.display(arr);
                    break;

                default:
                    System.out.println("Please enter valid choice!!");
                    break;
            }
        //}


    }

}