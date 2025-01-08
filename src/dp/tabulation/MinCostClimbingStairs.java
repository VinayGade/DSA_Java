package dp.tabulation;

/*

LeetCode 746. Min Cost Climbing Stairs

You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
* */

public class MinCostClimbingStairs {

    // Bottom up tabulation - O(n)
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            if (i<2)
                dp[i] = cost[i];
            else
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

    // Bottom up computation - O(n) time, O(1) space

    // Optimization  - Fine Tuning - Reduce O(n) space to O(1).
    public int minCostClimbingStairs_Optimized(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n<=2) return Math.min(first, second);
        for (int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int minCost = minCostClimbingStairs(cost);
        System.out.println(minCost);
    }

}
