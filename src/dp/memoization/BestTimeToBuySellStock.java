package dp.memoization;

import java.util.List;

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

    public static int maxProfit(List<Integer> prices)
    {
        int n = prices.size();

        // 2D DP array to store max profit with 0 and 1
        // stocks
        int[][] dp = new int[n][2];

        dp[0][0] = -prices.get(0);
        dp[0][1] = 0;

        // Loop through prices to calculate max profit at
        // each day
        for (int i = 1; i < n; i++) {
            // choice 1: Buy the stock at i, in which case
            // the profit we get is the maximum profit we
            // could have made till i-1 minus the price at
            // i.
            dp[i][0]
                    = Math.max(dp[i - 1][0], -prices.get(i));

            // choice 2: Sell the stock at i, in which case
            // the profit we get is the maximum profit we
            // could have made till i-1 by buying the stock
            // earlier plus the price at i.
            dp[i][1] = Math.max(
                    dp[i - 1][1], dp[i - 1][0] + prices.get(i));
        }

        // Return the maximum profit calculated from the
        // last day
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {

        BestTimeToBuySellStock stock = new BestTimeToBuySellStock();

        int prices[] = {7,6,4,3,1};  // [7,6,4,3,1]  {7,1,5,3,6,4}
        int profit = stock.maxProfit(prices);

        System.out.println("profilt ="+profit);
    }
}
