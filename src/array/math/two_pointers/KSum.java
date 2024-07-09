package array.math.two_pointers;

import java.util.Scanner;

//CodeChef -> 2-Pointers -> K Sum

/*
Given an array arr of positive integers and an integer k
write a program that returns the maximum possible sum of k elements taken from
either the start of the array, the end of the array, or a combination of both.

Input
5 3
4 2 1 5 1

Output
10

Take one element from the start of the array and take 2 elements from the end of the array.
the sum will be 4+1+5=10.
* * */
public class KSum {

    // 2 - Pointers + Prefix sums
    public static long maxSumKElements(long[] arr, int k, int n) {
        // Initialize the variables for two pointers
        int i = 0;
        int j = n - 1;

        // Array to store the maximum sum for different combinations
        long[] prefixSumStart = new long[k + 1];
        long[] prefixSumEnd = new long[k + 1];

        // Calculate the prefix sums from the start
        for (int x = 1; x <= k; ++x) {
            prefixSumStart[x] = prefixSumStart[x - 1] + arr[x - 1];
        }

        // Calculate the prefix sums from the end
        for (int x = 1; x <= k; ++x) {
            prefixSumEnd[x] = prefixSumEnd[x - 1] + arr[n - x];
        }

        // Calculate the maximum sum by combining elements from start and end
        long maxSum = 0;
        for (int x = 0; x <= k; ++x) {
            long currentSum = prefixSumStart[x] + prefixSumEnd[k - x];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // sliding - window
    /*
    public static long maxSumKElements(long[] arr, int k, int n) {
        // Calculate the sum of the first k elements
        long currentSum = 0;
        for (int i = 0; i < k; ++i) {
            currentSum += arr[i];
        }

        // This is the initial maximum sum (taking all k elements from the start)
        long maxSum = currentSum;

        // Two-pointer technique: start from the end of the array and replace elements from the start
        for (int i = 0; i < k; ++i) {
            currentSum = currentSum - arr[k - 1 - i] + arr[n - 1 - i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextLong();
        }

        System.out.println(maxSumKElements(arr, k, n));
    }
}
