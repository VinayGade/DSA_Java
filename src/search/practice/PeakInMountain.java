package search.practice;

// LeetCode 852. Peak Index in a Mountain Array (Perfect Peak of Array)

import java.util.ArrayList;

/*

You are given an integer mountain array arr of length n
where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
* */
public class PeakInMountain {

    static int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] < A[m + 1])
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    public int findPeakElement(ArrayList<Integer> A) {

        int left = 0, right = A.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (A.get(mid) > A.get(mid + 1)) {
                // Peak is in the left half (including mid)
                right = mid;
            } else {
                // Peak is in the right half
                left = mid + 1;
            }
        }
        return A.get(left); // 'left' or 'right' will point to the peak
    }

    public static void main(String[] args) {
        int[]  arr = {0,10,5,2};
        int peak = peakIndexInMountainArray(arr);
        System.out.println(peak);
    }
}
