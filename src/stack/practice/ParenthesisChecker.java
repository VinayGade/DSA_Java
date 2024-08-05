package stack.practice;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {

        // sample input
        //[{()}]
        // {}{(}))}  -> unbalanced
        //  [{()}{()}]

        Scanner sc = new Scanner(System.in);

        //Reading total number of testcases
        int t= sc.nextInt();

        while(t-- >0)
        {
            //reading the string
            String st = sc.next();

            //calling ispar method of Paranthesis class
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(isValidParenthesis(st))
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
    }

    public boolean isValid(String s) {

        String open = "[{(";
        String close = ")}]";

        int n = s.length();

        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (open.contains(String.valueOf(ch)))
                bracketStack.push(ch);
            else if (!bracketStack.isEmpty() &&
                    (bracketStack.peek() == '[' && (ch == ']') ||
                            bracketStack.peek() == '{' && (ch == '}') ||
                            bracketStack.peek() == '(' && (ch == ')')))
                bracketStack.pop();
            else
                return false;
        }
        return bracketStack.isEmpty();

    }

    static boolean isValidParenthesis(String x) {

        String open = "[{(";
        String close = ")}]";

        int n = x.length();

        /*
        base case :
        if (n is odd means either opening or closing parenthesis is missing in x ,
            first character of x contains closing parenthesis ,
            last character of x contains opening parenthesis)
                return false
        * */
        if( n%2 != 0 ||
                close.contains(String.valueOf(x.charAt(0))) ||
                open.contains(String.valueOf(x.charAt(n-1))))
            return false;

        else {

            Stack<Character> bracketStack = new Stack<>();
            for (int i = 0; i < n; i++) {
                char ch = x.charAt(i);
                if (open.contains(String.valueOf(ch)))
                    bracketStack.push(ch);
                else if (!bracketStack.isEmpty() &&
                            bracketStack.peek() == '[' && (ch == ']') ||
                            bracketStack.peek() == '{' && (ch == '}') ||
                            bracketStack.peek() == '(' && (ch == ')'))
                    bracketStack.pop();
                else
                    return false;
            }
            return bracketStack.isEmpty();
        }
    }

    public boolean isValidBrackets(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(map.get(stack.pop()).equals(c)){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // best space and time complexity
    public boolean checkValidParenthesis(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char element : chars) {
            if (element == '(' || element == '[' || element == '{') {
                stack.push(element);
                continue;
            } else if (stack.empty()) {
                return false;
            }
            char top = stack.pop();
            if (top == '(' && element != ')') {
                return false;
            } else if (top == '[' && element != ']') {
                return false;
            } else if (top == '{' && element != '}') {
                return false;
            }
        }
        return stack.empty();
    }
}
