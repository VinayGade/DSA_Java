package heap.priorityQ;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeap {

    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        int arr[] = {100, 10, 20, 50, 40, 15, 90, 70, 80, 5};

        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++)
            heap.add(arr[i]);

        for(int j = 0; j < k-1; j++){
            System.out.println((j+1)+"th largest element ="+heap.peek());
            heap.poll();
        }

        System.out.println(k+"th largest element ="+heap.poll());
    }
}
