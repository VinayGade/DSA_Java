package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode 47: Permutations II (Permutations without duplicates)

/*

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

* */
public class PermutationsII {

    static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList,
                          int[] nums, boolean[] used){
        if(tempList.size()==nums.length && !result.contains(tempList)){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            //skip if we get same element
            if(used[i])
                continue;

            //Add new element and mark it as used.
            used[i] = true;

            tempList.add(nums[i]);
            backtrack(result, tempList, nums, used);

            //remove the element and mark it unused.
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> uniquePermutations = permuteUnique(nums);
        for(List<Integer> list: uniquePermutations){
            System.out.println(list);
        }
    }
}
