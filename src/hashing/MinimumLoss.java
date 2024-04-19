package hashing;

import java.util.*;

//HackerRank : Algorithms > Search > Minimum Loss

/*
Lauren has a chart of distinct projected prices for a house over the next several years.
She must buy the house in one year and sell it in another, and she must do so at a loss.
She wants to minimize her financial loss.

eg.
[20, 15, 8, 2, 12]   output: 3   ...15-12=3
*
* */
public class MinimumLoss {

    public static int minimumLoss(List<Long> price) {

        Map<Long, Integer> priceIndexMap = new HashMap<>();
        for(int i=0; i<price.size(); i++)
            priceIndexMap.put(price.get(i), i);

        Collections.sort(price);

        long minLoss = Long.MAX_VALUE;

        for(int j=price.size()-1; j>0; j--){

            //rejecting invalid values
            if(priceIndexMap.get(price.get(j))>
                    priceIndexMap.get(price.get(j-1)))
                continue;
            long loss = price.get(j) - price.get(j-1);
            minLoss = Math.min(loss, minLoss);
        }
        return (int)minLoss;
    }

    public static void main(String[] args) {

        List<Long> prices = Arrays.asList(20L, 15L, 8L, 2L, 12L);
        int minLoss = minimumLoss(prices);
        System.out.println("Minimum Loss="+minLoss);
    }
}
