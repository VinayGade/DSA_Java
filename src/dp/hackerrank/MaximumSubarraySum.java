package dp.hackerrank;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarraySum {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Write your code here
        int maxSubarraySum = Integer.MIN_VALUE;
        int currentSum = 0;
        int maxSubsequenceSum = 0;
        boolean hasPositive = false;
        int maxNegative = Integer.MIN_VALUE;
        for (int num : arr) {
            // Kadane's Algorithm for Maximum Subarray Sum
            currentSum += num;
            if (currentSum > maxSubarraySum) {
                maxSubarraySum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (num > 0) {
                maxSubsequenceSum += num;
                hasPositive = true;
            }
            if (num < 0 && num > maxNegative) {
                maxNegative = num;
            }
        }
        if (!hasPositive) {
            maxSubsequenceSum = maxNegative;
        }
        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, -1, 2, 3, 4, -5);
        List<Integer> subarr = maxSubarray(arr);
        for(int x: subarr){
            System.out.print(x+" ");
        }
    }
}
