package stack.array;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

public class ArrayStack {

    int stack[];
    int top;
    int capacity;

    ArrayStack(int capacity){
        stack = new int[capacity];
        this.capacity = capacity;
        top = -1;
    }

    boolean isEmpty(){
        return top == -1;
    }

    int size(){
        if(isEmpty())
            return 0;

        return top+1;
    }

    public void push(int x) throws StackOverflowException {
        if(this.capacity == size())
            throw new StackOverflowException();
        else {
            top++;
            stack[top] = x;
        }
    }

    int pop() throws StackUnderflowException {
        if(isEmpty())
            throw new StackUnderflowException();
        else{
            int deleted = stack[top];
            stack[top]=-1;
            top--;
            return deleted;
        }
    }

    int peek() throws StackUnderflowException{
        if(isEmpty())
            throw new StackUnderflowException();
        else
            return stack[top];
    }

    void display() throws StackUnderflowException{
        if(isEmpty())
            throw new StackUnderflowException();
        for(int i=0; i<=top; i++) {
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }

    void destroy() throws StackUnderflowException{
        while(top != -1){
            stack[top] = -1;
            top--;
        }
    }

}