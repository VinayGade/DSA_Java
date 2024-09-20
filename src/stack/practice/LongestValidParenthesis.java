package stack.practice;

import java.util.Stack;

/*
Given a string str consisting of opening and closing parenthesis '(' and ')'.
Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
Opening parenthesis must be closed in the correct order.

Input: str = ((()
Output: 2
Explaination: The longest valid parenthesis substring is "()".

Input: str = )()())
Output: 4x
Explaination: The longest valid parenthesis substring is "()()".
* */

public class LongestValidParenthesis {

    static int maxLength(String S){
        char[] chars = S.toCharArray();
        int n = chars.length;

        int count = 0;
        Stack<Character> pars = new Stack<>();

        for(int i = 0; i < n; i++){
            if(chars[i] == '(')
                pars.push(chars[i]);
            if(chars[i] == ')') {
                if(pars.isEmpty())
                    continue;
                if(pars.peek() == '('){
                    pars.pop();
                    count+=2;
                }
            }
        }
        return count;
    }

    public static int maxLengthParenthesis(String S) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Initialize the stack with -1 to handle the base case

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '(') {
                // Push the index of the opening parenthesis
                stack.push(i);
            } else {
                // Pop the index of the matching '('
                stack.pop();

                // If the stack is empty, push the current index as a base for the next valid substring
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String str = ")()())";
        int length = maxLengthParenthesis(str);
        System.out.println(length);
    }
}
