package hashing;

// Longest subarray with Atmost two distinct integers

/*

Given an array arr[] consisting of positive integers,
find the length of the longest sub-array that contains at most two distinct integers.

Input: arr[] = [2, 1, 2]
Output: 3
Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1).
Hence, the length of the longest subarray is 3.

Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2],
 which has a length of 5.

* */

import java.util.HashMap;
import java.util.Map;

public class SubArray2DistinctNums {

    public static int totalElements(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        int ans = 0, i = 0;
        for(int j = 0;j<arr.length;j++){
            mp.put(arr[j],mp.getOrDefault(arr[j],0)+1);
            if(mp.size() <= 2) {
                ans = Math.max(ans,j-i+1);
            }
            while(i < j && mp.size() > 2){
                mp.put(arr[i],mp.get(arr[i])-1);
                mp.remove(arr[i],0);
                i++;
                if(mp.size() <= 2) ans = Math.max(ans,j-i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 2, 2, 2};
        int count = totalElements(arr);
        System.out.println(count);
    }
}