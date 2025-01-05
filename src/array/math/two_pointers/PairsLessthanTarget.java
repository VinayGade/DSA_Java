package array.math.two_pointers;

//Count Pairs whose sum is less than target
/*

Given an array arr[] and an integer target. You have to find the number of pairs in
the array whose sum is strictly less than the target.

Input: arr[] = [2, 1, 8, 3, 4, 7, 6, 5], target = 7
Output: 6
Explanation: There are 6 pairs whose sum is less than 7: (2, 1),
(2, 3), (2, 4), (1, 3), (1, 4) and (1, 5).

* */

import java.util.Arrays;

public class PairsLessthanTarget {

    static int countPairs(int arr[], int target) {

        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        int ans = 0;
        while( i <= j ){
            if((arr[i]+arr[j])>=target)
                j--;
            else{
                ans+=(j-i);
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 8, 3, 4, 7, 6, 5};
        int target = 7;
        int count = countPairs(arr, target);
        System.out.println(count);
    }
}
