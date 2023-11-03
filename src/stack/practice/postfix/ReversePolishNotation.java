package stack.practice.postfix;

import java.util.Stack;

// Leetcode 150. Evaluate Reverse Polish Notation
// evaluate postfix expression
public class ReversePolishNotation {

    // 2 1+3* ==> ((2 + 1) * 3) = 9
    // 4 13 5 / + ==> (4 + (13 / 5)) = 6

    /*

    Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

    * */

    public static int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {

            switch (s){
                case "+":
                    stack.add(stack.pop()+stack.pop());
                    continue;

                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a / b);
                    continue;

                case "*":
                    stack.add(stack.pop() * stack.pop());
                    continue;

                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a - b);
                    continue;

                default:
                    stack.add(Integer.parseInt(s));

            }
            //old

            /*
            Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}
		return S.pop();
            * */

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2","1","+","3","*"};
        String[] tokens2 = {"4","13","5","/","+"};
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        int value1 = evalRPN(tokens1);
        int value2 = evalRPN(tokens2);
        int value3 = evalRPN(tokens3);

        System.out.println("value1 = "+value1);
        System.out.println("value2 = "+value2);
        System.out.println("value3 = "+value3);
    }

}
