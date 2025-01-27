package stack.practice;

import java.util.Stack;

/*
Reverse the String

You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"

Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"
* */

public class StringReverse {

    private static final String SPACE = " ";
    public static String solve(String A) {
        int i = 0;
        int n = A.length();
        final StringBuilder reversed = new StringBuilder();
        final Stack<String> stack = new Stack();

        while(i < n) {
            if(!isSpace(A.charAt(i))) {
                final StringBuilder word = new StringBuilder();
                while(i < n && !isSpace(A.charAt(i))) {
                    word.append(A.charAt(i));
                    ++i;
                }
                stack.push(word.toString());
            }
            ++i;
        }

        while(!stack.isEmpty()) {
            reversed.append(stack.pop() + SPACE);
        }

        return reversed.substring(0, reversed.length()-1);
    }

    public static boolean isSpace(final char character) {
        return character == ' ';
    }

    public static void main(String[] args) {
        String A = "the sky is blue";
        String reverse = solve(A);
        System.out.println(reverse);
    }
}
