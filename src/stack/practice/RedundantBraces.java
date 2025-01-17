package stack.practice;

import java.util.Stack;

/*
Redundant Braces:

Given a string A denoting an expression.
It contains the following operators '+', '-', '*', '/'.

Chech whether A has redundant braces or not.

NOTE: A will be always a valid expression.

Input 1:

 A = "((a+b))"

Input 2:

 A = "(a+(a+b))"

Input 3:

 A = "((a*b)+(c+d))"

Output:
Output 1:

 1

Output 2:

 0

Output 3:

 0
* */

public class RedundantBraces {

    static int braces(String A) {
        int ans=0;
        Stack<Character> s=new Stack<>();
        A=A.trim();
        int l=A.length();
        for(int i=0;i<l;i++)
        {
            char c=A.charAt(i);
            int t=0;
            if(c=='(' && i+2<l && A.charAt(i+2)==')')
                return 1;
            if(c==')')
            {
                while(!s.empty() && s.peek()!='(')
                {
                    s.pop();
                    t++;
                }
                s.pop();
                if(t==0)
                    return 1;
            }
            else s.push(c);
        }
        if(!s.empty() && s.peek()=='(')
            return 1;

        return 0;
    }

    public static void main(String[] args) {
        String A = "((a*b)+(c+d))";
        /*
        A = "(a+(a+b))"
        A = "((a+b))"
        * */
        int redundant = braces(A);
        System.out.println(redundant);
    }
}
