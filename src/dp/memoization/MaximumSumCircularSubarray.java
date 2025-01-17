package dp.memoization;

//LeetCode 918. Maximum Sum Circular Subarray

/*
Given a circular integer array nums of length n, return the maximum possible
sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array.
Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element
of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once.
Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 */

public class MaximumSumCircularSubarray {

    public static int maxSubarraySumCircular(int[] nums) {
        // variable to keep track of the total sum of the array
        int acc = 0;
        // variable to keep track of the maximum sum subarray using kadane's algorithm
        int max1 = kadane(nums);
        // iterate through the array and negate each element
        for(int i = 0; i < nums.length; i++) {
            acc += nums[i];
            nums[i] = -nums[i];
        }
        // variable to keep track of the minimum sum subarray using kadane's algorithm on the negated array
        int min = kadane(nums);
        // variable to keep track of the maximum sum subarray that can be formed by wrapping around the array
        int max2 = acc + min;
        // if the maximum sum subarray that can be formed by wrapping around the array is zero, return the maximum sum subarray using kadane's algorithm
        if(max2 == 0)  return max1;
        // return the maximum of the two maximum sum subarrays
        return Math.max(max1, max2);
    }

    // function to calculate the maximum sum subarray using kadane's algorithm
    static int kadane(int[] array) {
        // variable to keep track of the maximum sum subarray ending at current index
        int maxSum = array[0];
        // variable to keep track of the overall maximum sum subarray
        int max = array[0];
        // iterate through the array starting from the second element
        for(int i = 1; i < array.length; i++) {
            // update the maximum sum subarray ending at current index
            // by taking the maximum between the current element and the sum of the current element and the maximum sum subarray ending at the previous index
            maxSum = Math.max(maxSum+array[i], array[i]);
            // update the overall maximum sum subarray by taking the maximum between the current maximum sum subarray ending at current index and the overall maximum sum subarray
            max = Math.max(max, maxSum);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {1,-2,3,-2};
        int maxSum =maxSubarraySumCircular(nums);
        System.out.println(maxSum);
    }
}
