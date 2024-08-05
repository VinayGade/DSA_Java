package dp.hackerrank;

public class LCSReturns {

    public static int tutzkiAndLcs(String a, String b) {

        int answer = 0;
        int[][] direct = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                direct[i + 1][j + 1] = Math.max(direct[i + 1][j], direct[i][j + 1]);
                if (a.charAt(i) == b.charAt(j)) {
                    direct[i + 1][j + 1] = Math.max(direct[i + 1][j + 1], direct[i][j] + 1);
                }
            }
        }
        int[][] reverse = new int[a.length() + 1][b.length() + 1];
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                reverse[i][j] = Math.max(reverse[i + 1][j], reverse[i][j + 1]);
                if (a.charAt(i) == b.charAt(j)) {
                    reverse[i][j] = Math.max(reverse[i][j], reverse[i + 1][j + 1] + 1);
                }
            }
        }
        int target = direct[a.length()][b.length()];
        for (int i = 0; i <= a.length(); i++) {
            long was = 0;
            for (int j = 0; j < b.length(); j++) {
                if (direct[i][j] + reverse[i][j + 1] == target) {
                    was |= 1L << code(b.charAt(j));
                }
            }
            answer += Long.bitCount(was);
        }
        return answer;
    }

    private static int code(char c) {
        if (Character.isDigit(c)) {
            return c - '0';
        } else if (Character.isLowerCase(c)) {
            return c - 'a' + 10;
        } else {
            return c - 'A' + 36;
        }
    }

    // Reference: DSA in Java : Goodrich
    /* Returns table such that L[j][k] is length of LCS for X[0..j−1] and Y[0..k−1]. */
    public static int[][] lcsTable(char[] X, char[] Y, int m, int n) {

        int[][] L = new int[m+1][n+1];
        for (int j=0; j < m; j++)
            for (int k=0; k < n; k++)
                if (X[j] == Y[k])  // align this match
                    L[j+1][k+1] = L[j][k] + 1;
                else                // choose to ignore one character
                    L[j+1][k+1] = Math.max(L[j][k+1], L[j+1][k]);
        return L;
    }
}
