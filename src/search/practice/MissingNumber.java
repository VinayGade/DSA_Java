package search.practice;

import java.util.HashSet;

//kth missing number
/*
Given a sorted array of distinct positive integers arr[],
we need to find the kth positive number that is missing from arr[].

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.

Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.

Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.
* */
public class MissingNumber {

    static int kthMissing(int[] arr, int k) {
        HashSet<Integer> st = new HashSet<>();

        for(int i = 0; i < arr.length; i++)
            st.add(arr[i]);

        int val = 1;
        while(k > 0){
            if(!st.contains(val))
                k--;
            if(k == 0)
                return val;
            val=val+1;
        }
        return val;
    }

    // Optimized approach: Binary Search
    static int kthMissingNumber(int[] arr, int k) {
        int n = arr.length;

        int low = 0 , high = n - 1;

        while(low <= high){
            int mid = (low + high)/2;
            int missing = arr[mid] - (mid + 1);

            if(missing < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return k + high + 1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 9, 10, 11, 12};
        int k = 2;
        int missing = kthMissingNumber(arr, k);
        System.out.println("missing ="+missing);
    }
}
