package stack.practice.postfix;

import java.util.Scanner;
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

public class Infix2Postfix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        String[] inputs = new String[t];
        for(int i=0; i<t; i++){
            inputs[i] = scan.next();
            String postfix = infixToPostfix(inputs[i]);
            System.out.println(postfix);
        }
    }

    // conversion withot ()
    static String infixToPostfix2(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (isOperand(ch)) {
                result.append(ch);
            } else {
                while (!stack.isEmpty() && (operatorPrecedenceCondition(infix, i, stack))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    // conversion with ()
    static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (isOperand(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && (operatorPrecedenceCondition(infix, i, stack))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    static int getPrecedenceScore(char ch) {
        switch (ch) {
            case '^':
                return 3;

            case '*':
            case '/':
                return 2;

            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    static char associativity(char ch) {
        if (ch == '^')
            return 'R';
        return 'L';
    }

    static boolean operatorPrecedenceCondition(String infix, int i, Stack<Character> stack) {
        return getPrecedenceScore(infix.charAt(i)) < getPrecedenceScore(stack.peek())
                || getPrecedenceScore(infix.charAt(i)) == getPrecedenceScore(stack.peek())
                && associativity(infix.charAt(i)) == 'L';
    }
}
