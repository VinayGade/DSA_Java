package stack.practice;

import java.util.Scanner;
import java.util.Stack;

//CodeChef: Stack and Queues:

/*
For an expression to be valid, a “<” symbol must always have a corresponding “>” character
somewhere (not necessary immediately) after it. Moreover, each “>” symbol should correspond
to exactly one “<” symbol.

So, for instance, the instructions:
<>
<>
<><>

are all valid. While:
>>
><><
are not.

Given some expressions which represent some instructions to be analyzed, you should tell
the length of the longest prefix of each of these expressions that is valid,
or 0 if there's no such a prefix.
* */

/*
input:
3
<<>>
><
<>>>

Output:
4
0
2
* */
public class CompilersParsers {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character

        for (int i = 0; i < n; i++) {
            String expression = scanner.nextLine();
            int count = compile(expression);
            System.out.println(count);
        }
    }

    static int compile(String expression) {

        int maxValidLength = 0;
        int currentLength = 0;
        char[] exp = expression.toCharArray();
        Stack<Character> symbols = new Stack<>();

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '<') {
                symbols.push('<');
            } else if (exp[i] == '>') {
                if (!symbols.isEmpty() && symbols.peek() == '<') {
                    symbols.pop();
                    currentLength += 2; // Increment by 2 as we have matched a pair
                    if (symbols.isEmpty()) {
                        maxValidLength = currentLength;
                    }
                } else {
                    break;
                }
            }
        }
        return maxValidLength;
    }
}
