package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
LeetCode 18:

4 Sum : Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

* */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) { // Ensure at least four numbers remain
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for the first number

            for (int j = i + 1; j < n - 2; j++) { // Ensure at least three numbers remain
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for the second number

                int p = j + 1, q = n - 1;
                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q]; // Use long to prevent overflow

                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                        // Skip duplicates for the third and fourth numbers
                        while (p < q && nums[p] == nums[p + 1]) p++;
                        while (p < q && nums[q] == nums[q - 1]) q--;

                        p++;
                        q--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> f4Sum = fourSum(nums, target);
        f4Sum.forEach(list -> {
            list.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
    }
}
