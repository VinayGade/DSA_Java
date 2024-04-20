package hashing;

import java.util.HashMap;
import java.util.Map;


/*
LeetCode 383.(Easy) Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed
by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Input: ransomNote = "a", magazine = "b"
Output: false

Input: ransomNote = "aa", magazine = "ab"
Output: false

Input: ransomNote = "aa", magazine = "aab"
Output: true
* */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        /*
        if(magazine.contains(ransomNote))
            return true;
        */
        if(ransomNote.length()>magazine.length())
            return false;

        Map<Character, Integer> magazineMap = charFrequency(magazine);
        Map<Character, Integer> noteMap = charFrequency(ransomNote);

        /*
        if(ransomNote.length()==magazine.length())
            return magazineMap.equals(noteMap);
         */
        for(Map.Entry<Character, Integer> noteEntry: noteMap.entrySet()){
            char key=noteEntry.getKey();
            if(!magazineMap.keySet().contains(key) ||   //map.containsKey(key) ...time consuming
                    noteEntry.getValue() > magazineMap.get(key))
                return false;
        }
        return true;
    }

    private static Map<Character, Integer> charFrequency(String s){
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int freq = charFrequencyMap.getOrDefault(c, 0);
            charFrequencyMap.put(c, ++freq);
        }
        return charFrequencyMap;
    }

    public static boolean canConstructOptimized(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for(char c: ransomNote.toCharArray()){
            int i = magazine.indexOf(c, letters[c%26]);
            if(i==-1)
                return false;
            letters[c%26]=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.println("canConstruct ?"+canConstruct(ransomNote, magazine));
    }
}
