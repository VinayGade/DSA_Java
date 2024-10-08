package array.math.sliding_window;

//LC 76 Minimum Window Substring

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window.
 If there is no such substring, return the empty string "".
* */
public class MinimumWindowSubstring {

    /*
    Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

    * */
    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";
        String subString = minWindow(s, t, s.length(), t.length());
        String subStr = minWindow(s, t);
        System.out.println(subString);
        System.out.println(subStr);
    }

    // Optimized code
    static String minWindow(String str, String t, int n, int m) {
        int[] freq = new int[123];
        for (int i = 0; i < m; i++) {
            freq[t.charAt(i)]++;
        }
        int minLen = Integer.MAX_VALUE, start = 0, copy, len;
        for (int s = 0, e = 0, count = m; e < n; e++) {
            if (freq[str.charAt(e)]-- > 0) {
                count--;
            }
            copy = count;
            while (count == 0 && s <= e) {
                if (freq[str.charAt(s++)]++ >= 0) {
                    count++;
                }
            }
            if (copy == 0 && minLen > (len = e - s + 2)) {
                minLen = len;
                start = s - 1;
            }
        }
        return minLen != Integer.MAX_VALUE ? str.substring(start, start + minLen) : "";
    }

    static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        Map<Character, Integer> map = frequncy(t);

        int result = Integer.MAX_VALUE;
        int start = 0;
        int count = map.size();

        int i=0, j=0;
        while(j < m){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) - 1);

            if(map.get(c) == 0)
                count--;

            if(count == 0){
                while(count == 0){
                    if(result > (j-i+1)){
                        result = j-i+1;
                        start = i;
                    }
                    char ch = s.charAt(i);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    if(map.get(ch) > 0)
                        count++;
                    i++;
                }
            }
            j++;
        }
        return (result != Integer.MAX_VALUE) ?
                s.substring(start, start + result) : "";
    }

    static Map<Character, Integer> frequncy(String s){
        Map<Character, Integer> charFreqMap = new LinkedHashMap<>();
        for(char x: s.toCharArray())
            charFreqMap.put(x, charFreqMap.getOrDefault(x, 0)+1);
        return charFreqMap;
    }
}
