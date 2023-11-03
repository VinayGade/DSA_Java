package hashing;

import java.util.LinkedHashMap;

// LeetCode 205. Isomorphic Strings
public class Isomorphic {

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        String isomorphic = isIsomorphic(s,  t)? "YES" : "NO";
        System.out.println("String "+s+" and "+t+ " are isomorphic ? "+isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        LinkedHashMap<Character, Integer> charFrequencyS = characterFrequency(s);
        LinkedHashMap<Character, Integer> charFrequencyT = characterFrequency(t);
        return charFrequencyS.values().equals(charFrequencyT.values());
    }

    private static LinkedHashMap<Character, Integer> characterFrequency(String string){

        LinkedHashMap<Character, Integer> charFrequency = new LinkedHashMap<>();
        for(char ch:  string.toCharArray())
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);

        return charFrequency;
    }
}
