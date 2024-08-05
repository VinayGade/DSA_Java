package dp.memoization;

import java.util.Arrays;

//LeetCode 121 Easy: Best Time to Buy and Sell Stock
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices){

        if(prices.length == 1)
            return 0;

        //int profit = 0;     // profit = sell - buy
        //int buy, sell = 0;
        int min=0;           // index (buy)
        int max=1;           // index (sell)

        int buy = prices[min];
        int sell = prices[max];

        //int maxProfit = prices[prices.length-1]-buy;

        int profit = sell-buy;
        int maxProfit = profit;

        for(int i=1; i<prices.length; i++){
            if(prices[i]<buy && i<prices.length-1){
                buy=prices[i];
                min=i;
                //max=i+1;
                sell = prices[i+1];
            }
            if(prices[i]>=sell && i>min){
                sell = prices[i];
                max=i;
            }
            profit = sell-buy;
            if(profit>=maxProfit)
                maxProfit = profit;
        }
        if(sell > buy) {
            //profit = sell - buy;
            return maxProfit;
        }else return 0;
        //return profit;
    }

    public int maxProfitMemoization(int[] prices){
        // at the beginning the minimum price is the first price
        int buy_price = prices[0];

        // at the beginning the minimum  profit is zero
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            // if the current price is less update the buy_price
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            }
            else {
                // else check if we can get a better profit
                int current_profit = prices[i] - buy_price;
                profit = Math.max(current_profit, profit);
            }
        }

        return profit;
    }

    //LeetCode 122 Medium: Best Time to Buy and Sell Stock II
    public int maxProfitTablulation(int[] prices) {
        if(prices.length==0)
            return 0;
        int result = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                result += prices[i]-prices[i-1];
            }
        }
        return result;
    }

    public int maxProfitDP(int[] prices) {

        int n = prices.length;

        int[] prev = new int[2];

        prev[0] = 0;
        prev[1] = 0;

        int profit = 0;

        for(int i=n-1; i>=0; i--){
            int[] cur = new int[2];

            for(int j=1; j>=0; j--){

                if(j==0)
                    profit = Math.max(0+prev[0], -prices[i] + prev[1]);

                if(j==1)
                    profit = Math.max(0+prev[1], prices[i] + prev[0]);
                cur[j] = profit;
            }
            prev = cur;
        }
        return prev[0];
    }

    //DP - Tabulation

    public int maxProfit(int[] prices, int n) {

        int[][] dp = new int[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        int profit = 0;

        for(int i = n-1; i>=0; i--){

            for(int j=0; j<=1; j++){

                if(j==0){
                    profit = Math.max(0 + dp[i+1][0], -prices[i]+dp[i+1][1]);
                }
                if(j==1){
                    profit = Math.max(0 + dp[i+1][1], prices[i]+dp[i+1][0]);
                }

                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }

    //DP - Memoization

    public int maxProfit(int n, int[] prices) {

        int[][] dp = new int[n][2];

        for(int[] i: dp)
            Arrays.fill(i, -1);

        return solve(0, n, 0, prices, dp);
    }

    public int solve(int index, int n, int buy, int[] prices, int[][] dp){

        if(index == n)
            return 0;

        if(dp[index][buy] != -1)
            return dp[index][buy];

        int profit = 0;

        if(buy == 0){
            profit = Math.max( (0 + solve ((index + 1), n, 0, prices, dp)) ,
                    (-prices[index] + solve(index + 1, n, 1, prices, dp)) );
        }

        if(buy == 1){

            profit = Math.max( (0 + solve ((index + 1), n, 1, prices, dp)) ,
                    (prices[index] + solve(index + 1, n, 0, prices, dp)) );
        }
        return dp[index][buy] = profit;
    }

    public static void main(String[] args) {

        BestTimeToBuySellStock stock = new BestTimeToBuySellStock();

        int prices[] = {7,6,4,3,1};  // [7,6,4,3,1]  {7,1,5,3,6,4}

        int n = prices.length;

        int profit = stock.maxProfit(prices, n);

        System.out.println("profilt ="+profit);
    }
}
