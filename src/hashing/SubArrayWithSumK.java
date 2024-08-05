package hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
LeetCode 560:
Given an array of integers nums and an integer k, return the total number of subarrays
whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
* */

/*
Given an array of positive and negative numbers the tasks

subarray (of size at least one) with 0 sum

Input: {4, 2, -3, 1, 6)

Output: true

Explanation:

There is a subarray with zero sum from inder Its 3

Input: {4, 2, 0, 1, 6)

Output: true

Explanation: The third element is zero. A single

Input: {-3, 2, 3, 1, 6}

Output: false
* */


public class SubArrayWithSumK {


    //Zero Sum Subarray
    public static boolean hasZeroSumSubarray(int[] arr) {
        // Create an empty HashSet to store the cumulative sum
        HashSet<Integer> set = new HashSet<>();

        // Initialize the cumulative sum
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the cumulative sum
            sum += arr[i];

            // If the cumulative sum is zero or if it's already present in the set
            // then there exists a subarray with sum zero
            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            // Add the cumulative sum to the set
            set.add(sum);
        }

        // No subarray with zero sum found
        return false;
    }

    // Function to find number of subarrays
    // with sum exactly equal to k.
    static int findSubarraySum(int arr[], int n, int k)
    {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0,1);
        int res = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currSum += arr[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum=currSum-k;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                res += prevSum.get(removeSum);

            // Add currsum value to count of
            // different values of sum.
            prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
        }

        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0; j<nums.length; j++){
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, -3, 1, 6};
        int[] arr2 = {4, 2, 0, 1, 6};
        int[] arr3 = {-3, 2, 3, 1, 6};

        System.out.println(hasZeroSumSubarray(arr1)); // Output: true
        System.out.println(hasZeroSumSubarray(arr2)); // Output: true
        System.out.println(hasZeroSumSubarray(arr3)); // Output: false
    }
}
