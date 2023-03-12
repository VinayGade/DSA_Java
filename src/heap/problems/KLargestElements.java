package heap.problems;

import heap.max.MaxHeap;

import java.util.ArrayList;

public class KLargestElements {

    public static ArrayList<Integer> kLargest(int[] arr, int n, int k){

        MaxHeap maxHeap = new MaxHeap(n);
        for(int i=0; i<n; i++){
            maxHeap.insert(arr[i]);
        }

        ArrayList<Integer> kLargestElements = new ArrayList<>();
        for(int i=0;i<k;i++){
            kLargestElements.add(maxHeap.extractMax());
        }

        return kLargestElements;
    }

    public static void main(String[] args){
        System.out.println("K largest elements :");
        int n = 7;
        int[] array = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        ArrayList<Integer> kLargestElements = kLargest (array, n, k);

        for(Integer x: kLargestElements)
            System.out.print(x+" ");
    }
}