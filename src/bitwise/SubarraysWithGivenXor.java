package bitwise;

import java.util.HashMap;
/*
Given an array of integers arr[] and a number k, count the number of subarrays
having XOR of their elements as k.

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4],
[2, 2, 6], and [6]. Hence, the answer is 4.

Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9].
Hence, the answer is 2.

Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤105
0 ≤ k ≤ 105
* */

public class SubarraysWithGivenXor {

    public static long subarrayXor(int arr[], int k) {
        long count = 0;
        int prefixXor = 0;
        HashMap<Integer, Long> map = new HashMap<>();

        // Initialize the map with prefix XOR of 0 occurring once (important for cases where prefixXor == k)
        map.put(0, 1L);

        for (int num : arr) {
            // Update the prefix XOR up to the current index
            prefixXor ^= num;

            // Check if the current prefix XOR ^ k exists in the map
            if (map.containsKey(prefixXor ^ k)) {
                count += map.get(prefixXor ^ k); // Add the count of previous prefix XORs that satisfy the condition
            }
            // Add the current prefix XOR to the map
            map.put(prefixXor, map.getOrDefault(prefixXor, 0L) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int k = 5;
        int[] arr = {5, 6, 7, 8, 9};
        long count = subarrayXor(arr, k);
        System.out.println(count);
    }
}
