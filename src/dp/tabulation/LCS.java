package dp.tabulation;

// LCS = Longest Common Subsequence
public class LCS {

    // method 1 : Recursion ...Overlapping Sub-problems ...O(2^N)
    public int lengthLCS( char[] s1, char[] s2, int m, int n){

        if(m==0 || n==0)
            return 0;
        else if(s1[m-1] == s2[n-1])
            return 1 + lengthLCS(s1, s2, m-1, n-1);
        else
            return Math.max(
                    lengthLCS(s1, s2, m-1, n),
                    lengthLCS(s1, s2, m, n-1));
    }

    // method 2 : Tabulation ...Top-Down DP ...O(MN)
    public int lcsDP( char[] X, char[] Y, int m, int n){
        int L[][] = new int[m+1][n+1];

        for(int i=0; i<=m; i++)
            L[i][0] = 0;

        for(int j=0; j<=n; j++)
            L[0][j] = 0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(X[i-1] == Y[j-1])
                    L[i][j] = 1 + L[i-1][j-1];
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    // Reference: DSA in Java : Goodrich
    /* Returns table such that L[j][k] is length of LCS for X[0..j−1] and Y[0..k−1]. */
    public int[][] LCS(char[] X, char[] Y, int m, int n) {

        int[][] L = new int[m+1][n+1];
        for (int j=0; j < m; j++)
            for (int k=0; k < n; k++)
                if (X[j] == Y[k])  // align this match
                    L[j+1][k+1] = L[j][k] + 1;
                else                // choose to ignore one character
                    L[j+1][k+1] = Math.max(L[j][k+1], L[j+1][k]);
        return L;
    }

    /* Returns the longest common substring of X and Y, given LCS table L. */
    public String reconstructLCS(char[] X, char[] Y, int[][] L) {

        StringBuilder solution = new StringBuilder();
        int j = X.length;
        int k = Y.length;
        while (L[j][k] > 0)          // common characters remain
            if (X[j-1] == Y[k-1]) {
                solution.append(X[j - 1]);
                j--;
                k--;
            }else if(L[j-1][k] >= L[j][k-1])
                j--;
            else
                k--;

        // return left-to-right version, as String
        return solution.reverse().toString();
    }

    // memory efficient : better space complexity O(N)
    public int lcsOptimized(String X, String Y) {
        int[] L = new int[Y.length()+1];
        int n = L.length;
        for(int i = 0; i< X.length(); i++){
            int prev = L[0];
            for(int j = 1; j < n; j++){
                int temp = L[j];
                if(X.charAt(i) != Y.charAt(j-1))
                    L[j] = Math.max(L[j-1], L[j]);
                else
                    L[j] = prev +1;
                prev = temp;
            }
        }
        return L[n-1];
    }

    public static void main(String[] args) {

        // 2 DNA Sequences

        String str1="GTTCCTAATA";     //   AXYZ
        String str2="CGATAATTGAGA";   //   BAZ

        String str3="GTTCCTAATAATGCATGC";     //   AXYZ
        String str4="CGATAATTGAGAAT";

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        LCS lcs = new LCS();

        int lcsLength = lcs.lengthLCS(s1, s2, s1.length, s2.length);

        int lcsDpLength = lcs.lcsDP(s1, s2, s1.length, s2.length);

        int lcsDpLengthOptimized = lcs.lcsOptimized(str1, str2);

        int[][] table = lcs.LCS(s1, s2, s1.length, s2.length);

        String longestCommonSubsequence = lcs.reconstructLCS(s1, s2, table);

        System.out.println("String1 ="+str1);
        System.out.println("String2 ="+str2);
        System.out.println("Length of Longest Common Subsequence = "+lcsLength);
        System.out.println("Length of LCS using DP Tabulation    = "+lcsDpLength);
        System.out.println("Length of LCS using DP Optimized Tabulation = "+lcsDpLengthOptimized);

        System.out.println("Longest Common Subsequence = "+longestCommonSubsequence);
    }
}
