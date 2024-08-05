package greedy.hackerrank;

import java.util.*;

public class MaxSubarraySubsequenceSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read the size of the array
            int n = sc.nextInt();
            int[] a = new int[n];

            // Read the elements of the array
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Compute the maximum subarray sum
            int maxSubarraySum = maxSubarraySum(a, n);

            // Compute the maximum subsequence sum
            int maxSubsequenceSum = maxSubsequenceSum(a, n);

            // Print the results
            System.out.println(maxSubarraySum + " " + maxSubsequenceSum);
        }

        sc.close();
    }

    public static int maxSubarraySum(int[] a, int n) {
        int maxSoFar = a[0], maxEndingHere = a[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static int maxSubsequenceSum(int[] a, int n) {
        int maxElement = a[0];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                sum += a[i];
            }
            if (a[i] > maxElement) {
                maxElement = a[i];
            }
        }

        // If all elements are non-positive, sum should be the maximum element
        return sum > 0 ? sum : maxElement;
    }
}