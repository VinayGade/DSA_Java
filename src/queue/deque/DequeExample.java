package queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {

    public static void main(String[] args) {
        // Declaration of deque
        Deque<Integer> myDeque = new ArrayDeque<>();

        // Adding elements to the front and rear of the deque
        myDeque.addFirst(3);
        myDeque.addLast(2);
        myDeque.addFirst(1);

        // Displaying the elements of the deque
        System.out.print("Deque: ");
        for (int element : myDeque) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Removing elements from the front and rear of the deque
        int frontElement = myDeque.removeFirst();
        int rearElement = myDeque.removeLast();

        // Displaying the elements after removal
        System.out.println("Removed from front: " + frontElement);
        System.out.println("Removed from rear: " + rearElement);

        // Displaying the updated deque
        System.out.print("Updated Deque: ");
        for (int element : myDeque) {
            System.out.print(element + " ");
        }
        System.out.println();

        Deque<String> deque2
                = new LinkedList<String>();

        // We can add elements to the queue
        // in various ways

        // Add at the last
        deque2.add("Element 1 (Tail)");

        // Add at the first
        deque2.addFirst("Element 2 (Head)");

        // Add at the last
        deque2.addLast("Element 3 (Tail)");

        // Add at the first
        deque2.push("Element 4 (Head)");

        // Add at the last
        deque2.offer("Element 5 (Tail)");

        // Add at the first
        deque2.offerFirst("Element 6 (Head)");

        System.out.println(deque2 + "\n");

        // We can remove the first element
        // or the last element.
        deque2.removeFirst();
        deque2.removeLast();
        System.out.println("Deque after removing "
                + "first and last: "
                + deque2);

        Deque<Integer> deq3 = new ArrayDeque<>();

        System.out.println("\nDeque 3");

        deq3.push(100);
        System.out.println(deq3.peek());
        deq3.pop();
        deq3.push(50);
        deq3.addFirst(40);
        deq3.push(30);
        deq3.push(20);
        deq3.addFirst(10);
        deq3.addLast(100);
        System.out.println("deq3.contains(50) : "+deq3.contains(50));
        Iterator<Integer> deqIterator = deq3.descendingIterator();
        while(deqIterator.hasNext()){
            System.out.println(deqIterator.next());
        }

        System.out.println("deq3.pop() :"+deq3.pop()); // removes 10

        deq3.addFirst(10);

        System.out.println("deq3.pollLast() :"+deq3.pollLast()); // removes 100

        deq3.offerFirst(5);
        deq3.offerLast(100);

        deq3.addLast(110);
        deq3.offerLast(120);

        System.out.println("deq3.peekFirst() : "+deq3.peekFirst());
        System.out.println("deq3.peekLast() : "+deq3.peekLast());

        System.out.println("B4 deletion :");
        deq3.forEach(System.out::println);

        System.out.println("modification :");
        System.out.println("deq3.poll() : "+ deq3.poll());
        System.out.println("deq3.pollFirst() : "+ deq3.pollFirst());
        System.out.println("deq3.pollLast() : "+ deq3.pollLast());

        System.out.println("deq3.removeFirst() : "+ deq3.removeFirst());
        System.out.println("deq3.removeLast() : "+ deq3.removeLast());

        deq3.offerLast(200);

        Iterator<Integer> deqIterator3 = deq3.descendingIterator();
        while(deqIterator3.hasNext()){
            System.out.println(deqIterator3.next());
        }

        System.out.println("deq3.pop() :"+deq3.pop());
    }
}