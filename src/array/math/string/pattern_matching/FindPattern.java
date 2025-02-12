package array.math.string.pattern_matching;

import java.util.Scanner;

/*
CodeChef: Find the Pattern:

Given two strings S and P, both consisting of lowercase letters of the English alphabet.
Find if the string P occurs as a substring in the string S.
A substring is a contiguous sequence of characters within a string.

Input:

3
abcabdabe
abc
xxxaaaxax
xaaax
befdsedfg
dedf

Output:

1
1
0
* */
public class FindPattern {

    // 2- pointer approach
    // if |S| = N, |P| = M,  then time complexity: O(M * N)
    public static boolean findPattern(String s, String p) {

        /*
        char[] key = p.toCharArray();
        char[] source = s.toCharArray();

        int low = 0;
        int high = key.length - 1;
        int j = high;
        for (int i = 0; i < source.length; i++) {
            if(low >= high)
                return true;
            if(source[i] == key[low] && source[i+j] == key[high]){
                low++;
                high--;
                j--;
            }
        }

        return false;
        */

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int j;
            for (j = 0; j < p.length(); j++) {
                if (s.charAt(i + j) != p.charAt(j)) {
                    break;
                }
            }
            if (j == p.length()) {
                return true;
            }
        }
        return false;
    }

    //Brute-Force Pattern Matching
    // Returns the lowest index at which substring pattern begins in text (or else −1).
    public static int findBrute(char[ ] text, char[ ] pattern) {
        int n = text.length;
        int m = pattern.length;
        for (int i=0; i <= (n-m); i++) {
            int k = 0;
            while (k < m && text[i + k] == pattern[k])
                k++;
            if (k == m)
                return i;
        }
        return -1;
    }

    // Knuth-Morris-Pratt (KMP) algorithm
    // if |S| = N, |P| = M,  then time complexity: O(M + N)
    // Optimised and most efficient code
    public static boolean contains(String s, String p) {

        int[] lps = computeLPSArray(p);
        int i = 0; // index for s[]
        int j = 0; // index for p[]

        while (i < s.length()) {
            if (p.charAt(j) == s.charAt(i)) {
                j++;
                i++;
            }

            if (j == p.length()) {
                return true;
            } else if (i < s.length() && p.charAt(j) != s.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public static int[] computeLPSArray(String p) {
        int[] lps = new int[p.length()];
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        while (--T >= 0) {

            String S = scanner.nextLine();
            String P = scanner.nextLine();
            int result = contains(S, P) ? 1 : 0;
            System.out.println(result);
        }
    }
}
