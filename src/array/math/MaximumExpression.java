package array.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
CodeChef: Maximum Expression
You are given a string
𝑆
S of length
𝑁
N, consisting of the digits 0-9 and the characters '+' and '-'.
𝑆
S represents a valid mathematical expression.

Rearrange the characters of
𝑆
S to form a valid mathematical expression such that the result obtained upon evaluating
it is maximum.

If there are multiple possible answers, you may print any of them.

Note: A string
𝑆
S of length
𝑁
N is said to be a valid mathematical expression if the following hold:

The first character of
𝑆
S is not + or -.
The last character of
𝑆
S is not + or -.
Any + or - in
𝑆
S must not be adjacent to another + or -.
In particular, numbers are allowed to have leading zeros, and adding/subtracting zero is fine.

Input Format
The first line of input will contain a single integer
𝑇
T, denoting the number of test cases.
Each test case consists of
2
2 lines of input.
The first line of each test case contains a single integer
𝑁
N, denoting the size of the string.
The second line of each test case contains the string
𝑆
S.
Output Format
For each test case, output on a new line the rearranged string giving the maximum value
upon evaluation. If there are multiple possible answers, you may print any of them.


* */

/*
input:
3
7
4-89+20
5
5-9+0
3
9-5

output:
984+2-0
5+9-0
9-5
* */

public class MaximumExpression {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int len = sc.nextInt();
            String s = sc.next();
            int plusCount = 0;
            int minusCount = 0;
            List<Character> digitList = new ArrayList<>();
            for(int i=0;i<len;i++) {
                if(Character.isDigit(s.charAt(i))) {
                    digitList.add(s.charAt(i));
                } else if(s.charAt(i) == '+') {
                    plusCount += 1;
                } else if(s.charAt(i) == '-') {
                    minusCount += 1;
                }
            }

            digitList.sort(Collections.reverseOrder());

            StringBuilder sb = new StringBuilder();
            int idx = digitList.size()-1;

            while(idx >= 0 && minusCount > 0) {
                sb.append(digitList.get(idx));
                sb.append('-');
                minusCount -= 1;
                idx -= 1;
            }

            while(idx >= 0 && plusCount > 0) {
                sb.append(digitList.get(idx));
                sb.append('+');
                plusCount -= 1;
                idx -= 1;
            }

            while(idx >= 0) {
                sb.append(digitList.get(idx));
                idx -= 1;
            }

            System.out.println(sb.reverse());
        }
    }
}
