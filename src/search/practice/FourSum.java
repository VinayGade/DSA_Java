package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC 18: 4Sum
/*
4 Sum : Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

nums[], n, target
[nums[a], nums[b], nums[c], nums[d]] == target     ...0 <= a, b, c, d < n
return all such unique quadruplets

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
* */
public class FourSum {

    public static List<List<Integer>> fourSumOptimized(int[] nums, int target) {

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

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i>0 && nums[i]== nums[i-1])
                continue;

            for(int j=i+1; j<n; j++){
                if(j>(i+1) && nums[j]==nums[j-1])
                    continue;

                int start = j+1;
                int end = n-1;

                while(start < end){

                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[start];
                    sum += nums[end];

                    if(sum == target){

                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[start], nums[end]));
                        int low = nums[start];
                        int high = nums[end];
                        start++;
                        end--;

                        while(start < end && nums[start] == low)
                            start++;

                        while(start < end && nums[end] == high)
                            end--;
                    }else if(sum > target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int [] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        result.forEach(System.out::println);

        System.out.println("\n number of quadruples = "+result.size());

        List<List<Integer>> f4Sum = fourSumOptimized(nums, target);
        f4Sum.forEach(list -> {
            list.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
    }
}
