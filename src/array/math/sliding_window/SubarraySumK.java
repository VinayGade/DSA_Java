package array.math.sliding_window;

import java.util.Scanner;

/*
Finding the Subarray with Minimum Sum of Size K

You are given an array of integers and you need to find a subarray of size K
 that has the minimum sum in all the subarray of size K.

 input:
 10 3
1 2 3 4 5 6 7 8 9 10

Output:
6

Input:
5 2
4 3 2 1 5

Output:
3

* */
public class SubarraySumK {

    public static long findMinSumSubarray(int n, int k, int[] arr){
        long current_sum = 0;
        for (int i = 0; i < k; i++) {
            current_sum += arr[i];
        }
        long min_sum = current_sum;

        for (int i = k; i < n; i++) {
            current_sum += arr[i] - arr[i - k];
            min_sum = Math.min(min_sum, current_sum);
        }
        return min_sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(findMinSumSubarray(n, k, arr));
    }
}
