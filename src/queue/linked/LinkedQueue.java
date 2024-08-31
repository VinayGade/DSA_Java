package queue.linked;

import linked_list.singly.Node;
import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class LinkedQueue {

    private int length;
    private Node front, rear;

    private final int CAPACITY = 16;

    public boolean isEmpty(){
        return length == 0;
    }

    public boolean isFull(){
        return length == CAPACITY;
    }

    public int size(){
        return length;
    }

    //create empty Queue
    public LinkedQueue(){
        length = 0;
        front = rear = null;
    }

    //insert element at rear of q
    public void enqueue(int data) throws QueueOverflowException {
        Node node = new Node(data);
        if(isEmpty())
            front = node;
        else if(isFull())
            throw new QueueOverflowException();
        else
            rear.setNext(node);
        rear = node;
        length++;
    }

    //remove element from the front of q
    public int dequeue() throws QueueUnderflowException{
        if(isEmpty())
            throw new QueueUnderflowException();
        int key = front.getData();
        front = front.getNext();
        length--;
        if(isEmpty())
            rear = null;
        return key;
    }

    public int getFirst() throws QueueUnderflowException{
        if(isEmpty())
            throw new QueueUnderflowException();

        return front.getData();
    }

    public int getRear() throws QueueUnderflowException{
        if(isEmpty())
            throw new QueueUnderflowException();

        return rear.getData();
    }

    @Override
    public String toString(){
        String result = "";
        Node current = front;
        while(current != null){
            result = result + current.getData() + "\n";
            current = current.getNext();
        }
        return result;
    }

    public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {

        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(75);
        queue.enqueue(100);
        queue.enqueue(250);
        queue.enqueue(500);

        queue.toString();

        int frontData = queue.getFirst();
        int rearData = queue.getRear();
        System.out.println("front = "+frontData+", rear = "+rearData);
        String qData = queue.toString();
        System.out.println(qData);
        queue.dequeue();
        queue.dequeue();

        frontData = queue.getFirst();
        System.out.println("front = "+frontData+", rear = "+rearData);
        qData = queue.toString();
        System.out.println(qData);
    }
}
