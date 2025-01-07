package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given a string s consisting of lowercase Latin Letters.
Return the first non-repeating character in s.
If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.

Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating.
* */
public class FirstNonRepeatingChar {

    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        char result = '$';
        Map<Character, Integer> map = frequency(s);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    static Map<Character, Integer> frequency(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        char c = nonRepeatingChar(s);
        System.out.println(c);
    }
}
