package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

/*
String And Its Frequency

 Given a string A with lowercase english alphabets and you have to return a string in which,
 with each character its frequency is written in adjacent.

Problem Constraints
1 <= |A| <= 105

Example Input
Input 1:
abbhuabcfghh

Input 2:
a

 Output:
Ouput 1:
a2b3h3u1c1f1g1

Ouput 2:

a1
* */

public class StringFrequency {

    public static String solve(String A) {

        StringBuilder charFrequency = new StringBuilder();

        Map<Character, Integer> characterFrequencyMap = characterFrequency(A);

        for(Map.Entry<Character, Integer> entry: characterFrequencyMap.entrySet()){
            char c = entry.getKey();
            int f = entry.getValue();
            charFrequency.append(c).append(f);
        }
        return charFrequency.toString();
    }

    private static LinkedHashMap<Character, Integer> characterFrequency(String string){

        LinkedHashMap<Character, Integer> charFrequency = new LinkedHashMap<>();
        for(char ch:  string.toCharArray())
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);

        return charFrequency;
    }

    public static void main(String[] args) {

        String s = "abbhuabcfghh";
        String frequency = solve(s);
        System.out.println(s);
        System.out.println(frequency);
    }
}
