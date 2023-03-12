package stack.exceptions;

public class StackOverflowException extends Exception{

    private static final long serialVersionUID = 9454634685134L;

    @Override
    public String getMessage() {
        System.out.println("StackOverflowException : Can not push element into Stack since it is full !");
        return super.getMessage();
    }
}
