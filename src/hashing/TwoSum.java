package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

/*
LeetCode 1 : Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
* */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new LinkedHashMap<>();

        // map.key = nums[i]. .. arr value,  map.value = index

        int[] result=new int[2];
        for(int i=0;i<n;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){

                // if difference found we obtained soln

                result[1]=i;
                result[0]=map.get(diff);  // index of diff
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int result[] = twoSum(nums, target);
    }
}
