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
}
