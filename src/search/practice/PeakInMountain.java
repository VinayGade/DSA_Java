package search.practice;

// LeetCode 852. Peak Index in a Mountain Array (Perfect Peak of Array)

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

    public static void main(String[] args) {
        int[]  arr = {0,10,5,2};
        int peak = peakIndexInMountainArray(arr);
        System.out.println(peak);
    }
}
