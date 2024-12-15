package dp.tabulation;

//LeetCode 516: Longest Palindromic SubSequence

/*
Given a string S find the longest palindromic subsequence's length in S.

A subsequence is a sequence that can be derived from another sequence by deleting some
or no elements without changing the order of the remaining elements.

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
* */
public class LPS {

    public static void main(String[] args) {
        String s = "ABDCBTAP";  //cbbd  //ABDCBTAP  //bbbab
        int length = longestPalindromeSubseq(s);
        System.out.println("|LPS| = "+length);
    }

    static int longestPalindromeSubseq(String s) {

        char[] X = s.toCharArray();
        char[] Y = new StringBuffer(s).reverse().toString().toCharArray();
        int m = X.length;
        int n = Y.length;
        int[][] lps = LPS(X, Y, m, n);
        return lps[m][n];
    }

    static int[][] LPS(char[] X, char[] Y, int m, int n){
        int[][] L = new int[m+1][n+1];
        for(int j=0; j<m; j++){
            for(int k=0; k<n; k++){
                if(X[j] == Y[k] && j != k)   //...if (j==k) : already visited character
                    L[j+1][k+1] = L[j][k]+1;
                else
                    L[j+1][k+1] = Math.max(L[j][k+1], L[j+1][k]);
            }
        }
        return L;
    }

    // optimized solution
    public int longestPalindromeSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the DP table for substrings of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // Result is in dp[0][n-1]
        return dp[0][n - 1];
    }
}
