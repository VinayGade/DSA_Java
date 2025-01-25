package array.math.two_pointers;

/*
Leetcode 5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
* */

public class LongestPalindromicSubstring {

    byte[] chars;
    int length;

    public String longestPalindrome(String s) {

        chars = s.getBytes();
        length = chars.length;
        if (length < 2)
            return s;

        int resultIdx = 0, resultSize = 0;

        int lowBucket = 1, highBucket = (length + 1) / 2;
        while (lowBucket <= highBucket) {
            int bucket = lowBucket + (highBucket - lowBucket) / 3;

            // try even size
            int size = bucket * 2;
            int idx = search(size);

            // try odd size
            if (idx < 0) {
                size--;
                idx = search(size);
            }

            if (idx >= 0) {
                resultSize = size;
                resultIdx = idx;
                lowBucket = bucket + 1;
            } else
                highBucket = bucket - 1;
        }
        return s.substring(resultIdx, resultIdx + resultSize);
    }

    private int search(int size) {
        for (int i = 0; i + size - 1 < length; i++) {
            if (valid(i, i + size - 1)) {
                return i;
            }
        }
        return -1;
    }

    private boolean valid(int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad";
        String longest = lps.longestPalindrome(s);
        System.out.println(longest);
    }
}
