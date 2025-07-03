package hashing;

import java.util.*;

//Longest Substring with K Uniques

/*
You are given a string s consisting only lowercase alphabets and an integer k.
Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1.

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe",
which includes 'c', 'b', and 'e'.

Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b',
making it the longest valid substring.

Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
* */

public class LongestSubstringKUnique {

    static int longestKSubstr(String s, int k) {

        if (s == null || s.length() == 0 || k <= 0) return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = -1;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        String s = "aabacbebebe";
        int k = 3;
        int length = longestKSubstr(s, k);

        System.out.println(length);
    }
}
