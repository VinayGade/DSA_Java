package array.math.two_pointers;

//LeetCode 392. Is Subsequence

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by
deleting some (can be none) of the characters without disturbing the relative positions
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.

* */

public class SubSequence {

    static boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        int n=t.length();
        int m=s.length();
        char sarr[]=s.toCharArray();
        char tarr[]=t.toCharArray();

        if(m<1)
            return true;

        while(i<n && j<m){
            if(tarr[i]==sarr[j])
                j++;
            i++;
        }
        return j==m;
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }
}
