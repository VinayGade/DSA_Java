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

        int n=s.length();
        //correct output
        int[][] lps = longestPalindromeSubsequence(s);
        int lpsLength = lps[0][n - 1];
        System.out.println("|LPS| is "+lpsLength);

        String LPS = findLPS(s, lps, n);
        System.out.println("LPS is "+LPS);
    }

    static int longestPalindromeSubseq(String s) {

        char[] X = s.toCharArray();
        char[] Y = new StringBuffer(s).reverse().toString().toCharArray();
        int m = X.length;
        //int n = Y.length;   ... | X | == | Y | = m
        int[][] lps = LPS(X, Y, m);
        return lps[m][m];
    }

    //2D - DP
    static int[][] LPS(char[] X, char[] Y, int m){
        int[][] L = new int[m+1][m+1];
        for(int j=0; j<m; j++){
            for(int k=0; k<m; k++){
                if(X[j] == Y[k] && j != k)   //...if (j==k) : already visited character
                    L[j+1][k+1] = L[j][k]+1;
                else
                    L[j+1][k+1] = Math.max(L[j][k+1], L[j+1][k]);
            }
        }
        return L;
    }

    // optimized solution: : 2D DP
    static int[][] longestPalindromeSubsequence(String s) {
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
        return dp;
    }

    // find longest palindromic subsequence
    static String findLPS(String s, int[][] dp, int n){
        StringBuilder lps = new StringBuilder();
        int start = 0, end = n - 1;

        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                lps.append(s.charAt(start));
                start++;
                end--;
            } else if (dp[start + 1][end] > dp[start][end - 1]) {
                start++;
            } else {
                end--;
            }
        }

        // Add the reverse of the first half to complete the palindrome
        String firstHalf = lps.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        // If the palindrome length is odd, the middle character should not be repeated
        if (firstHalf.length() + secondHalf.length() > dp[0][n - 1]) {
            return firstHalf + secondHalf.substring(1);
        }

        return firstHalf + secondHalf;
    }

    // Most Optimized for LPS length: 1D DP
    static int longestPalindromeSubsequence_1D_DP(String s) {
        int n = s.length();
        int[] prev = new int[n];
        int[] curr = new int[n];

        // Base case: single characters are palindromes
        for (int i = 0; i < n; i++) {
            curr[i] = 1;
        }

        // Fill the DP table for substrings of increasing length
        for (int len = 2; len <= n; len++) {
            // Swap arrays for next iteration
            prev = curr.clone();
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    curr[i] = prev[i + 1] + 2;
                } else {
                    curr[i] = Math.max(prev[i], curr[i + 1]);
                }
            }
        }

        return curr[0];
    }

}
