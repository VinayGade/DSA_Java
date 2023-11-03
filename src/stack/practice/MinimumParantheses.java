package stack.practice;

import java.util.Scanner;
import java.util.Stack;

public class MinimumParantheses {

    /*
     A = "())"   Output 1: 1
     A = "((("   Output 2: 3
     A : ")))))(" expected Output 3: 6  output: 2
     A : "())()()()))())())"  expected Output 4: 5  output: 1

     Explanation 1: One '(' is required at beginning.
     Explanation 2: Three ')' is required at end.

    * */
    private static int validateParenthesis(String x) {
        int n = x.length();
        if(x.startsWith(")"))
            return n;
        char open = '(';
        char close = ')';
        int correction = 0;
        for (int i = 0; i < n; i++) {
            char ch = x.charAt(i);
            if (open==ch)
                correction++;
            else
                correction = ( correction > 0 && (ch == close)) ? correction-1 : correction+1;
        }
        return correction;
    }

    private static int validParenthesisCorrection(String A) {
        Stack<Character> s = new Stack<>();
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '(')
                s.push('(');
            else if(!s.isEmpty() && A.charAt(i) == ')')
                s.pop();
            else
                count++;
        }
        return s.size() + count;
    }

    // LeetCode 921. Minimum Add to Make Parentheses Valid
    private static int minimumAddToMakeParenthesisValid(String s) {

        // most optimum solution without using stack
        int left = 0;
        int right = 0;
        for(char c: s.toCharArray()){
            if(c == '(')
                left++;
            else{
                if(left > 0)
                    left--;
                else
                    right++;
            }
        }
        return left+right;
    }

    public static void main(String[] args) {

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
            int validation = minimumAddToMakeParenthesisValid(st);

            System.out.println("Minimum Number of parenthesis to validate = "+validation);
        }
    }
}
