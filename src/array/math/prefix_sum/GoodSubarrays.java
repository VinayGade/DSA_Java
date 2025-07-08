package array.math.prefix_sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Good subarrays

You are given an array A and |A| = N

subarray is good if the sum of elements of this subarray is equal to an integer k.

Find the number of good subarrays present in the array.

input

3 1
1 0 3

output:
2

Sum for sub arrays: [1,1] => 1

[1,2] => 1

[1,3] => 4

[2,2] => 0

[2,3] => 3

[3,3] => 3

As we can see for all of the above sub arrays only [1,1] and [1,2] are equivalent to k.

* */

public class GoodSubarrays {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] a = new int[N];

        for (int i = 0; i < N; i++)
            a[i] = scanner.nextInt();

        int count = countGoodSubArray(a, N, K);
        System.out.println(count);
    }

    static int countGoodSubArr(int[] a, int n, int k){

        int count = 0;

        int i = 0;

        while(i<n){

            int sum = 0;

            for(int j = i; j < n; j++){
                sum += a[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    static int countGoodSubArray(int[] a, int n, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initialize:  A prefix sum of 0 exists before the array starts. Crucial for subarrays starting at index 0

        int count = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += a[i];

            // Check if (prefixSum - k) exists in the map
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }
            // Update the frequency of the current prefix sum
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
