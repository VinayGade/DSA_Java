package array.math.sliding_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SubarrayMaximum {

    // 2 pointers
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {

        int n = arr.length;

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        int max = Integer.MIN_VALUE;
        //int min = Integer.MAX_VALUE;

        while(j < n){

            if((j-i+1) < k)
                j++;
            else if((j-i+1) == k){
                for(int p=i; p<=j; p++){
                    max = Math.max(max, arr[p]);
                }
                list.add(max);
                i++;
                j++;
            }
        }
        return list;
    }

    // Sliding Window using Deque
    public static ArrayList<Integer> maxOfSubarraysSize_k(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements as they won't be needed
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element index
            deque.offerLast(i);

            // Store result once the first window of size `k` is formed
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        ArrayList<Integer> subarray = maxOfSubarraysSize_k(arr, k);
        for(int x: subarray){
            System.out.print(x+" ");
        }
    }
}
