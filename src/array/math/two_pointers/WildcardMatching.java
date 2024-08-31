package array.math.two_pointers;

import java.util.Scanner;

// CodeChef: String: Chef and the Wildcard Matching

/*
Chef wants to implement wildcard pattern matching supporting only the wildcard '?'
The wildcard character '?' can be substituted by any single lower case English letter for matching.

He has two strings X and Y of equal length, made up of lower case letters and the character '?'.
He wants to know whether the strings X and Y can be matched or not.

Input:
2
s?or?
sco??
stor?
sco??

Output:
Yes
No

Given two strings pattern and str which may be of different size,
return if the wildcard pattern i.e. pattern, matches with str.
All characters of the string str and pattern always belong to the Alphanumeric characters.

The wildcard pattern can include the characters ? and *
‘?’ – matches any single character.
‘*’ – Matches any sequence of characters (including the empty sequence).

Input: pattern = "ba*a?", str = "baaabab"
Output: 1
Explanation: replace '*' with "aab" and
'?' with 'b'.

Input: pattern = "a*ab", str = "baaabab"
Output: 0
Explanation: Because in string pattern character 'a' at first position,
pattern and str can't be matched.
 */

public class WildcardMatching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String x = scanner.next();
            String y = scanner.next();

            String match = wildCardMatching(x, y) ? "Yes" : "No";
            System.out.println(match);


        }
    }

    static boolean wildCardMatching(String x, String y){

        char[] X = x.toCharArray();
        char[] Y = y.toCharArray();

        int N = X.length;
        if(N == 1)
            return x.equals(y);

        //2 - pointers
        int i = 0;
        int j = 0;
        while(i < N && j < N){
            if(X[i] != Y[j]){
                if(X[i] == '?')
                    X[i] = Y[j];
                else if(Y[j] == '?')
                    Y[j] = X[i];
                else
                    return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static boolean checkEqual(String x,String y){
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='?'||y.charAt(i)=='?'){
                continue;
            }
            else if(x.charAt(i)!=y.charAt(i)){
                return false;
            }
        }
        return true;
    }

    /*
    The wildcard pattern can include the characters ? and *
‘?’ – matches any single character.
‘*’ – Matches any sequence of characters (including the empty sequence).
    * */

    public boolean wildCard(String pattern, String str) {

        // Your code goes here
        int m = pattern.length();
        int n = str.length();

        // dp[i][j] will be true if the first i characters in pattern
        // match the first j characters in str
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern can match with empty string
        dp[0][0] = true;

        // Only '*' can match with empty string
        for (int i = 1; i <= m; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(i - 1) == '*') {
                    // '*' matches with empty sequence or any sequence
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pattern.charAt(i - 1) == '?' || pattern.charAt(i - 1) == str.charAt(j - 1)) {
                    // '?' matches any single character or exact match of current character
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}