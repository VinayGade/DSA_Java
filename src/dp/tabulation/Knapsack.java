package dp.tabulation;

public class Knapsack {

    /*
     Capacity of Volume (Weight) = 10
     Value (cost) V[] = {10, 40, 30, 50}
     Weight       W[] = {5, 4, 6, 3}

     Weight W = 50
     w[] = {10, 20, 30}
     v[] ={60, 100, 120}
    * */


    // recursion  ... O(2^n)

    int knapSack(int W, int w[], int[] v, int n) {

        if (n == 0 || W == 0)
            return 0;

        if (w[n - 1] > W)
            return knapSack(W, w, v, n - 1);

        else
            return Math.max(knapSack(W, w, v, n - 1),
                    v[n - 1] + knapSack(W - w[n - 1], w, v, n - 1));

    }

    int knapSack01(int W, int[] w, int[] v, int n) {

        int dp[][] = new int[n + 1][W + 1];
        //0th row
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        //0th Column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {

    }
}
