package array.math.rotate;

import java.util.ArrayDeque;
import java.util.Deque;

/*
*
LeetCode 3210. Find the Encrypted String
*
You are given a string s and an integer k. Encrypt the string using the following algorithm:

For each character c in s, replace c with the kth character after c in the string (in a cyclic manner).
Return the encrypted string.
*
Input: s = "dart", k = 3

Output: "tdar"

Input: s = "aaa", k = 1

Output: "aaa"
*
Constraints:

1 <= s.length <= 100
1 <= k <= 104
* */

public class EncryptedString {

    static String getEncryptedString(String s, int k) {
        // Create a deque and initialize it with
        // the characters from the input string
        Deque<Character> charDeque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            charDeque.addLast(c);
        }
        // Perform left rotation by 'd' positions
        for (int i = 0; i < k; i++) {
            char firstChar = charDeque.removeFirst();
            charDeque.addLast(firstChar);
        }
        // Convert the deque back to a string and return it
        StringBuilder result = new StringBuilder();
        for (char c : charDeque) {
            result.append(c);
        }
        return result.toString();
    }

    static String leftRotateString(String s, int d)
    {
        char[] str = s.toCharArray();
        int n = str.length;
        d %= n; // Handle cases where d > n

        // Perform left rotation
        for (int i = 0; i < d; i++) {
            char firstChar = str[0];
            for (int j = 0; j < n - 1; j++) {
                str[j] = str[j + 1];
            }
            str[n - 1] = firstChar;
        }
        return String.valueOf(str);
    }

    // Function to perform right rotation of a string by 'd'
    // positions
    static String rightRotateString(String s, int d)
    {
        char[] str = s.toCharArray();
        int n = str.length;
        d %= n; // Handle cases where d > n

        // Perform right rotation
        for (int i = 0; i < d; i++) {
            char lastChar = str[n - 1];
            for (int j = n - 1; j > 0; j--) {
                str[j] = str[j - 1];
            }
            str[0] = lastChar;
        }
        return String.valueOf(str);
    }

    // Function to right rotate a string by
    // 'd' positions
    static String rightRotate(String s, int d) {
        // Create a deque and initialize it with
        // the characters from the input string
        Deque<Character> charDeque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            charDeque.addLast(c);
        }
        // Perform right rotation by 'd' positions
        for (int i = 0; i < d; i++) {
            char lastChar = charDeque.removeLast();
            charDeque.addFirst(lastChar);
        }
        // Convert the deque back to a string and return it
        StringBuilder result = new StringBuilder();
        for (char c : charDeque) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "dart";
        int k = 3;
        String encrypted = getEncryptedString(s, k);
        String cyphertext = leftRotateString(s, k);
        String rotatedRight = rightRotateString(s, k);
        System.out.println(encrypted);
        System.out.println(cyphertext);
        System.out.println(rotatedRight);
    }
}
