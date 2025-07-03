package array.math.string;

public class PalindromeSubstring {

    public static int countPalindromicSubstringsExpand(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            count += expandFromCenter(s, i, i);     // Odd-length palindromes
            count += expandFromCenter(s, i, i + 1); // Even-length palindromes
        }
        return count;
    }

    private static int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) { // Consider only substrings of length ≥2
                count++;
            }
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubstringsExpand("abaab")); // Output: 3
    }
}
