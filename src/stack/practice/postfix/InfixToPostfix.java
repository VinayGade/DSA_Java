package stack.practice.postfix;

import java.util.Stack;

/*
Input :

3
(a+(b*c))
((a+b)*(z+x))
((a+t)*((b+(a+c))^(c+d)))

Output:

abc*+
ab+zx+*
at+bac++cd+^*

* */

public class InfixToPostfix {

    // Function to return precedence of operators
    static int precedence(char c) {

        switch(c){
            case '^':
                return 3;

            case '/':
            case '*':
                return 2;

            case '+':
            case '-':
                return 1;

            default :
                return -1;
        }
    }

    // Function to return associativity of operators
    static char associativity(char c) {
        return (c == '^') ? 'R' : 'L';
        // Default to left-associative
    }

    // The main function to convert infix expression to postfix expression
    static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the scanned character is an operand, add it to the output string.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c);
            }
            // If the scanned character is an ‘(‘, push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and add to the output string from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop '('
            }
            // If an operator is scanned
            else {
                while (!stack.isEmpty() && (precedence(s.charAt(i)) < precedence(stack.peek()) ||
                        precedence(s.charAt(i)) == precedence(stack.peek()) &&
                                associativity(s.charAt(i)) == 'L')) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Driver code
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        // Function call
        System.out.println(infixToPostfix(exp));
    }
}

