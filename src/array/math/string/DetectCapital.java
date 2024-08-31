package array.math.string;

// LeetCode 520. Detect Capital

/*
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:

Input: word = "USA"
Output: true

Example 2:

Input: word = "FlaG"
Output: false

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
* */

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        /*
        Unicode capital A - Z : 65 - 90
        Unicode         a - z : 97 - 122
        */
        char[] letters = word.toCharArray();
        int n = letters.length;

        //boolean flag = letters[0] > 64 && letters[0] < 91; // capital frist letter

        int captialCount = 0;
        int smallCount = 0;

        for(int i=1; i<n; i++){
            /* if flag:
                   either all remaining letters: capital
                   or     all remaining letters: small
                else
                    all remaining letters: small
            */
            if(letters[i] > 64 && letters[i] < 91)
                captialCount++;
            if(letters[i] > 96 && letters[i] < 123)
                smallCount++;
        }

        return (letters[0] > 64 && letters[0] < 91)
                ? captialCount == (n-1) || smallCount == (n-1)
                : smallCount == (n-1);
    }

    public static void main(String[] args) {

        String word1 = "USA";
        String word2 = "Java";
        String word3 = "leetcode";
    }
}
