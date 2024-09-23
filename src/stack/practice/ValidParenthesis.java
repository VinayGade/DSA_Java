package stack.practice;

import java.util.Scanner;
import java.util.Stack;

/*
string s containing only ( )
find s is valid parenthesis str

3
()(())    1
(()()     0
))((      0
* */
public class ValidParenthesis {

    public static boolean isValidParenthesis(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();  // consume newline character after integer input

        for (int i = 0; i < T; i++) {
            String S = scanner.nextLine();
            System.out.println(isValidParenthesis(S) ? 1 : 0);
        }
        scanner.close();
    }
}
