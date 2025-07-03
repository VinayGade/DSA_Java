package dp.tabulation;

import java.util.*;
/*


Increasing-Decreasing Sequence

You are given a sequence A You need to find the maximum length of a subsequence of
A whose elements first strictly increase and then strictly decrease in value.
Note that subsequences that are only strictly increasing and subsequences that are
only strictly decreasing are considered as well.

A subsequence of a given sequence is a sequence that can be derived from the given sequence
by deleting some or no elements without changing the order of the remaining elements.

input format:

The first line of the input contains a single integer t : number of test cases
    The description of t  test cases follows.

    The first line of each test case contains an integer N

    The second line contains N space-separated integers A1, A2, ..., An

Input:
4
9
1 2 3 1 4 1 3 2 1
5
2 4 3 6 3
4
1 2 3 4
5
9 9 9 9 9

Output:
7
4
4
1

Explanation:
Example case 1: The longest suitable subsequence is [1,2,3,4,3,2,1]
Example case 2: The longest suitable subsequence is [2,4,6,3]
* */

public class IncreasingDecreasingSequence {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            //int result = longestBitonicSubsequence(nums, n);

            int result = longestIncreasingDecreasing(nums, n);

            System.out.println(result);
        }
        sc.close();
    }

    // issue: time complexity : O(N^2)
    public static int longestBitonicSubsequence(int[] nums, int n) {
        int[] inc = new int[n]; // LIS from left
        int[] dec = new int[n]; // LDS from right

        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);

        // Compute LIS for each index
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && inc[i] < inc[j] + 1) {
                    inc[i] = inc[j] + 1;
                }
            }
        }

        // Compute LDS for each index
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && dec[i] < dec[j] + 1) {
                    dec[i] = dec[j] + 1;
                }
            }
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
        }
        return maxLen;
    }

    public static int longestIncreasingDecreasing( int[] nums, int n ){

        int[] inc = new int[n]; // LIS from left
        int[] dec = new int[n]; // LDS from right

        int[] tailInc = new int[n];
        int lenInc = 0;

        // Compute LIS for each index
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(tailInc, 0, lenInc, nums[i]);
            tailInc[pos] = nums[i];
            if (pos == lenInc) lenInc++;
            inc[i] = pos + 1;
        }

        int[] rev = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = nums[n - 1 - i];
        }

        int[] tailDec = new int[n];
        int lenDec = 0;

        // Compute LDS for each index
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(tailDec, 0, lenDec, rev[i]);
            tailDec[pos] = rev[i];
            if (pos == lenDec) lenDec++;
            dec[i] = pos + 1;
        }

        for (int i = 0; i < n / 2; i++) {
            int temp = dec[i];
            dec[i] = dec[n - 1 - i];
            dec[n - 1 - i] = temp;
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
        }
        return maxLen;

    }

    // Binary search to find the appropriate place to insert
    static int lowerBound(int[] arr, int low, int high, int target) {
        int l = low, r = high;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
