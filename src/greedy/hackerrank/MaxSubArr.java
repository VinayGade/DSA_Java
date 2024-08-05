package greedy.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.

Given an array, find the maximum possible sum among:

all nonempty subarrays.
all nonempty subsequences.
Print the two values as space-separated integers on one line.

Note that empty subarrays/subsequences should not be considered.
The subarray and subsequences you consider should have at least one element.

sample input:
2
4
1 2 3 4
6
2 -1 2 3 4 -5

sample output:
10 10
10 11
* */
public class MaxSubArr {

    public static List<Integer> maxSubarray(List<Integer> a) {
        Integer [] arr = a.toArray(new Integer[0]);

        Integer subArraySum = maxSumSubarray(arr, arr.length);
        Integer subSequenceSum = maxSumSubarray(arr, arr.length);

        List<Integer> result = new ArrayList<>();
        result.add(subArraySum);
        result.add(subSequenceSum);

        return result;
    }

    public static int maxSumSubarray(Integer[] a, int n) {

        int sum = 0;
        int ans = a[1];
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum > ans)
                ans = sum;
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }

    // returns the maximum
    // non-empty subsequence sum
    static int MaxNonEmpSubSeq(Integer a[], int n){

        // Stores the maximum non-empty
        // subsequence sum in an array
        int sum = 0;

        // Stores the largest element
        // in the array
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(max < a[i])
            {
                max = a[i];
            }
        }

        if (max <= 0)
        {
            return max;
        }

        // Traverse the array
        for (int i = 0; i < n; i++)
        {
            // If a[i] is greater than 0
            if (a[i] > 0)
            {
                // Update sum
                sum += a[i];
            }
        }
        return sum;
    }

    /*
     The key to this one is that you want to do one pass through the data.  I first did a substring inner loop for the max subarray sum (code in comments), but this timed out for one test.

            int subArraySum = 0;
            for (int j = i; j < arr.size(); j++) {
                subArraySum += arr.get(j);
                if (greatestSum == null || subArraySum > greatestSum) {
                    greatestSum = subArraySum;
                }
            }
        }
        results.add(greatestSum);

    */
    public static List<Integer> maxSubarray2(List<Integer> arr) {
        List<Integer> results = new ArrayList<Integer>();
        int subArraySum = 0;
        int sumSubSequence = 0;
        int subArraySumMax = 0;

        for (int i = 0; i < arr.size(); i++) {
            //this is to get the max subarray sum
            subArraySum += arr.get(i);
            if(subArraySum < 0) {
                subArraySum = 0;
            }
            subArraySumMax = Math.max(subArraySumMax, subArraySum);

            //this is to get the max subsequence sum
            Integer value = arr.get(i);
            if (value > 0) {
                sumSubSequence += value;
            }
        }

        if (sumSubSequence > 0) {
            results.add(subArraySumMax);
            results.add(sumSubSequence);
        } else {
            //there are no positive values so we pick the highest value
            final int max = Collections.max(arr);
            results.add(max);
            results.add(max);
        }

        return results;
    }
}
