package array.math;

/*
GFG problem:
Given an array arr of non-negative numbers.
The task is to find the first equilibrium point in an array.
The equilibrium point in an array is an index (or position) such that
the sum of all elements before that index is the same as the sum of elements after it.
(Note: 1 Based indexing)
*/

/*
LeetCode 724. Find Pivot Index

Given an array of integers nums calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to
the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0.
because there are no elements to the left. This also applies to the right edge of the array.

(Note: 0 Based indexing)

Return the leftmost pivot index. If no such index exists, return -1.

Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
* */

public class EquilibriumPoint {

    public static int equilibriumPoint(long arr[]) {
        int n = arr.length;

        if (n == 1)
            return 1;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        long leftsum = 0;
        long rightsum = sum;

        for (int i = 0; i < n; i++) {
            rightsum -= arr[i];
            if (leftsum == rightsum)
                return i + 1;
            leftsum += arr[i];
        }

        return -1;
    }

    static int pivotIndex(int[] a) {
        if(a.length == 0)
            return - 1;
        int leftSum = 0, rightSum = 0;
        for(int x : a)
            rightSum += x;

        for(int i = 0; i < a.length; i ++) {
            rightSum -= a[i];
            if(rightSum == leftSum)
                return i;
            leftSum += a[i];
        }
        return - 1;
    }

    public static void main(String[] args) {
        long[] arr={4, 6, 5, 7, 1, 2};
        int[] a={1, 3, 5, 2, 2};
        int index = equilibriumPoint(arr);
        int pivotIndex = pivotIndex(a);

        System.out.println("equilibrium Point (1-based indexing) =" +index);
        System.out.println("Pivot Index (0-based indexing) =" +pivotIndex);
    }
}