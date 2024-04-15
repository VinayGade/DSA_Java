package array.math;

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

    public static void main(String[] args) {

        BestTimeToBuySellStock stock = new BestTimeToBuySellStock();

        int prices[] = {7,6,4,3,1};  // [7,6,4,3,1]  {7,1,5,3,6,4}
        int profit = stock.maxProfit(prices);

        System.out.println("profilt ="+profit);
    }
}
