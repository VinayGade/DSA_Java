package queue.exceptions;

public class QueueUnderflowException extends Exception{

    public QueueUnderflowException(){
        super("Queue Underflow!! Queue is empty, hence element can't deleted.");
    }

    public QueueUnderflowException(String msg){
        super(msg);
    }
}
