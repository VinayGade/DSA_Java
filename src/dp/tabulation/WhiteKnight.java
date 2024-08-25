package dp.tabulation;

// CodeChef: Dynamic Programming

import java.util.Arrays;
import java.util.Scanner;

/*

You are given a chessboard of size NxN. There is a white knight and several black pawns
located on the board.
The knight can move similarly to the normal knight in the game of chess;
however it can only move towards the right of the board
The mission of the knight is to capture as many black pawns as possible.
Its journey ends when it moves to the rightmost column of the board.

Compute the maximum number of black pawns the white knight can capture.

Input
The first line contains t, the number of test cases (about 10). Then t test cases follow.

Each test case has the following form:
1. The first line contains N, the size of the chessboard. 4 <= N <= 1000
2. Then N lines follow, each line containing N characters which may be '.', 'K' or 'P',
corresponding to the empty cell, the white knight, and the black pawn, respectively.
There is exactly one 'K' character in the whole of the board.

Output
For each test case, print in a single line the maximum number of black pawns that can be captured.

Input
1
5
K....
..P..
.P...
...P.
.....

Output:
2
* */
public class WhiteKnight {

    public static int dfs(int i, int j, int n, int dp[][], String s[]) {

        if (i < 0 || j < 0 || i >= n || j >= n)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int num = (s[i].charAt(j) == 'P') ? 1 : 0;

        return dp[i][j] = num +
                Math.max(Math.max(dfs(i - 2, j + 1, n, dp, s),
                                dfs(i - 1, j + 2, n, dp, s)),
                        Math.max(dfs(i + 1, j + 2, n, dp, s),
                                dfs(i + 2, j + 1, n, dp, s)));
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            Character board[][] = new Character[n][n];

            String s[] = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.next();
            }

            int dp[][] = new int[n][n];
            for (int a[]: dp)
                Arrays.fill(a, -1);


            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (s[i].charAt(j) == 'K') {
                        ans = dfs(i, j, n, dp, s);
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
