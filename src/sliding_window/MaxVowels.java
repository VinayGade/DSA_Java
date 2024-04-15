package sliding_window;

import java.util.HashSet;
import java.util.Set;

/*
LeetCode 1456. Maximum Number of Vowels in a Substring of Given Length
s = "abciiidef"  k=3  result = 3   iii
    "aeiou"        2           2   ae
    "leetcode"     3           2   ee
* */
public class MaxVowels {

    public static int maximumVowelsSubstring(String s, int k){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int maxVowels = 0;
        int windowVowels = 0;

        //count vowels for 1st window
        for(int i=0; i<k ;i++){
            if(vowels.contains(s.charAt(i)))
                windowVowels++;
        }

        maxVowels = windowVowels;

        for(int i=k; i<s.length(); i++){
            if(vowels.contains(s.charAt(i-k)))
                windowVowels--;
            if(vowels.contains(s.charAt(i)))
                windowVowels++;

            maxVowels = Math.max(windowVowels, maxVowels);
        }
        return maxVowels;
    }

    // more efficient approach : better time and space complexity
    public int maxVowels(String s, int k) {
        int vowel = 0;
        for(int i=0; i<k; i++)
            if(isVowel(s.charAt(i)))
                vowel++;
        int max = vowel;
        for(int i=k; i<s.length(); i++){
            if(isVowel(s.charAt(i)))
                vowel++;
            if(isVowel(s.charAt(i-k)))
                vowel--;
            max = Math.max(max, vowel);
        }
        return max;
    }

    private boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {

        String s = "abciiidef";
        int k=3;

        int count = maximumVowelsSubstring(s,k);
        System.out.println("String = "+s);
        System.out.println("Sub-String length = "+k);
        System.out.println("Maximum Number of Vowels in a Substring = "+count);
    }
}
