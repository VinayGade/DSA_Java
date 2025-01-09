package array.math.two_pointers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Palindrome {

    // Returns true if string is a palindrome
    static boolean isPalindrome(String str) {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

    // string is a Palindrome using recursion
    static boolean isPalindrome(int i, int j, String A) {
        // comparing the two pointers
        if (i >= j) {
            return true;
        }

        // comparing the characters on those pointers
        if (A.charAt(i) != A.charAt(j)) {
            return false;
        }

        // checking everything again recursively
        return isPalindrome(i + 1, j - 1, A);
    }

    public static boolean isPalindrome(String A, int n)
    {
        return isPalindrome(0, n - 1, A);
    }

    public boolean isPalindromeRecursive(String text){
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        return recursivePalindrome(clean,0,clean.length()-1);
    }

    private boolean recursivePalindrome(String text, int forward, int backward) {
        if (forward == backward) {
            return true;
        }
        if ((text.charAt(forward)) != (text.charAt(backward))) {
            return false;
        }
        if (forward < backward + 1) {
            return recursivePalindrome(text, forward + 1, backward - 1);
        }

        return true;
    }

    static boolean isPalindromeUsingList(String str) {

        str = str.toUpperCase();
        char[] strChars = str.toCharArray();

        List<Character> word = new ArrayList<>();
        for (char c : strChars) {
            word.add(c);
        }

        while (true) {
            if ((word.size() == 1) || (word.size() == 0)) {
                return true;
            }
            if (word.get(0) == word.get(word.size() - 1)) {
                word.remove(0);
                word.remove(word.size() - 1);
            } else {
                return false;
            }
        }
    }

    public boolean isPalindromeBuiltIn(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    public boolean isPalindromeReverseTheString(String text) {
        StringBuilder reverse = new StringBuilder();
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        char[] plain = clean.toCharArray();
        for (int i = plain.length - 1; i >= 0; i--) {
            reverse.append(plain[i]);
        }
        return (reverse.toString()).equals(clean);
    }

    public boolean isPalindromeUsingStringBuilder(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    public boolean isPalindromeUsingStringBuffer(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        StringBuffer plain = new StringBuffer(clean);
        StringBuffer reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    public boolean isPalindromeUsingIntStream(String text) {
        String temp  = text.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }

    public int isPalindromic(String A) {
        A = A.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        for(int i = 0; i < A.length() -1 / 2; i++){
            if(A.charAt(i) != A.charAt(A.length() -1 - i))
                return 0;
        }
        return 1;
    }

    // Main driver method
    public static void main(String[] args) {
        String str = "geeks";
        String str2 = "RACEcar"; //"racecar";

        // Change strings to lowercase
        str = str.toLowerCase();
        str2 = str2.toLowerCase();

        // For string 1
        System.out.print("String 1 :");

        if (isPalindrome(str))
            System.out.print("It is a palindrome");
        else
            System.out.print("It is not a palindrome");

        // new line for better readability
        System.out.println();

        // For string 2
        System.out.print("String 2 :");
        if (isPalindrome(str2))
            System.out.print("It is a palindrome");
        else
            System.out.print("It is not a palindrome");
    }
}
