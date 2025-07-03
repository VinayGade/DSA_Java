package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class GroupBalls {

    /*
    Group balls by sequence:
     You are given an array arr[] of positive integers, where each element arr[i] represents the number written on the i-th ball,
     and a positive integer k.
    Your task is to determine whether it is possible to rearrange all the balls into groups such that:
    Each group contains exactly k balls.
    The numbers in each group are consecutive integers.
    Input: arr[] = [10, 1, 2, 11], k = 2
    Output: true
    Explanation: The hand can be rearranged as [1, 2], [10, 11]. There are two groups of size 2. Each group has 2 consecutive cards.

     Input: arr[] = [7, 8, 9, 10, 11], k = 2
    Output: false
    */

    /*  incorrect approach:

     public boolean validgroup(int[] arr, int k) {

     int n = arr.length;

     if(n%k != 0)
     return false;

     Arrays.sort(arr); // [1, 2, 10, 11]

     boolean flag = true;

     int i=0;
     int j=k-1;

     while(j<n){

     while(i<j){
     if((arr[i+1] - arr[i]) > 1){
     flag = false;
     break;
     }
     i++;
     }
     j+=k;
     }
     return flag;
     }
     }
     */

    // with HashMap
    static boolean validgroup(int[] arr, int k) {
        int n = arr.length;

        if (n % k != 0)
            return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        while (!freq.isEmpty()) {
            int first = freq.firstKey();

            for (int i = 0; i < k; i++) {
                int current = first + i;

                if (!freq.containsKey(current)) return false;

                freq.put(current, freq.get(current) - 1);
                if (freq.get(current) == 0) {
                    freq.remove(current);
                }
            }
        }
        return true;
    }

    // with PriorityQueue
    static boolean validGroup(int[] arr, int k) {
        int n = arr.length;
        if (n % k != 0) return false;

        // Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min-heap of unique numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freq.keySet());

        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();

            // Try forming a group from start to start + k - 1
            for (int i = 0; i < k; i++) {
                int current = start + i;

                if (!freq.containsKey(current)) return false;

                freq.put(current, freq.get(current) - 1);

                if (freq.get(current) == 0) {
                    freq.remove(current);
                    // Remove from heap only if it's the smallest
                    if (current == minHeap.peek()) {
                        minHeap.poll();
                    } else {
                        // This condition ensures we only remove the top; other values will be handled later
                        return false; // Inconsistent heap and map -> invalid
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,2,3,4,7,8};
        int k = 3;

        boolean isValid = validgroup(arr, k);
        System.out.println(isValid);
    }
}
