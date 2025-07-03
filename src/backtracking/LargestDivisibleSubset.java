package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestDivisibleSubset {

    /*
    Largest Divisible Subset:

   Given an array arr[] of positive integers. Your task is to find the largest subset
   such that for every pair of elements (x, y) in the subset,
   either x divides y or y divides x.

    Note : If multiple subsets of the same maximum length exist,
    return the one that is lexicographically greatest,
    after sorting the subset in ascending order.
    
    * */

     /*
    public ArrayList<Integer> largestSubset(int[] arr) {

        int n = arr.length;

        Arrays.sort(arr);

        ArrayList<Integer> divisibleSubset = new ArrayList<Integer>();

        divisibleSubset.add(arr[0]);

        int divisor = 2;

        for(int i=1; i<n; i++){
            if(arr[i] % divisor == 0){
                divisibleSubset.add(arr[i]);
                divisor = arr[i];
            }
        }
        return divisibleSubset;
    }*/

    static HashMap<String, ArrayList<Integer>> memo = new HashMap<>();

    static ArrayList<Integer> helper(int[] arr, int i, int prevEle) {
        if (i >= arr.length) return new ArrayList<>();

        String key = i + "-" + prevEle;
        if (memo.containsKey(key)) return memo.get(key);

        ArrayList<Integer> include = new ArrayList<>();
        if (arr[i] % prevEle == 0) {
            include = helper(arr, i + 1, arr[i]);
            include = new ArrayList<>(include);
            include.add(0, arr[i]);
        }

        ArrayList<Integer> exclude = helper(arr, i + 1, prevEle);
        ArrayList<Integer> result = (include.size() > exclude.size()) ? include : exclude;
        memo.put(key, result);
        return result;
    }

    static ArrayList<Integer> largestSubset(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> result = helper(arr, 0, 1);
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 16, 7, 8, 4};

        ArrayList<Integer> subset = largestSubset(arr);

        subset.forEach(System.out::println);
    }
}
