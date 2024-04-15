package greedy;

//LeetCode 55 (Medium): Jump Game
/*
You are given an integer array nums.
You are initially positioned at the array's first index, and
each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what.
Its maximum jump length is 0, which makes it impossible to reach the last index.
* */
public class JumpGame {

    public static boolean canJump(int[] nums) {

        // Initially the final position is the last index
        int finalPosition = nums.length - 1;

        // Start with the second last index
        for (int idx = nums.length - 2; idx >= 0; idx--) {

            // If you can reach the final position from this index
            // update the final position flag
            if (idx + nums[idx] >= finalPosition) {
                finalPosition = idx;
            }
        }

        // If we reach the first index, then we can
        // make the jump possible
        return finalPosition == 0;
    }

    // 45. Jump Game II
    /*
    * Return the minimum number of jumps to reach nums[n - 1].
    * The test cases are generated such that you can reach nums[n - 1].
    *
    * ex:
    int[] nums = {2,4,1,2,3,1,1,2};  output = 3
               = [2,3,1,1,4]         output = 2
    * */
    public static int jump(int[] nums) {

        int totalJumps = 0;
        int coverage = 0;
        int lastJumpIndex = 0;
        int destination = nums.length - 1;

        if(nums.length == 0)
            return 0;

        for(int i=0; i<nums.length; i++){
            coverage = Math.max(coverage, i+nums[i]);

            if(i==lastJumpIndex) {
                lastJumpIndex = coverage;
                totalJumps++;

                if(coverage>=destination)
                    return totalJumps;
            }
        }
        return totalJumps;
    }

    public static void main(String[] args) {

        int[] nums = {2,4,1,2,3,1,1,2};  // [2,3,1,1,4]
        boolean result = canJump(nums);
        System.out.println("can jump to final position ?"+result);

        int minJumpsTillDestination = jump(nums);
        System.out.println("Minimum jumps to reach the final position ?"+minJumpsTillDestination);
    }
}
