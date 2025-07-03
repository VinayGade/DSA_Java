package dp.memoization;

// LeetCode 518. Coin Change II (Count Ways)
/*
Given an integer array coins[ ] representing different denominations of currency and sum,
find the number of ways you can make sum by using different combinations from coins[ ].
Note: Assume that you have an infinite supply of each type of coin.
Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer.

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].

Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].

Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.

* */

public class CoinChangeII {

    public int count(int coins[], int amount) {

        return solve(0, coins, amount);
    }

    int solve(int i, int[] coins, int amount){
        int n = coins.length;
        if(amount == 0){
            return 1;
        }
        if(i == n){
            return 0;
        }
        if(coins[i] > amount){
            return solve(i+1, coins, amount);
        }
        int take = solve(i, coins, amount-coins[i]);
        int skip = solve(i+1, coins, amount);

        return take+skip;
    }

    // Memoization
    public int change(int sum, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n][sum+1];
        for(int i =0; i <= sum; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= sum; j++) {
                int notTake = dp[i -1][j];
                int take = 0;
                if(coins[i] <= j) {
                    take = dp[i][j - coins[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        CoinChangeII coinChange = new CoinChangeII();

        int coins[] = {2, 5, 3, 6};
        int amount = 10;

        System.out.println("using Recursion:");
        int ways = coinChange.count(coins, amount);

        System.out.println(ways);

        System.out.println("using Dynamic Programming : Memoization:");
        ways = coinChange.count(coins, amount);

        System.out.println(ways);
    }
}
