package stack.array;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {

        Scanner scanner = new Scanner(System.in);

        ArrayStack stack =new ArrayStack(10);

        System.out.println("Stack is empty?"+stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(80);
        stack.push(100);

        System.out.println("Stack size = "+stack.size());

        System.out.println("Display Stack");

        stack.display();

        System.out.println("top of stack = "+stack.peek());

        System.out.println("pop element from top of stack = "+stack.pop());

        System.out.println("pop element from top of stack = "+stack.pop());
        System.out.println("pop element from top of stack = "+stack.pop());

        System.out.println("Stack size = "+stack.size());

        System.out.println("Display Stack");

        stack.display();

        System.out.println("Stack is empty?"+stack.isEmpty());

        stack.destroy();

        System.out.println("Stack size = "+stack.size());

        System.out.println("Stack is empty?"+stack.isEmpty());

    }
}
