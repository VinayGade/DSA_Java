package array.math.string;

/*
Given a string A consisting of lowercase characters.

You have to find the number of substrings in A which starts with vowel and
end with consonants or vice-versa.
* */

public class VowelConsonentSubstrings {

    static int solve(String A) {

        int mod = 1000000007;
        int result = 0;
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);

            if (isVowel(currentChar)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
            // Count substrings ending with the current character
            result = (result + (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u' ||
                    currentChar == 'A' || currentChar == 'E' || currentChar == 'I' || currentChar == 'O' || currentChar == 'U' ? consonantCount : vowelCount)) % mod;
        }
        return result;
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String A = "aba";
        /*
         Output: 2

        Explanation 1:

 Substrings of S are : [a, ab, aba, b, ba, a]Out of these only 'ab' and 'ba'
 satisfy the condition for special Substring. So the answer is 2.
        * */
        int count = solve(A);
        System.out.println(count);
    }
}
