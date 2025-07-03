package hashing;

import java.util.*;

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

    /*
2 - sum on List

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not
zero-based. Put both these numbers in order in an array and return the array from your function
( Looking at the function signature will make things clearer ).
Note that, if no pair exists, return an empty list.

If multiple solutions exist, output the one where index2 is minimum.
If there are multiple solutions with the minimum index2, choose the one with minimum index1
out of them.

Example Input
A: [2, 7, 11, 15]
B: 9

Example Output
[1, 2]
    * */

    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {

        ArrayList<Integer> terms = new ArrayList<>();

        Map<Integer,Integer> map=new HashMap<>();

        int n = A.size();

        for(int i=0; i<n; i++){
            int diff = B - A.get(i);
            if(map.containsKey(diff)){
                terms.add(map.get(diff));
                terms.add(i+1);
                break;
            }
            else{
                if(map.containsKey(A.get(i))){
                    continue;
                }
                else{
                    map.put(A.get(i),(i+1));
                }
            }
        }
        return terms;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int result[] = twoSum(nums, target);

        List<Integer> A = Arrays.asList(2, 7, 11, 15);
        int B = 9;

        List<Integer> pair = twoSum(A, B);
        for(int x: pair){
            System.out.println(x);
        }
    }
}
