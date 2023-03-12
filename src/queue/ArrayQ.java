package queue;

class Queue{
    /*
    The queue operations are as follows:

create
enqueue
dequeue
isEmpty
isFull
size

    * */

    int[] queue;
    int capacity;

    int rear, front;

    public int getRear() {
        return queue[rear];
    }

    public int peek() {
        return queue[front];
    }

    public Queue(int n){
        queue = new int[n];
        this.capacity = n;
        front = rear =-1;
    }

    public boolean isEmpty(){
        return rear == -1 || (front>rear);
    }

    public boolean isFull(){
        return rear == capacity;
    }

    public int size(){
        if(isEmpty())
            return 0;
        int count = 0;
        for(int i=front; i<=rear; i++)
            count++;
        return count;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Canot display element, since queue is empty...");
            return;
        }
        System.out.print("front");
        for(int i=front; i<=rear; i++)
            System.out.print("->"+queue[i]);
        System.out.println("->rear");
    }

    public int find(int key){
        if(isEmpty()){
            System.out.println("Canot find element, since queue is empty...");
            return -1;
        }
        int index = 0;
        for(int i=front; i<=rear; i++) {
            if(key == queue[i]){
                index = i;
                break;
            }
        }
        return index;
    }

    public void enque(int data){
       if(isFull()){
           System.out.println("Queue is Full!! Can't insert element...");
           return;
       }
       if(isEmpty())
           front++;

       rear++;
       queue[rear] = data;
    }

    public int deque(){
        if(isEmpty()){
            System.out.println("Canot delete element, since queue is empty...");
        }
        int deleted = queue[front];
        queue[front]=-1;
        front++;
        return deleted;
    }
}

public class ArrayQ {
    public static void main(String[] args) {

        int n =5;
        Queue que = new Queue(n);
        que.enque(10);
        que.enque(20);
        que.enque(30);
        que.enque(50);

        que.display();
        System.out.println("Size of queue ="+que.size());
        System.out.println("element 50 found in queue ="+que.find(50));
        System.out.println("deleted element "+que.deque());
        System.out.println("Size of queue ="+que.size());
        que.enque(100);
        que.display();
        System.out.println("Size of queue ="+que.size());
        System.out.println("queue [ front ] ="+que.peek());
        System.out.println("queue [ rear ] ="+que.getRear());
    }
}


