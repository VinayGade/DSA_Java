package stack.exceptions;

public class StackUnderflowException extends Exception{

    private static final long serialVersionUID = 9454634685134L;

    @Override
    public String getMessage() {
        System.out.println("Stack is empty !!");
        return super.getMessage();
    }
}
