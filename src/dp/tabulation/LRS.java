package dp.tabulation;

// Longest Repeating Subsequence
/*

Given a string s, the task is to find the length of the longest repeating subsequence,
such that the two subsequences don’t have the same string character at the same position,
i.e. any ith character in the two subsequences shouldn’t have the same index in the original string.

Input: s= “abc”
Output: 0
Explanation: There is no repeating subsequence

Input: s= “aab”
Output: 1
Explanation: The two subsequence are ‘a'(0th index) and ‘a'(1th index).
Note that ‘b’ cannot be considered as part of subsequence as it would be at same index in both.
* */

public class LRS {

    //Tabulation
    static int longestRepeatingSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                // If char match and indices
                // are different
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    // time and space efficient solution
    static int longestRepeatingSubsequence_Optimised(String s) {

        // Get the length of the input string
        int n = s.length();

        // Create a 1D array to store the current row's
        // values
        int[] curr = new int[n + 1];

        // Variable to store the value of dp[i-1][j-1]
        // (diagonal element)
        int match;

        // Iterate over all characters of the string for row
        // index
        for (int i = 1; i <= n; i++) {

            // Reset match for each new row
            match = 0;

            // Iterate over all characters of the string for
            // column index
            for (int j = 1; j <= n; j++) {

                // Temporarily store the current cell value
                // before updating it
                int tmp = curr[j];

                // If characters match and indices are
                // different, update with diagonal value + 1
                if (s.charAt(i - 1) == s.charAt(j - 1)
                        && i != j) {
                    curr[j] = 1 + match;
                }
                else {
                    // Otherwise, take the maximum of the
                    // left and top cells
                    curr[j]
                            = Math.max(curr[j], curr[j - 1]);
                }

                // Update match to the previously stored
                // value of curr[j]
                match = tmp;
            }
        }

        // Return the value in the last cell, which contains
        // the length of the longest repeating subsequence
        return curr[n];
    }

    public static void main(String[] args) {

    }
}
