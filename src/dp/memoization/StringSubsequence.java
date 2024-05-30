package dp.memoization;

import java.util.Arrays;
/*
GFG: POTD: String Subsequence
Given two strings, s1 and s2, count the number of subsequences of string s1 equal to string s2.
Return the total count modulo 1e9+7.

Input:
s1 = geeksforgeeks
s2 = gks
Output:
4
Explaination:
We can pick characters from s1 as a subsequence from indices {0,3,4},{0,3,12},{0,11,12},{8,11,12}.
So total 4 subsequences of s1 that are equal to s2.

Input:
s1 = problemoftheday
s2 = geek
Output:
0
Explaination:
No subsequence of string s1 is equal to string s2.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function countWays() which takes
the string s1 and s2 as input parameters and
returns the number of subsequences of s1 equal to s2.

Expected Time Complexity: O(n*m)  [n and m are lengths of the strings s1 and s2]
Expected Auxiliary Space: O(n*m)  [n and m are lengths of the strings s1 and s2]

1 ≤ n, m ≤ 500  [n and m are lengths of the strings s1 and s2]
* */
public class StringSubsequence {
    public static int countWays(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] a: dp)
            Arrays.fill(a, -1);
        return helper(0, 0, s1, s2, dp);
    }

    // old helper function
    static int f(int x, int y, String s1, String s2, int[][] dp){

        if(y>=s2.length())
            return 1;
        if(x>=s1.length())
            return 0;

        if(s1.charAt(x) == s2.charAt(y)){
            return dp[x][y] = (f(x+1, y, s1, s2, dp) +
                    f(x+1, y+1, s1, s2, dp)) % 1000000007;
        }else
            return dp[x][y] = f(x+1, y, s1, s2, dp) % 1000000007;
    }

    static int helper(int x, int y, String s1, String s2, int[][] dp){

        if(x == s1.length() && y == s2.length())
            return 1;
        if(y>=s2.length())
            return 1;
        if(x>=s1.length())
            return 0;
        if(dp[x][y] != -1)
            return dp[x][y];

        if(s1.charAt(x) == s2.charAt(y)){
            return dp[x][y] = (helper(x+1, y+1, s1, s2, dp) +
                    helper(x+1, y, s1, s2, dp)) % 1000000007;
        }else
            dp[x][y] = helper(x+1, y, s1, s2, dp) % 1000000007;
        return dp[x][y];
    }


    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "gks";     // "geek"
        int count = countWays(s1, s2);
        System.out.println(count);
    }
}
