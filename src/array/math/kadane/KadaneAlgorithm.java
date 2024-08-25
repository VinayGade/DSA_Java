package array.math.kadane;

import java.util.Arrays;

/*
Given an array arr[] of n integers. Find the contiguous sub-array
(containing at least one number) which has the maximum sum and return its sum.

Input: arr[] = {1,2,3,-2,5}, n = 5
Output: 9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) is a contiguous subarray.

Input: arr[] = {-1,-2,-3,-4}, n = 4
Output: -1
Explanation: Max subarray sum is -1 of element (-1)

Input: arr[] = {5,4,7}, n = 3
Output: 16
Explanation: Max subarray sum is 16 of element (5, 4, 7)
* */

public class KadaneAlgorithm {

    static long maxSubArraySum(int arr[], int n) {
        long currSum =0;
        long maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            currSum += arr[i];
            if(currSum > maxSum)
                maxSum = currSum;
            if(currSum < 0)
                currSum=0;
        }
        return maxSum;
    }

    static long maxSubarraySum(int arr[], int n){
        boolean flag=false;
        long cs=0;
        long ms=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                flag=true;
                break;
            }
        }
        if(flag){
            for(int i=0;i<n;i++){
                cs+=arr[i];
                if(cs<0){
                    cs=0;
                }
                ms=Math.max(ms,cs);
            }
        }
        else{
            Arrays.sort(arr);
            return arr[n-1];
        }
        return ms;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,-2,5};
        int n = 5;
        System.out.println("Result ="+ maxSubArraySum (a, n));
    }
}
