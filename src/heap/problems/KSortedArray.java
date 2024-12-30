package heap.problems;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KSortedArray {

    static void kSort(int[] a, int n, int k){
        if(a.length == 0)
            return;

        // Max-Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int minCount = Math.min(a.length, (k+1));

        for(int i=0; i<minCount; i++)
            queue.add(a[i]);

        int index = 0;
        for(int i=(k+1); i<n; i++){
            a[index++] = queue.peek();
            queue.poll();
            queue.add(a[i]);
        }

        Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext()){
            a[index++] = queue.peek();
            queue.poll();
        }

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

    public static void main(String[] args) {
        int[] a = {2, 56, 6, 3, 12, 8};
        int k = 3;

        //int[] a = {2, 6, 3, 12, 56, 8, 50, 5, 10, 1};
        int n = a.length;
        kSort(a, n, k);
    }
}
