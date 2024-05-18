package hashing;

import java.util.HashMap;

/*
Given an array of N integers, and an integer K,
find the number of pairs of elements in the array whose sum is equal to K.

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation:
arr[0] + arr[1] = 1 + 5 = 6
and arr[1] + arr[3] = 5 + 1 = 6.

Input:
N = 4, K = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation:
Each 1 will produce sum 2 with any 1.
* */
public class CountPairsSum {

    static int getPairsCount(int[] arr, int n, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int data: arr){
            int key = k-data;
            if(map.containsKey(key))
                count += map.get(key);
            map.put(data, map.getOrDefault(data, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {

        int N = 4, K = 6;
        int arr[] = {1, 5, 7, 1};
        int count = getPairsCount(arr, N, K);
        System.out.println("count ="+count);
    }
}
