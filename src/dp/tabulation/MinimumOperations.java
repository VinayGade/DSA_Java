package dp.tabulation;

public class MinimumOperations {

    static int minOperations(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n = s1.length;
        int m = s2.length;
        if(str1.contains(str2))
            return n - m;
        else if(str2.contains(str1))
            return m - n;
        else{
            int dp[][] = new int[n+1][m+1];
            for(int i = 0;i<n+1;i++)
                dp[i][0] = i;

            for(int j = 0;j<m+1;j++)
                dp[0][j] = j;


            for(int i = 1;i<n+1;i++) {
                for(int j = 1;j<m+1;j++) {
                    if(s1[i-1] == s2[j-1])
                        dp[i][j] = dp[i-1][j-1];
                    else {
                        int add = dp[i][j-1]+1;
                        int del = dp[i-1][j]+1;
                        dp[i][j] = Math.min(add,del);
                    }
                }
            }
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        String str1 = "geeksforgeeks", str2 = "geeks";

        int count = minOperations(str1, str2);

        System.out.println("Number of opertations (insertions and deletions) to convert s1 to s2");

        System.out.println("\n s1="+ str1 + " s2="+ str2 + " count = "+count);

        str1 = "heap"; str2 = "pea";

        count = minOperations(str1, str2);

        System.out.println("\n s1="+ str1 + " s2="+ str2 + " count = "+count);
    }
}
