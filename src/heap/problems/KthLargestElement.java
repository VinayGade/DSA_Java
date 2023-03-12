package heap.problems;

import heap.max.MaxHeap;

public class KthLargestElement {

    public static Integer kthLargest(int arr[], int n, int k){

        MaxHeap maxHeap = new MaxHeap(n);
        for(int i=0; i<n; i++){
            maxHeap.insert(arr[i]);
        }

        for(int i=0;i<(k-1);i++){
            maxHeap.extractMax();
        }

        return maxHeap.extractMax();
    }

    public static void main(String args[]){
        System.out.println("Kth largest element :");
        int n = 7;
        int array[] = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

       int kthLargestElement = kthLargest (array, n, k);

       System.out.println("k ="+k+"th largest element ="+kthLargestElement);
    }
}
