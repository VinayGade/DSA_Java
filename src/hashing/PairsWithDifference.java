package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
Pair With Given Difference:

Given an one-dimensional unsorted array A containing N integers.

You are also given an integer B, find if there exists a pair of elements in the array
whose difference is B.

Return 1 if any such pair exists else return 0.

* */

public class PairsWithDifference {

    public static int containsPair(ArrayList<Integer> arr, int k) {
        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = 0;
        for(int data: arr){
            int key = k + data;
            if(map.containsKey(key))
                flag = 1;
            map.put(data, map.getOrDefault(data, 0)+1);
        }
        return flag;
        */

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            // Check if (num - k) or (num + k) exists in the set
            if (set.contains(num - k) || set.contains(num + k)) {
                return 1;
            }
            set.add(num);
        }

        return 0;
    }

    /*
LeetCode 2006. Count Number of Pairs With Absolute Difference K.
Given an integer array nums and an integer k, return the number of pairs (i, j)
 where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.

Example 1:

Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
Example 2:

Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.
Example 3:

Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
- [3,2,1,5,4]
- [3,2,1,5,4]
- [3,2,1,5,4].
    * */

    public static int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int countPairs = 0;

        for (int num : nums) {
            // Check for both (num - k) and (num + k) in the map
            countPairs += map.getOrDefault(num - k, 0);
            countPairs += map.getOrDefault(num + k, 0);

            // Update the frequency map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return countPairs;
    }

    public static void main(String[] args) {

        int k = 1;
        int count = countKDifference(new int[]{1, 2, 2, 1}, k);

        System.out.println("difference = "+k+", count = "+count);

        k=2;
        count = countKDifference(new int[]{3, 2, 1, 5, 4}, k);

        System.out.println("difference = "+k+", count = "+count);

        System.out.println("\n Find if difference exists?");

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 10, 3, 2, 50, 80));
        int key = 78;
        String result = containsPair(arr, key) == 1 ? "YES": "NO";
        System.out.println(result); // Output: 1

        arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        key = 10;
        result = containsPair(arr, key) == 1 ? "YES": "NO";
        System.out.println(result); // Output: 0
    }
}
