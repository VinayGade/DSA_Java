package stack.linked;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

import java.util.Scanner;

public class LinkedStackDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedStack linkedStack = new LinkedStack();

        System.out.println("Enter Stack capacity :");
        linkedStack.setCapacity(scanner.nextInt());

        int choice;

        do {

            System.out.println("Enter Stack operation choice :");

            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Empty");
            System.out.println("6. Size");
            System.out.println("7. Destroy");
            System.out.println("8. EXIT");

            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Insert element to push:");
                    int x = scanner.nextInt();
                    try {
                        linkedStack.push(x);
                    } catch (StackOverflowException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Pop element from top of stack:");
                    int key;
                    try {
                        key = linkedStack.pop();
                        System.out.println("Removed element :"+key);
                    } catch (StackUnderflowException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Peek into element from top of stack:");
                    int data;
                    try {
                        data = linkedStack.peek();
                        System.out.println("Peek element :"+data);
                    } catch (StackUnderflowException e) {

                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("Display entire stack:");
                    linkedStack.display();
                    break;


                case 5: //empty
                    System.out.println("Stack is empty ? "+linkedStack.isEmpty());
                    break;

                case 6: //size
                    System.out.println("Stack size :"+linkedStack.size());
                    break;

                case 7: //destroy
                    System.out.println("Destroying complete Stack");
                    try {
                        linkedStack.destroy();
                    } catch (StackUnderflowException e) {
                        e.printStackTrace();
                    }
                    break;

                case 8:	break;

            }

        } while(choice != 8);  //while(choice <= 8);

        scanner.close();
    }
}
