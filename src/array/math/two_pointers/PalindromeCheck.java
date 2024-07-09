package array.math.two_pointers;

//CodeChef: 2 - Pointer -> Check Palindrome

import java.util.Scanner;

/*
You are given a string
Your task is to determine if the string can be a palindrome after deleting at most one
character from it.

Input:
4
abca

Output:
true
* */
public class PalindromeCheck {

    // Function to check if the string can be a palindrome after deleting
    // at most one character
    static boolean validPalindrome(String s, int n) {

        int i = 0, j = n - 1;
        int count = 0;

        while (i < j) {

            // If there is a mismatch
            if (s.charAt(i) != s.charAt(j)){
                if(count > 0)
                    return false;
                count++;
            }
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(validPalindrome(s, n) ? "true" : "false");
    }
}
