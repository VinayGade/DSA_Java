package hashing;

import java.util.HashMap;
import java.util.Map;

/*
LeetCode 128: Longest Consecutive Sequence

Given an unsorted array of integers nums,
return the length of the longest consecutive elements sequence.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

* */

public class LongestConsecutiveSequence {

    static int longestConsecutive(int[ ] a){

        int longestLength = 0;
        Map<Integer, Boolean> visitor = new HashMap<>();

        for(int k: a){
            visitor.put(k, false);
        }

        for(int x: a){
            int maxLength = 1;
            // check in forward direction
            int next = x+1;
            while(visitor.containsKey(next) && !visitor.get(next)){
                maxLength++;
                visitor.put(next, true);
                // move to next number
                next++;
            }
            //check in reverse direction
            int prev = x-1;
            while(visitor.containsKey(prev) && !visitor.get(prev)){
                maxLength++;
                visitor.put(prev, true);
                // move to prev number
                prev--;
            }
            longestLength = Math.max(longestLength, maxLength);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int longestConsecutiveLength = longestConsecutive(nums);
        System.out.println("Length of longestConsecutive sequence = "+longestConsecutiveLength);
    }
}
