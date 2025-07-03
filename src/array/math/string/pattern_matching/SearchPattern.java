package array.math.string.pattern_matching;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

// Rabin - Karp KMP
public class SearchPattern {

    // Time limit exceeds
    ArrayList<Integer> search(String pattern, String text) {

        ArrayList<Integer> al = new ArrayList<>();

        int i = 0, n = text.length();

        int nn = pattern.length();

        while (i <= n - nn) {

            if (Objects.equals(text.substring(i, i + nn), pattern)) {
                al.add(i + 1);
            }
            i++;
        }
        return al;
    }

    // brute - force ...Time limit exceeds
    ArrayList<Integer> searchPattern(String pattern, String text) {

        ArrayList<Integer> arr = new ArrayList<Integer>();

        int n = text.length();
        int m = pattern.length();

        for (int x = 0; x <= n - m; x++) {
            if (text.substring(x, m + x).equals(pattern))
                arr.add(x + 1);
        }

        return arr;
    }

    // approach 2:

    ArrayList<Integer> searc_Bruteforce(String pattern, String text) {

        ArrayList<Integer> list = new ArrayList<>();
        int pos = text.indexOf(pattern);

        while (pos >= 0) {
            list.add(pos + 1);
            pos = text.indexOf(pattern, pos + 1);
        }

        return list;
    }

    ArrayList<Integer> search_String(String pattern, String text) {
        // your code here
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < (text.length() - pattern.length() + 1); i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) break;
                    if (j == pattern.length() - 1) al.add(i + 1);
                }
            }
        }
        return al;
    }

    ArrayList<Integer> searchPatternInText(String pattern, String text) {
        // your code here
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (index < text.length()) {
            int a = text.indexOf(pattern, index);

            if (a >= 0) {
                list.add(a + 1);
                index = a + 1;
            } else {
                break;
            }
        }
        return list;
    }

    // LPS = Longest Proper prefix which is also suffix

    static void constructLps(String pat, int[] lps) {

        // len stores the length of longest prefix which
        // is also a suffix for the previous index
        int len = 0;

        // lps[0] is always 0
        lps[0] = 0;

        int i = 1;
        while (i < pat.length()) {

            // If characters match, increment the size of lps
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            // If there is a mismatch
            else {
                if (len != 0) {

                    // Update len to the previous lps value
                    // to avoid redundant comparisons
                    len = lps[len - 1];
                }
                else {

                    // If no matching prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // KMP = Knuth Morris Pratt Algorithm for pattern searching

    static ArrayList<Integer> searchPatternInString(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();

        constructLps(pat, lps);

        // Pointers i and j, for traversing
        // the text and pattern
        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched
                // store the start index in result
                if (j == m) {
                    res.add(i - j);

                    // Use LPS of previous index to
                    // skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }

            // If there is a mismatch
            else {

                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        ArrayList<Integer> indexes = searchPatternInString(needle, haystack);
            int index = indexes.isEmpty() ? -1 : indexes.get(0);
        System.out.println(
                index
        );

        //LC 1910. Remove All Occurrences of a Substring

        String s = "daabcbaabcbc";
        String part = "abc";

        String result = removeOccurrences(s, part);
        System.out.println(
                "after removing part : "+result
        );
    }


    //LC 1910. Remove All Occurrences of a Substring
    /*
    Given two strings s and part, perform the following operation on s until
    all occurrences of the substring part are removed:

    Return s after removing all occurrences of part.

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
    * */
    public static String removeOccurrences(String s, String part) {
        int n = s.length(), m = part.length(), j = 0;
        int [] lps = new int[m];
        constructLps(part, lps);

        char[] result = s.toCharArray();

        Stack<Integer> state = new Stack<>();

        for (int i = 0; i < n; i++){

            result[j] = result[i];
            j++;

            int k = state.isEmpty() ? 0 : state.peek();

            while (k > 0 && part.charAt(k) != result[i]){
                k = lps[k - 1];
            }
            if (part.charAt(k) == result[i])
                k++;

            state.push(k);

            if (k == m){
                j -= m;
                for (int x = 0; x < m; x++){
                    state.pop();
                }
            }
        }
        return new String(result, 0, j);
    }
}
