package backtracking;

import java.util.ArrayList;
import java.util.List;

/*

LeetCode 78: Subsets

Given an integer array nums of unique elements, return all possible
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

* */

public class Subsets {

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        //start backtracking from beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    static void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums,
                   int start){

        //Add the set to result set
        resultSets.add(new ArrayList<>(tempSet));
        for(int i=start; i<nums.length; i++){

            //including number
            tempSet.add(nums[i]);

            //backtrack the new subset
            backtrack(resultSets, tempSet, nums, i+1);

            //not including number
            tempSet.remove(tempSet.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> output = subsets(nums);
        for(List<Integer> subset : output){
            System.out.println(subset);
        }
    }
}
