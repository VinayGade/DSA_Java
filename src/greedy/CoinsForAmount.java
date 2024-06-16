package greedy;

import java.util.Arrays;

public class CoinsForAmount {

    /*
    * Coins And Amount
    *
     Consider infinite supply of following value coins:

     coins = [10, 5, 2, 1]
     Amount = 52
     if Someone asks for an Amount, how will you give that amount using minimum coins ?

     in above case,
     * 52 = (5 * 10 + 1 * 2) = ( 5 coins of 10 Rs) + (1 coin of 2 Rs)
    *
    * */

    static int countCoins(int[] coins, int n, int amount){
        Arrays.sort(coins);
        int count = 0;
        for(int i=(n-1); i>=0; i--){
            if(amount==0)
                break;
            if(coins[i]<=amount){
                int c = (int)(amount/coins[i]);
                count = count+c;
                amount = amount - c * coins[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] coins = {10, 5, 2, 1};
        int amount = 52;
        int count = countCoins(coins, coins.length, amount);
        System.out.println("Total number of coins required = "+count);
    }
}
