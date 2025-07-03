package dp.tabulation;

// LeetCode 714. Best Time to Buy and Sell Stock with Transaction Fee
/*

You are given an array prices where prices[i] is the price of a given stock on the ith day, and
an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like,
but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before
you buy again).
The transaction fee is only charged once for each stock purchase and sale.

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
* */

public class BestTimeToBuySellStockFees {

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0; // profit on day 0 with no stock
        dp[0][1] = -prices[0]; // profit on day 0 with one stock

        for(int i=1; i<n; i++){

            // Sell the stock
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);

            // Buy the stock
            dp[i][1] = Math.max(dp[i-1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,3,7,5,10,3};
        int fees = 3;
        int profit = maxProfit(prices, fees);
        System.out.println(profit);
    }
}
