package linked_list.singly.circular;

import linked_list.singly.Node;

public class CircularLinkedList {

    private Node last;

    public CircularLinkedList(){
        last = null;
    }

    public boolean isEmpty(){
        return last == null;
    }

    public int size(){
        if(isEmpty())
            return 0;
        else
            return 1;
    }

    public void traverse(){
        if(isEmpty())
            return;
        else{
            Node first = last.getNext();

            System.out.println("first ");
            while(first != last){
                System.out.print(" -> "+first.getData());
                first = first.getNext();
            }
            System.out.println(first.getData()+" -> last");
        }
    }
}
