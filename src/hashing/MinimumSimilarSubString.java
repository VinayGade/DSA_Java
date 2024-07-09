package hashing;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumSimilarSubString {

    /*
    2 Strings s,t
    s is similar to t if all characters (including duplicates) present in t are there in s.
    Find the shortest substring of the string s which is similar to t.
    If there is no such substring, print “IMPOSSIBLE”.
    Input:
    |S|, |T|
    String s
    String t

    input:
    8 2
    aabcbcde
    ad

    Output:
    6
    abcbcd

    Substrings {abcbcde, abcbcd} follow the similar substring condition out of which
    abcbcd is the shortest.
    * */

    public static String findShortestSubString(String s, String t) {
        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && windowFreq.get(c) <= tFreq.get(c)) {
                count++;
            }

            while (left <= right && count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                windowFreq.put(s.charAt(left), windowFreq.get(s.charAt(left)) - 1);
                if (tFreq.containsKey(s.charAt(left)) && windowFreq.get(s.charAt(left)) < tFreq.get(s.charAt(left))) {
                    count--;
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "IMPOSSIBLE";
        }

        return s.substring(start, start + minLen);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        String result = findShortestSubString(S, T);

        if (result.equals("IMPOSSIBLE")) {
            System.out.println(result);
        } else {
            System.out.println(result.length());
            System.out.println(result);
        }
    }
}
