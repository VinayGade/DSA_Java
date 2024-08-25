package dp.memoization;

// CodeChef: Greedy Algorithms: K-Flip

import java.io.PrintWriter;
import java.util.Scanner;

public class KFlip {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int dp[] = new int[n + 1];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0)
                    dp[i] ^= dp[i - 1];
                int d = dp[i] ^ (s.charAt(i) - '0');
                if (d == 1 && i + k <= n) {
                    dp[i] ^= 1;
                    dp[i + k] ^= 1;
                    sb.append(0);
                } else
                    sb.append(d);
            }
            out.println(sb.toString());
        }
        out.close();
    }
}
