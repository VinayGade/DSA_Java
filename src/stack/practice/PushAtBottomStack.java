package stack.practice;

import java.util.Stack;

public class PushAtBottomStack {

    public Stack<Integer> pushAtBottom(Stack<Integer> stack, int data){

        Stack<Integer> auxiliaryStack = new Stack<>();
        Stack<Integer> solutionStack = new Stack<>();

        while(!stack.isEmpty()){
            auxiliaryStack.push(stack.pop());
        }

        auxiliaryStack.push(data);

        while(!auxiliaryStack.isEmpty()){
            solutionStack.push(auxiliaryStack.pop());
        }

        return solutionStack;
    }

    // Recursive way
    public void pushAtBottomRec(Stack<Integer> stack, int data){

        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottomRec(stack, data);
        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        //push 100 at bottom of stack ... i.e tos won't change tos = 40

        PushAtBottomStack finalStack = new PushAtBottomStack();

        /*

        Stack<Integer> solution = finalStack.pushAtBottom(stack, 100);

        while(!solution.isEmpty()){
            System.out.println(solution.peek());
            solution.pop();
        }

        */

        finalStack.pushAtBottomRec(stack, 100);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
