package array.math;

// CodeChef: interview-dsa : Make Valid

/*

A string consisting only of parentheses '(' and ')' is called a bracket sequence.
Some bracket sequences are called correct bracket sequences. More formally:

An empty string is a correct bracket sequence.

If a string S is a correct bracket sequence, then the string
(S) is also a correct bracket sequence.

If strings S and T are correct bracket sequences, then the string
ST is also correct bracket sequence.

You are given a string
S consisting of parentheses ('(' and ')') and lowercase letters 'x'. Each letter 'x' in S
can either be replaced by a single parenthesis ('(' or ')') or be removed from S.
You need to find if it is possible to obtain a correct bracket sequence from S
by transforming it in such a way.
* */

/*

input:
4
(())
(xx))
xxxxx
xx)))

output:
1110
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeValid {

    public static void main(String[] args) throws java.lang.Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while(T-- > 0){

            String S = br.readLine();
            char valid = canMakeValid(S) ? '1' : '0';
            result.append(valid);
        }
        System.out.println(result);
    }

    static boolean canMakeValid(String s){

        int minOpen = 0, maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen = Math.max(0, minOpen - 1);
                maxOpen--;
            } else { // c == 'x'
                minOpen = Math.max(0, minOpen - 1);
                maxOpen++;
            }
            if (maxOpen < 0) {
                return false;
            }
        }
        return minOpen == 0;
    }
}
