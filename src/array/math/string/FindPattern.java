package array.math.string;

import java.util.Scanner;

/*
You are given two strings S, P both consisting of lowercase letters
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

    // Function to find if P is a substring of S
    static int findSubstring(String S, String P) {
        int M = P.length();
        int N = S.length();

        // Iterate through S
        for (int i = 0; i <= (N - M); i++) {

            // Check for substring match
            int j;
            for (j = 0; j < M; j++) {

                // Mismatch found
                if (S.charAt(i + j) != P.charAt(j)) {
                    break;
                }
            }

            // If we completed the inner loop, we found a match
            if (j == M) {
                // Return starting index
                return i;
            }
        }
        // No match found
        return -1;
    }

    static boolean containsP(String S, String P){
        return findSubstring(S, P) >= 0;
    }

    //  **** The most optimized approach

    // Function to create the longest prefix suffix (LPS) array
    static int[] computeLPSArray(String P) {
        int M = P.length();
        int[] lps = new int[M];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (P.charAt(i) == P.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Knuth-Morris-Pratt (KMP) algorithm
    // Function to find if P is a substring of S using KMP
    static boolean contains(String S, String P) {
        int N = S.length();
        int M = P.length();

        int[] lps = computeLPSArray(P);

        int i = 0, j = 0;
        while (i < N) {
            if (P.charAt(j) == S.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                return true; // Found the pattern
            } else if (i < N && P.charAt(j) != S.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false; // Pattern not found
    }

    // find P in S
    // check if P is subString of S
    // 2 - pointers approach doesn't work.
    /*
    static boolean contains(String S, String P) {

        // 2 pointers approach
        int i = 0, j = 0;
        int k = 0; // substring length

        char s[] = S.toCharArray();
        char p[] = P.toCharArray();

        int n = s.length;
        int m = p.length;

        if (m < 1)
            return true;

        while (i < n && j < m) {
            k = n - i + 1;
            j=0;
            while(i < n && p[j] != s[i]){
                i++;
            }
            if(p[j] == s[i]) {
                j++;
                i++;
            }
            else {
                if((n - k) < m)
                    break;
            }
        }
        return j == m;
    }*/

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        while (t-- > 0) {

            String S = scanner.nextLine();
            String P = scanner.nextLine();

            System.out.println(containsP(S, P) ? "1": "0");
        }
        scanner.close();
    }
}
