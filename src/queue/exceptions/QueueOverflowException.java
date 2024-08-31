package queue.exceptions;

public class QueueOverflowException extends Exception{
    public QueueOverflowException(){
        super("Queue overflow!! Queue is Full, hence element can't be inserted.");
    }

    public QueueOverflowException(String msg){
        super(msg);
    }
}
