package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode 90: Subsets II (subsets without duplicates)

/*
Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]
* */
public class SubsetsII {

    // Subsets without duplicates

    static List<List<Integer>> subsetsWithoutDup(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        //start backtracking from beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    static void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums,
                          int start){

        if(resultSets.contains(tempSet))
            return;

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

    // Optimised approach to generate the correct result
    static List<List<Integer>> subsetsWithoutDuplicates(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        // Sort the array to handle duplicates
        Arrays.sort(nums);

        // Start backtracking from the beginning
        backtracking(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    static void backtracking(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {
        // Add the current subset to the result set
        resultSets.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Include the current number
            tempSet.add(nums[i]);

            // Backtrack to generate further subsets
            backtrack(resultSets, tempSet, nums, i + 1);

            // Exclude the current number (backtrack)
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,2};
        List<List<Integer>> output = subsetsWithoutDuplicates(nums);
        for(List<Integer> subset : output){
            System.out.println(subset);
        }
    }
}