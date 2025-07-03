package hashing;

import java.util.*;

/*
Substrings of length k with k-1 distinct elements

Given a string s consisting only lowercase alphabets and an integer k.
Find the count of all substrings of length k which have exactly k-1 distinct characters.

Input: s = "abcc", k = 2
Output: 1
Explaination: Possible substring of length k = 2 are,
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct characters
Only one valid substring so, count is equal to 1.

Input: "aabab", k = 3
Output: 3
Explaination: Possible substring of length k = 3 are,
aab : 2 distinct charcters
aba : 2 distinct characters
bab : 2 distinct characters
All these substring are valid so, the total count is equal to 3.

* */

public class SubstringWith_K_Elements {

    public static int substrCount(String s, int k) {
        int count = 0;
        for(int i=0; i<=s.length()-k; i++) {
            String currString = s.substring(i, i+k);
            if(isSubstr(currString, k))
                count++;
        }
        return count;
    }

    private static boolean isSubstr(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            set.add(s.charAt(i));
        }
        if(set.size() == (k-1))
            return true;
        return false;
    }

    public static void main(String[] args) {

        String s = "aabab";
        int k = 3;
        int count = substrCount(s, k);
        System.out.println(count);
    }
}
