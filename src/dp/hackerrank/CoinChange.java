package dp.hackerrank;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoinChange {

    public static long getWays(int n, List<Long> c) {

        List<Long>  sortedCoins = c.stream().filter(coin -> coin <= n).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Long> memo = IntStream.range(0, n + 1).mapToLong(num -> 0).boxed().collect(Collectors.toCollection(ArrayList::new));
        memo.set(0, 1L);
        for (Long coin : sortedCoins) {
            for (int amount = 1; amount <= n; amount++) {
                if (coin <= amount) {
                    long result = memo.get(amount - coin.intValue()) + memo.get(amount);
                    memo.set(amount, result);
                } else {
                    memo.set(amount, 0L);
                }
            }
        }
        return memo.get(n);

    }

    public static long getWaysDP(int n, List<Long> c) {
        // Write your code here
        /*
            Time: O(n * c)
            Space: O(n * c)
            Thanks to: youtuber Back To Back SWE
        */

        int s = c.size();
        long[][] ways = new long[s + 1][n + 1];
        //This matrix has each row i represent for first ith elements in c be used
        //This matrix has each column j represent for subproblem j

        //When change for 0
        for(int i = 0; i <= s; i++){
            ways[i][0] = 1;
        }

        //When there is no coin to change
        for(int i = 1; i <= n; i++){
            ways[0][i] = 0;
        }

        //Calculate every subproblems before calculate the main solution
        //Each subproblem represent the amount of unique ways to solve.
        /*A problem can be divide into 2 separate cases:
         + When we just use first (i-1)th elements in c
         + When we use first ith elements in c for subproblem (j - coin)
         with coin is the value of ith elements in c
        */
        for(int i = 1; i <= s; i++){
            for(int j = 1; j <= n; j++){
                ways[i][j] = ways[i - 1][j];
                int x = j - (int)(long)c.get(i - 1);
                if(x >= 0)
                    ways[i][j] += ways[i][x];
            }
        }

        return ways[s][n];
    }

    public static void main(String[] args) {

    }
}
