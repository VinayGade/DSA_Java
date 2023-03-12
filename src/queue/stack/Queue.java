package queue.stack;

import java.util.Stack;

public class Queue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public int remove(){
        if(stack1.isEmpty())
            return -1;
        return stack1.pop();
    }

    public int peek(){
        if(stack1.isEmpty())
            return -1;
        return stack1.peek();
    }

    public void add(int data){
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());

        stack1.push(data);

        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
    }
}
