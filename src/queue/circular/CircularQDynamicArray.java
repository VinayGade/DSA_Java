package queue.circular;

import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class CircularQDynamicArray {

    private int[] circularQueue;

    private int size, front, rear;

    //Length of array to implement Q
    private static int CAPACITY = 16;   // Default Queue size

    public static final int MIN_CAPACITY = 1 << 15;  // power of 2

    // initialize Q to use array of default length
    public CircularQDynamicArray(){
        circularQueue = new int[CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    // initialize Q to use array of given length
    public CircularQDynamicArray(int capacity){
        circularQueue = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    public int getFront(){
        return circularQueue[front];
    }

    public int getRear(){
        return circularQueue[rear];
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == CAPACITY;
    }

    // Display all elements in Circular Queue
    @Override
    public String toString(){
        String result = "[";
        for(int i=0; i<size; i++){
            result += Integer.toString(circularQueue[(front + i) % CAPACITY]);
            if(i < size-1)
                result += ", ";
        }
        result += "]";
        return result;
    }

    // increase Queue size by double
    private void expand(){
        int length = getSize();
        int[] newCircularQ = new int[length<<1]; // or length * 2

        //copy items
        for(int i=front; i<=rear; i++)
            newCircularQ[i-front] = circularQueue[i%CAPACITY];

        circularQueue = newCircularQ;
        front = 0;
        rear = size - 1;
        CAPACITY *= 2;
    }

    private void shrink(){
        int length = size;
        if(length == MIN_CAPACITY || length << 2 >= length)
            return;

        if(length < MIN_CAPACITY)
            length = MIN_CAPACITY;

        int[] newQueue = new int[length];
        System.arraycopy(circularQueue, 0, newQueue, 0, length+1);
        circularQueue = newQueue;
    }

    // insert element at the rear of the queue
    public void enQueue(int data) throws QueueOverflowException{
        if(size == CAPACITY)
            expand();

        size++;
        circularQueue[rear] = data;
        rear = (rear + 1) % CAPACITY;
    }

    // remove element from font of the queue
    public int deQueue() throws QueueUnderflowException{
        if(size == 0)
            throw new QueueUnderflowException();
        else{
            size--;
            int data = circularQueue[front % CAPACITY];
            circularQueue[front] = Integer.MIN_VALUE;
            front = (front+1) % CAPACITY;
            return data;
        }
    }

    public static void main(String[] args){
        CircularArrayQ circularArrayQ = new CircularArrayQ(); // default CAPACITY

        try {
            // enque 10, 20, 40, 50, 75, 100
            circularArrayQ.enQueue(10);
            circularArrayQ.enQueue(20);
            circularArrayQ.enQueue(40);
            circularArrayQ.enQueue(50);
            circularArrayQ.enQueue(75);

            int front = circularArrayQ.getFront();
            int rear = circularArrayQ.getRear();
            System.out.println("front = "+front+", rear = "+rear);

            circularArrayQ.enQueue(100);
            circularArrayQ.enQueue(150);
            circularArrayQ.enQueue(200);
            circularArrayQ.enQueue(250);
            circularArrayQ.enQueue(300);

            circularArrayQ.enQueue(450);
            circularArrayQ.enQueue(500);
            circularArrayQ.enQueue(750);
            circularArrayQ.enQueue(900);
            circularArrayQ.enQueue(950);

            circularArrayQ.enQueue(1000);

            rear = circularArrayQ.getRear();

            System.out.println("front = "+front+", rear = "+rear);
            System.out.println("size = "+circularArrayQ.getSize());

            String circularQData = circularArrayQ.toString();
            System.out.println(circularQData);

            //circularArrayQ.enQueue(2000); // Queue overflow: size == CAPACITY

            circularArrayQ.deQueue();

            front = circularArrayQ.getFront();
            System.out.println("front = "+front+", rear = "+rear);
            System.out.println("size = "+circularArrayQ.getSize());

            circularArrayQ.deQueue();

            front = circularArrayQ.getFront();
            System.out.println("front = "+front+", rear = "+rear);
            System.out.println("size = "+circularArrayQ.getSize());

            circularArrayQ.deQueue();
            circularArrayQ.deQueue();
            circularArrayQ.deQueue();

            front = circularArrayQ.getFront();
            System.out.println("front = "+front+", rear = "+rear);
            System.out.println("size = "+circularArrayQ.getSize());

            circularQData = circularArrayQ.toString();
            System.out.println(circularQData);


            circularArrayQ.enQueue(2000);
            circularArrayQ.enQueue(2500);

            front = circularArrayQ.getFront();
            rear = circularArrayQ.getRear();
            System.out.println("size = "+circularArrayQ.getSize());
            System.out.println("front = "+front+", rear = "+rear);

            circularArrayQ.enQueue(4000);
            circularArrayQ.enQueue(5000);

            front = circularArrayQ.getFront();
            rear = circularArrayQ.getRear();
            System.out.println("size = "+circularArrayQ.getSize());
            System.out.println("front = "+front+", rear = "+rear);

            System.out.println(circularQData);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
