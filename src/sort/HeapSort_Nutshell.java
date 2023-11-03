package sort;

import sort.common.CommonUtility;

import java.util.Scanner;

public class HeapSort_Nutshell extends CommonUtility {

    void heapSort (int[] A, int n){
        buildHeap(A, n);
        for(int i=n-1; i>=1; i--){
            swap(A, 0, i);
            heapify(A, 0, i);
        }
    }

    void buildHeap (int[] A, int n){
        for(int i=n/2-1; i>=1; i--)
            heapify (A, i, n);
    }

    // Recursively enforce that A[idx,max) is valid heap.
    void heapify (int[] A, int idx, int max){
        int largest = idx;
        int left = 2*idx + 1;
        int right = 2*idx + 2;

        if(left < max && A[left] > A[idx])
            largest = left;

        if(right < max && A[right] > A[largest])
            largest = right;

        if(largest != idx){
            swap(A, idx, largest);
            heapify (A, largest, max);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HeapSort_Nutshell maxHeap = new HeapSort_Nutshell();

        int[] arr = {500, 100, 25, 50, 20, 15, 2, 30, 10, 40, 70, 80, 3, 150, 65, 5, 7, 1};

        int n = arr.length;

        System.out.println("\n Display array before sorting ...");
        maxHeap.display(arr);

        maxHeap.heapSort(arr, n);

        System.out.println("\n Display array after sorting ...");
        maxHeap.display(arr);
    }
}
