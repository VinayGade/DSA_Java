package hashing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

//LeetCode 503. Next Greater Element II
/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next
in the array, which means you could search circularly to find its next greater number.
If it doesn't exist, return -1 for this number.

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]

* */
public class NextGreaterElementII {

    //using stack
    static int[] nextGreaterElements(Integer[] nums) {

        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1); // difference!!!
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n)
                stack.push(i);
        }
        // no polling all nodes in stack and set max's greater element to be -1
        // because of the difference!!!
        return next;
    }

    // most optimized solution
    static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>(); // to store idx
        for(int i = 0; i < 2 * n; i++){
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peekFirst()]){
                int idx = stack.pollFirst();
                res[idx] = num;
            }
            if(i < n) stack.offerFirst(i);
        }
        // set the max's greater element to be -1
        while(!stack.isEmpty()){
            int idx = stack.pollFirst();
            res[idx] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] nextGreater = nextGreaterElements(nums);
        for (int x : nextGreater)
            System.out.println(x);
    }
}
