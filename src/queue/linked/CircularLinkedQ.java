package queue.linked;

public class CircularLinkedQ {

    // Java program to implement a Circular Queue using Linked List
    // Node class representing each element in the queue
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front = null;
    private Node rear = null;

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue operation to add an element to the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        rear.next = front; // Point rear to front to maintain circular nature
    }

    // Dequeue operation to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int value = front.data;
        if (front == rear) {
            // If there's only one node
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front; // Adjust rear.next to point to the new front
        }
        return value;
    }

    // Display the elements in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node temp = front;
        System.out.print("Circular Queue elements: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedQ queue = new CircularLinkedQ();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        // Display the queue
        queue.displayQueue();

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Display the queue again
        queue.displayQueue();

        // Enqueue more elements
        queue.enqueue(50);
        queue.enqueue(60);

        // Display the final queue
        queue.displayQueue();
    }
}

