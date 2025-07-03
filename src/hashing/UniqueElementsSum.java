package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

/*

LC 1748. Sum of Unique Elements

You are given an integer array nums.
The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.

Example 1:

Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.
Example 3:

Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.

* */

public class UniqueElementsSum {

    public static int sumOfUnique(int[] nums) {
        int uniqueSum = 0;
        Map<Integer, Integer> map = elementFrequency(nums);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            if(entry.getValue() == 1)
                uniqueSum += entry.getKey();

        return uniqueSum;
    }

    public static Map<Integer, Integer> elementFrequency(int[] nums){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int c : nums)
            map.put(c, map.getOrDefault(c, 0) + 1);

        return map;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,2};

        int sum = sumOfUnique(nums);

        System.out.println(sum);
    }
}
