package dp.tabulation;

/*
LeetCode 2014: Longest Subsequence Repeated k Times

You are given a string s of length n, and an integer k.
You are tasked to find the longest subsequence repeated k times in string s.

A subsequence is a string that can be derived from another string by deleting
some or no characters without changing the order of the remaining characters.

A subsequence seq is repeated k times in the string s if seq * k is a subsequence of s,
where seq * k represents a string constructed by concatenating seq k times.

Return the longest subsequence repeated k times in string s. If multiple such subsequences are found,
 return the lexicographically largest one. If there is no such subsequence, return an empty string.

Input: s = "letsleetcode", k = 2
Output: "let"
Explanation: There are two longest subsequences repeated 2 times: "let" and "ete".
"let" is the lexicographically largest one.

Input: s = "bb", k = 2
Output: "b"
Explanation: The longest subsequence repeated 2 times is "b".

Input: s = "ab", k = 2
Output: ""
Explanation: There is no subsequence repeated 2 times. Empty string is returned.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRSk {

    public static void main(String[] args) {
        String s = "letsleetcode";
        int k = 2;
        String result = longestSubsequenceRepeatedK(s, k);
        System.out.println("Longest subsequence repeated " + k + " times: " + result);
    }

    public static String longestSubsequenceRepeatedK(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Collect all valid characters that can possibly form subsequences repeated k times
        List<Character> validChars = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= k) {
                validChars.add(entry.getKey());
            }
        }

        // Start backtracking for subsequences
        String result = backtrack(validChars, s, k, new StringBuilder(), 0);
        return result == null ? "" : result;
    }

    private static String backtrack(List<Character> validChars, String s, int k, StringBuilder current, int start) {
        // Check if the current subsequence is valid and repeated k times
        if (current.length() > 0 && !isKRepeatedSubsequence(current.toString(), k, s)) {
            return null;
        }

        // The current subsequence is valid
        String result = current.toString();

        for (int i = 0; i < validChars.size(); i++) {
            char c = validChars.get(i);

            // Try adding this character to the current subsequence
            current.append(c);
            String candidate = backtrack(validChars, s, k, current, i);
            current.deleteCharAt(current.length() - 1); // Backtrack

            // Update the result to keep the longest lexicographically largest subsequence
            if (candidate != null && (candidate.length() > result.length() ||
                    (candidate.length() == result.length() && candidate.compareTo(result) > 0))) {
                result = candidate;
            }
        }

        return result;
    }

    private static boolean isKRepeatedSubsequence(String seq, int k, String s) {
        int index = 0, count = 0;

        for (char c : s.toCharArray()) {
            if (c == seq.charAt(index)) {
                index++;
                if (index == seq.length()) {
                    count++;
                    index = 0;
                }
            }
        }

        return count >= k;
    }
}
