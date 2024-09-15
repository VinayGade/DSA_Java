package array.math.kadane;

// CodeChef: 3* Difficulty

/*
Given 2 arrays A, B  ... |A| = N, |B| = M
You can apply the following operation until the array B until |B| > 0
1. Choose either the first or the last element of array B
2. Insert the chosen element to either the front or the back of array A
3. Delete the chosen element from array B.

Find the maximum sum of any subarray of the array A,
you can achieve after performing <= M operations.

Note: A subarray of an array is formed by deleting some (possibly zero) elements
from the beginning of the array and some (possible zero) elements from
the end of the array. A subarray can be empty as well.

input:
3
5
3 26 -79 72 23
2
66 44
1
81
1
-97
5
10 -5 14 -20 4
3
-10 5 -2

output:
205
81
24
* */

import java.util.Scanner;

public class MaximumSubArray {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            int[] A = new int[N];

            for (int i = 0; i < N; i++)
                A[i] = scanner.nextInt();

            int M = scanner.nextInt();
            int[] B = new int[M];

            long positiveSum = 0;
            for (int i = 0; i < M; i++) {
                B[i] = scanner.nextInt();
                if (B[i] > 0) {
                    positiveSum += B[i];
                }
            }

            // Create two scenarios: adding positive sum to the start and end of A
            long maxSum = Long.MIN_VALUE;

            // Scenario 1: Add positive sum to the start of A
            maxSum = Math.max(maxSum, kadane(A, positiveSum, true));

            // Scenario 2: Add positive sum to the end of A
            maxSum = Math.max(maxSum, kadane(A, positiveSum, false));

            System.out.println(maxSum);
        }
    }

    // Kadane's algorithm modified to consider positiveSum addition
    private static long kadane(int[] A, long positiveSum, boolean addAtStart) {
        long maxEndingHere = 0, maxSoFar = 0;

        if (addAtStart) {
            maxEndingHere = positiveSum;
            maxSoFar = positiveSum;
        }

        for (int value: A) {
            maxEndingHere += value;
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        if (!addAtStart) {
            maxSoFar = Math.max(maxSoFar, maxEndingHere + positiveSum);
        }

        return maxSoFar;
    }
}
