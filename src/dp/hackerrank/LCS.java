package dp.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LCS {

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {

        Integer[] X = a.toArray(new Integer[0]);
        Integer[] Y = b.toArray(new Integer[0]);
        int m = a.size();
        int n = b.size();
        int L[][] = lcsTable(X, Y, m, n);
        Stack<Integer> lcs = reconstructLCS(X, Y, L);
        List<Integer> LCS = new ArrayList<>();

        while(!lcs.isEmpty()){
            LCS.add(lcs.pop());
        }
        return LCS;
    }

    // Reference: DSA in Java : Goodrich
    /* Returns table such that L[j][k] is length of LCS for X[0..j−1] and Y[0..k−1]. */
    public static int[][] lcsTable(Integer[] X, Integer[] Y, int m, int n) {

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
    public static Stack<Integer> reconstructLCS(Integer[] X, Integer[] Y, int[][] L) {

        //StringBuilder solution = new StringBuilder();
        Stack<Integer> solution = new Stack<>();
        int j = X.length;
        int k = Y.length;
        while (L[j][k] > 0)          // common characters remain
            if (X[j-1] == Y[k-1]) {
                //solution.append(X[j - 1]).append(" ");
                solution.push(X[j - 1]);
                j--;
                k--;
            }else if(L[j-1][k] >= L[j][k-1])
                j--;
            else
                k--;

        // return left-to-right version, as String
        //return solution.reverse().toString().trim();
        return solution;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 6;
        /*
        Input:
        5 6
        1 2 3 4 1
        3 4 1 2 1 3

        Output:
        1 2 3
        * */

        List<Integer> a = Arrays.asList(1, 2, 3, 4, 1);
        List<Integer> b = Arrays.asList(3, 4, 1, 2, 1, 3);

        List<Integer> lcs = longestCommonSubsequence(a, b);

        lcs.forEach(x->System.out.print(x+" "));
    }
}
