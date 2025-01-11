package array.math.sliding_window;

import java.util.*;

/*
Given a string s, find the length of the longest substring with all distinct characters.

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.

Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
* */

public class DistinctCharactersLongestSubString {

    // Optimized code using "2-pointers sliding window" and HashMap
    static int longestUniqueSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        int start = 0;
        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (lastIndex.containsKey(currentChar)) {
                start = Math.max(start, lastIndex.get(currentChar) + 1);
            }
            lastIndex.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    /*

Key Fixes and Explanation:

Algorithm Change: Used the sliding window technique with a HashMap to track the last index of each character for efficiency.

Removed frequency and findMax functions: They were unnecessary for this problem.

Fixed the loop logic: The loop now iterates over the entire string, ensuring correctness for all test cases.

Correct Handling of Repeated Characters: If a character is repeated, the start of the window adjusts properly.

Edge Cases: The code now handles empty strings and single-character strings correctly.
This version has O(n) time complexity and works for all test cases you provided.

    * */

    //incorrect code
    static int longestUniqueSubstr(String s) {
        int n = s.length();
        int size = frequency(s).entrySet().size();
        Map<Character, Boolean> visited = new HashMap<>();
        List<Integer> sizes = new ArrayList<>();
        //boolean[] visited = new boolean[size];
        int count = 0;
        //int low = 0;
        //int high = n-1;
        for(int i=0; i<size; i++){
            char key = s.charAt(i);
            //TODO: fix this logic ...NullPointerException
            if(!visited.isEmpty()){
                if(visited.get(key)) { // visited.containsKey()
                    sizes.add(count);
                    //low = i+1;
                    count = 1; // reset count
                }
            }else{
                visited.put(key, true);
                count ++;
            }
        }
        int max = findMax(sizes);
        return max;
    }

    static Map<Character, Integer> frequency(String s){
        Map<Character, Integer> charFrequency = new LinkedHashMap<>();
        for(char c: s.toCharArray()){
            charFrequency.put(c, charFrequency.getOrDefault(c, 1)+1);
        }
        return charFrequency;
    }

    static int findMax(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int x: list){
            max = Math.max(x, max);
        }
        return max;
    }

    public static void main(String[] args) {
        // String s = "geeksforgeeks";
        //s = "abcdefabcbb";

        //int size = longestUniqueSubstr(s);

        String s = "geeksforgeeks";

        int size = longestUniqueSubstring(s);
        System.out.println(size);
    }
}
