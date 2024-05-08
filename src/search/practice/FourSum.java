package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC 18: 4Sum
/*
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
    }
}
