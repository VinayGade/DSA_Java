package recursion;

public class GCDString {

    //Leetcode 1071. Greatest Common Divisor of Strings
    /*
    Example 1:

    Input: str1 = "ABCABC", str2 = "ABC"
    Output: "ABC"

    Example 2:

    Input: str1 = "ABABAB", str2 = "ABAB"
    Output: "AB"

    Example 3:

    Input: str1 = "LEET", str2 = "CODE"
    Output: ""

    ... 1 <= str1.length, str2.length <= 1000
    * */
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());
        return str2.substring(0, gcd);
    }

    public static int gcd(int a, int b) {
        return (b == 0)? a : gcd(b, a % b);
    }

    public static String gcdOfStringsOptimized(String str1, String str2) {

        if (str1.length() < str2.length()) {
            // make sure str1 is not shorter than str2.
            return gcdOfStrings(str2, str1);
        }else if (!str1.startsWith(str2)) {
            // shorter string is not common prefix.
            return "";
        }else if (str2.isEmpty()) {
            // gcd string found.
            return str1;
        }else {
            // cut off the common prefix part of str1.
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }

    public static void main(String[] args) {

        String str1 = "ABCABC", str2 = "ABC";
        String gcd1=gcdOfStringsOptimized(str1, str2);

        String gcd2=gcdOfStringsOptimized("ABABAB", "ABAB");

        String gcd3=gcdOfStrings("LEET", "CODE");

        System.out.println("gcd1="+gcd1);
        System.out.println("gcd2="+gcd2);
        System.out.println("gcd3="+gcd3);
    }
}
