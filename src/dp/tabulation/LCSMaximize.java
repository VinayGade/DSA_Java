package dp.tabulation;

// CodeChef: Dynamic Programming

/*
Problem : Maximizing LCS

Alice and Bob are playing a game using a string S.  ... |S| = N
They both have their individual strings which are initially empty.

Both players take alternate turns. Alice starts first.
In Alice's turn, she will:

i.  Choose a prefix of S
ii. Remove the chosen prefix from S.
iii.Append the prefix to the end of her string.

In Bob's turn, he will:

i.  Choose a suffix of S
ii. Remove the chosen suffix from S
iii.Reverse the suffix and append it to the end of his string.

Chef has decided to reward them if the length of the Longest Common Subsequence (LCS)
of Alice's and Bob's strings is maximized.
Help Chef calculate the length of maximum LCS that can be achieved by Alice and Bob.

Note:
i.  A prefix is obtained by deleting some (possibly zero) elements from the end of the string.
ii. A suffix is obtained by deleting some (possibly zero) elements from the beginning of the string.
iii.Please use fast I/O for input and pypy for python submissions.

Input:
3
4
abab
6
abccda
4
aaaa

Output:
1
2
2

* */

import java.util.Scanner;

public class LCSMaximize {

    public static int maximizeLCS(String S, int N) {
        //Reverse String S
        String R = new StringBuilder(S).reverse().toString();

        //Compute LCS table
        int[][] LCS = lcsTable(S.toCharArray(), R.toCharArray(), N);

        //Find the max LCS length
        int maxLCS = 0;
        for (int i = 0; i <= N; i++)
            maxLCS = Math.max(maxLCS, LCS[i][N - i]);

        return maxLCS;
    }

    // Reference: DSA in Java : Goodrich
    /* Returns table such that L[j][k] is length of LCS for X[0..j−1] and Y[0..k−1]. */
    public static int[][] lcsTable(char[] X, char[] Y, int n) {

        int[][] L = new int[n + 1][n + 1];
        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++)
                if (X[j] == Y[k]) // align this match
                    L[j + 1][k + 1] = L[j][k] + 1;
                else // choose to ignore one character
                    L[j + 1][k + 1] = Math.max(L[j][k + 1], L[j + 1][k]);
        return L;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();

            String S = scanner.next();

            int max = maximizeLCS(S, N);

            System.out.println(max);
        }
        scanner.close();
    }
}