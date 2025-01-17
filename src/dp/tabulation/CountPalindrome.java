package dp.tabulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*

Count palindromes

Each palindrome can be always created from the other palindromes,
if a single character is also a palindrome.
For example, the string "bobseesanna" can be created by some ways:
* bobseesanna = bob + sees + anna
* bobseesanna = bob + s + ee + s + anna
* bobseesanna = b + o + b + sees + a + n + n + a
...
We want to take the value of function CountPal(s) which is the number of
different ways to use the palindromes to create the string s by the above method.

input:
bobseesanna

output:
18
* */

public class CountPalindrome {

    // Constants
    private static final int MOD = 1000000007;

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        System.out.println(countPalindromicPartitions(s));
    }

    private static int countPalindromicPartitions(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];

        // Precompute palindromic substrings
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        // Fill DP array
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 1;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = (dp[i] + dp[j - 1]) % MOD;
                }
            }
        }

        return dp[n - 1];
    }
}
