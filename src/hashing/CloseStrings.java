package hashing;

import java.util.*;

/*
LeetCode 1657. Determine if Two Strings Are Close

Two strings are considered close if you can attain one from the other using the following
operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb

Operation 2: Transform every occurrence of one existing character into another
existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
* */

public class CloseStrings {

    //partially correct code. Doesn't work for many test cases.
    public static boolean closeStrings(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();
        if(n1 == n2) {
            int count = 0;
            Map<Character, Integer> word1Map = charFrequency(word1);
            Map<Character, Integer> word2Map = charFrequency(word2);
            Set<Character> characters = word1Map.keySet();
            for(char c: characters){
                if(!word2Map.containsKey(c))
                    return false;
            }
            for (Map.Entry<Character, Integer> entry : word1Map.entrySet()) {
                int frequency1 = entry.getValue();
                int frequency2 = word2Map.get(entry.getKey());
                if (frequency1 != frequency2) {
                    count++;
                }
            }
            return count <= characters.size();
        }
        return false;
    }

    //correct code
    public static boolean closestStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        // Frequency maps for both words
        Map<Character, Integer> word1Map = charFrequency(word1);
        Map<Character, Integer> word2Map = charFrequency(word2);

        // Check if both words have the same unique characters
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }

        // Check if both words have the same frequency distribution
        List<Integer> freq1 = new ArrayList<>(word1Map.values());
        List<Integer> freq2 = new ArrayList<>(word2Map.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);
    }

    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 1) + 1);
        }
        return frequencies;
    }

    public static void main(String[] args) {
        String word1 = "abcde";
        String word2 = "aecdb";

        String closer = closeStrings(word1, word2) ? "YES": "NO";

        System.out.println(closer);
    }
}
