package array.math.string;

import java.util.HashSet;
import java.util.Set;

/*
Pangram is a sentence containing every letter in the english alphabet.

Given a string str and an integer k, return true if the string can be changed into a pangram
after at most k operations, else return false.

A single operation consists of swapping an existing alphabetic character with
any other lowercase alphabetic character.


* */
public class KPangrams {

    boolean kPangram(String str, int k) {
        String s="";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=' ')
                s+=str.charAt(i);
        }
        int n = s.length();
        if(n < 26)
            return false;

        Set<Character> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(s.charAt(i));
        }

        int size = set.size();
        if(size>=26 || (size+k) >= 26)
            return true;
        return false;
    }

    public static void main(String[] args) {
        /*
        Input: str = "the quick brown fox jumps over the lazy dog", k = 0
        Output: true
        Explanation: the sentence contains all 26 characters and is already a pangram.

        Input: str = "aaaaaaaaaaaaaaaaaaaaaaaaaa", k = 25
Output: true
Explanation: The word contains 26 instances of 'a'. Since only 25 operations are allowed. We can keep 1 instance and change all others to make str a pangram.

         Input: str = "a b c d e f g h i j k l m", k = 20
Output: false
Explanation: Since there are only 13 alphabetic characters in this case, no amount of swapping can produce a panagram here.
         */


    }
}
