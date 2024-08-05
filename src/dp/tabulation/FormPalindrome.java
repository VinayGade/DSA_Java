package dp.tabulation;

public class FormPalindrome {

/*
 Input: str = "abcd"
Output: 3
Explanation: Inserted character marked with bold characters in dcbabcd,
here we need minimum three characters to make it palindrome.

Input: str = "aa"
Output: 0
Explanation: "aa" is already a palindrome.
* */

    static int countMin(String str){
        int n= str.length();
        String str1= new StringBuilder(str).reverse().toString();
        int m= str1.length();
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(str.charAt(i-1) == str1.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return n-dp[n][m];
    }

    public static void main(String[] args) {

        String s ="abcd";
        int count = countMin(s);
        System.out.println(count);
    }
}
