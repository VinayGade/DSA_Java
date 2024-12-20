package backtracking;

import java.util.ArrayList;
import java.util.List;

/*LeetCode 46:

Given an array nums of distinct integers, return all the possible
permutations
return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

* */

public class Permutations {
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int num: nums){
            if(tempList.contains(num))
                continue;
            tempList.add(num);
            backtrack(result, tempList, nums);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // char[] chars = {'a','b','c'};

        List<List<Integer>> permutations = permute(nums);
        for(List<Integer> list: permutations){
            System.out.println(list);
        }
    }
}
