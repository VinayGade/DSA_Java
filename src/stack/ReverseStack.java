package stack;

import java.util.Stack;

public class ReverseStack {

    public void pushAtBottom(Stack<Integer> stack, int data){

        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public void reverse(Stack<Integer> stack){

        if(stack.isEmpty())
            return;
        int top = stack.pop();
        reverse(stack);
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        ReverseStack reverseStack = new ReverseStack();

        reverseStack.reverse(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
