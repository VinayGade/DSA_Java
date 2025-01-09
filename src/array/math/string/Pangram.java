package array.math.string;

import java.util.HashSet;
import java.util.Set;

/*
LeetCode 1832. Check if the Sentence Is Pangram

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence
is a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false

* */
public class Pangram {

    public static boolean checkIfPangram(String sentence) {
        boolean[] chars = new boolean[26];
        for(int i=0; i<sentence.length(); i++){
            chars[sentence.charAt(i) - 'a'] = true; // ascii
        }
        for(boolean flag: chars){
            if(!flag){
                return false;
            }
        }
        return true;
    }

    public static boolean isPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<sentence.length(); i++){
            set.add(sentence.charAt(i));
        }
        return set.size()==26;
    }

    public static void main(String[] args) {
        String sentence = "leetcode";
        System.out.println(sentence+" is Pangram ? "+ isPangram(sentence));

        sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(sentence+" is Pangram ? "+ checkIfPangram(sentence));
    }
}
