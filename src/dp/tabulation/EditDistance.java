package dp.tabulation;

// LeetCode 72. Edit Distance

/*
Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.

Input: str1 = "geek", srt2 = "gesek"
Output: 1
Explanation: One operation is required, inserting 's' between two 'e'.

Input : str1 = "gfg", str2 = "gfg"
Output: 0
Explanation: Both strings are same.
* */

public class EditDistance {

    public static int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {

                if(i==0)
                    dp[i][j]=j;

                else if(j==0)
                    dp[i][j]=i;

                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }

    public static int editDistanceOptimized(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Cost of deleting all characters from word1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Cost of inserting all characters into word1
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If characters are the same, no new operation is needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Choose the minimum of three operations: replace, delete, insert
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                            Math.min(dp[i - 1][j], // Delete
                                    dp[i][j - 1])); // Insert
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        String word1 = "intention";
        String word2 = "execution";

        int distance = editDistance(word1, word2);

        System.out.println("Distance ="+distance);
    }
}