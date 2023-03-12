package stack.linked;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

public class LinkedStack {

    private int capacity;
    private Node top; // top of stack...

    LinkedStack() {
        top = null;
    }

    LinkedStack(int capacity){
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size(){

        int count = 0;
        if(isEmpty())
            return  count;
        Node temp = top;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void display(){
        if(isEmpty())
            return;
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public int pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException();

        int tos = top.data;
        if (top.next == null) {
            top = null;// empty stack
        }else {
            top = top.next;
        }
        return tos;
    }

    public int peek() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException();
        return top.data;
    }

    public void push(int value) throws StackOverflowException {
        if(capacity == size())
            throw new StackOverflowException();

        Node temp = new Node(value);

        if(top == null)     //Stack empty
            temp.next = null;
        else
            temp.next = top;
        top = temp;
    }

    public void destroy() throws StackUnderflowException {
        while(top != null)
            pop();
    }

}