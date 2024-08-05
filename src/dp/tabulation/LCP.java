package dp.tabulation;

// Longest Common Prefix

import java.util.Arrays;

/**
 arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]

 output: gee

 arr[] = ["hello","world"]

 output: = -1

 Input: S[] = {“abcdefgh”, “abcefgh”}
 Output: “abc”

 Input: S[] = {“flower”, “flow”, "flight"}
 Output: “fl”

 * */
public class LCP {

    public static String lcp(String[] S){
        if (S.length == 0)
            return "";
        String prefix = S[0];
        for (int i = 1; i < S.length; i++)
            while (S[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }

    public static String LCP(String[] S) {
        StringBuilder lcp = new StringBuilder();

        Arrays.sort(S);

        char[] first = S[0].toCharArray();
        char[] last = S[S.length-1].toCharArray();

        for(int i=0; i<first.length; i++){
            if(first[i] != last[i])
                break;
            lcp.append(first[i]);
        }
        String prefix = lcp.toString();
        return prefix.isEmpty() ? "-1" : prefix;
    }

    public String longestCommonPrefix(String[] strings) {
        //sort strings according to length
        Arrays.sort(strings);

        //first = shortest, last = longest
        String first = strings[0];
        String last = strings[ strings.length - 1 ];

        int index = 0;

        //check characters of both strings

        while(index < first.length() && index < last.length()){
            if(first.charAt(index) == last.charAt(index))
                index++;

            else
                break;
        }
        return first.substring(0, index);
    }

    // Divide and Conquer
    public static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }
    public static String longestCommonPrefix(String S[], int low, int high) {
        if (low == high) {
            return (S[low]);
        }

        if (high > low) {
            int mid = low + (high - low) / 2;

            String str1 = longestCommonPrefix(S, low, mid);
            String str2 = longestCommonPrefix(S, mid + 1, high);

            return (commonPrefixUtil(str1, str2));
        }
        return null;
    }

    //Binary Search

    public static int findMinLength(String S[], int n)
    {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= (n - 1); i++)
        {
            if (S[i].length() < min) {
                min = S[i].length();
            }
        }
        return min;
    }

    public static boolean allContainsPrefix(String S[], int n,
                                            String str, int start, int end)
    {
        for (int i = 0; i <= (n - 1); i++)
        {
            String S_i = S[i];

            for (int j = start; j <= end; j++)
                if (S_i.charAt(j) != str.charAt(j))
                    return false;
        }
        return true;
    }

    public static String longestCommonPrefix(String S[], int n)
    {
        int index = findMinLength(S, n);
        String prefix = "";
        int low = 0, high = index-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (allContainsPrefix(S, n, S[0], low,
                    mid))
            {
                prefix = prefix + S[0].substring(low, mid + 1);
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        String S[] = {"geeksforgeeks", "geeks", "geek", "geezer"};

        String prefix = LCP(S);

        System.out.println("Longest Common Prefix = "+prefix);
    }
}
