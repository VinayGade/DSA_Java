package queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    // Function to reverse the queue using a stack
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Dequeue all elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Pop all elements from the stack and enqueue them back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Create a queue and add elements
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Display original queue
        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Display reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}
