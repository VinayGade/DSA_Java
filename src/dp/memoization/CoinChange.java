package dp.memoization;

// LeetCode 322. Coin Change

/*
You are given an integer array coins representing coins of different denominations and
an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
* */
public class CoinChange {

    static int coinChange(int[] coins, int amount){
        if(amount < 0)
            return 0;

        int[] minCoinsDP = new int[amount + 1];

        for(int i=1; i<=amount; i++) {

            minCoinsDP[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE)
                    minCoinsDP[i] = Math.min(minCoinsDP[i - coin] + 1, minCoinsDP[i]);
            }
        }
        if(minCoinsDP[amount] == Integer.MAX_VALUE)
            return -1;

        return minCoinsDP[amount];
    }

    public static void main(String[] args) {
        // case 1
        int amount = 11;
        int[] coins ={1, 5, 6, 9};

        int minCount = coinChange(coins, amount);
        System.out.println("amount ="+amount);
        System.out.println("minimum number of coins to make up that amount ="+minCount);
    }
}