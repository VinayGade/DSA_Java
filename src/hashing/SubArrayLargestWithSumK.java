package hashing;

import java.util.HashMap;

/*
Longest Subarray with Sum K

Given an array arr[] containing integers and an integer k, your task is to find
the length of the longest subarray where the sum of its elements is equal to
the given value k. If there is no subarray with sum equal to k, return 0.

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10].
The length of the longest subarray with a sum of 15 is 6.

Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.

Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
* */

public class SubArrayLargestWithSumK {

    static int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Check if the prefix sum equals k
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Check if there is a prefix sum such that removing it gives sum k
            if (prefixSumMap.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum - k));
            }

            // Add the current prefix sum to the map if it is not already present
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = {-5, 8, -14, 2, 4, 12};
        int k = -5;
        int size = longestSubarray(arr, k);
        System.out.println("longest subarray size = "+size);
    }
}
