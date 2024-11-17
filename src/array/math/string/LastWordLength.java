package array.math.string;

// LeetCode 58. Length of Last Word

/*
Given a string s consisting of words and spaces,
return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

* */

public class LastWordLength {

    public static int lengthOfLastWord(String s) {

        char[] letters = s.toCharArray();
        int n = letters.length;
        int count = 0;
        int i = 0;
        while (i < n) {
            if (letters[i] != ' ') {
                count++;
                i++;
            } else {
                while (i < n && letters[i] == ' ')
                    i++;
                if (i == n)
                    return count;
                else
                    count = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String sentence = "fluffy is still joyboy";
        int length = lengthOfLastWord(sentence);
        System.out.println("length of last word = "+length);
    }
}