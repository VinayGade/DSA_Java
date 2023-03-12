package queue.stack;

public class QueUsingStack {

    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);

        System.out.println("Pop Q data in FIFO manner :");

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
