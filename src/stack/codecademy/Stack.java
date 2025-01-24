package stack.codecademy;

public class Stack {

    public LinkedList stack;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(String data) {
        if (this.hasSpace()) {
            this.stack.addToHead(data);
            this.size++;
        } else {
            throw new Error("Stack is full!");
        }

    }

    public String pop() {
        if (!this.isEmpty()) {
            String data = this.stack.removeHead();
            this.size--;
            return data;
        } else {
            throw new Error("Stack is empty!");
        }
    }

    public String peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.stack.head.data;
        }
    }
}
