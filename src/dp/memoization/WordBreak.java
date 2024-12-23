package dp.memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

LeetCode 139: wordBreak

Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
* */
public class WordBreak {

    static boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Boolean> map = new HashMap<>();

        if(wordDict.contains(s))
            return true;

        if(map.containsKey(s))
            return map.get(s);

        for(int i=1; i<s.length(); i++){
            String left = s.substring(0, i);
            if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict)){
                map.put(s, true);
                return true;
            }
            map.put(s, false);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");

        boolean result = wordBreak(s, wordDict);
        System.out.println(result);

    }
}
