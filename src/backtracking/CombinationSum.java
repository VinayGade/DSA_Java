package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
LC 39: Combination Sum
LC 40: Combination Sum II (without duplicates)
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that
sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

* */

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    static void backTrack(int cand[], int start, int target, List<Integer> list, List<List<Integer>> result){
        if(target < 0)
            return;
        if(target == 0)
            result.add(new ArrayList<Integer>(list));
        for(int i = start; i < cand.length; i++){
            list.add(cand[i]);
            backTrack(cand, i, target-cand[i], list, result);
            list.remove(list.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    static void backTrack2(int cand[], int start, int target, List<Integer> list, List<List<Integer>> result){
        if(target < 0)
            return;
        else if(target == 0)
            result.add(new ArrayList<Integer>(list));
        else{
            for(int i = start; i < cand.length; i++){
                if(i>start && cand[i] == cand[i-1])
                    continue; // skip duplicates
                list.add(cand[i]);
                backTrack(cand, i+1, target-cand[i], list, result);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        List<List<Integer>> distinctResult = combinationSum2(candidates, target);
        result.forEach(System.out::println);
    }
}
