package hashing;

import java.util.HashSet;
import java.util.Set;

/*

LeetCode 523. Continuous Subarray Sum

Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k.
0 is always a multiple of k.

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false

* */

public class ContinuousSubarraySum {

    static boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> modSet=new HashSet();
        int currSum = 0, prevSum=0;
        //when we add prevSum=0 in set it will actually check if currSum is divided by k
        for(int n : nums) {
            currSum += n;
            if(modSet.contains(currSum % k)) {
                return true;
            }
            currSum %= k;
            modSet.add(prevSum);
            prevSum = currSum;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {23,2,6,4,7};
        int k = 6;
        boolean result = checkSubarraySum(nums, k);
        System.out.println(result);
    }
}
