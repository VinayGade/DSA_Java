package linked_list.singly.circular;

import linked_list.singly.Node;

public class CircularLinkedList {

    private CircularNode last;

    public CircularLinkedList(){
        last = null;
    }

    public boolean isEmpty(){
        return last == null;
    }

    public int size() {
        if(isEmpty())
            return 0;
        else {
            int length=1;
            CircularNode first = last.next;

            //System.out.println("first ");
            while(first != last) {
                //System.out.print(" -> " + first.data);
                first = first.next;
                length++;
            }
            return length;
        }
    }

    public void traverse(){
        if(isEmpty())
            return;
        else{
            CircularNode first = last.next;

            System.out.print("\nfirst");
            while(first != last){
                System.out.print("->"+first.data);
                first = first.next;
            }
            System.out.println("->"+first.data+"->last");
        }
    }

    public void insertBegin(int data){

        // if Circular list is empty same logic will work to add new node in it
        // since very first node could be added only at begin

        CircularNode temp = new CircularNode(data);

        if(isEmpty())
            last = temp;
        else
            temp.next = last.next;

        last.next = temp;
    }

    public void insertEnd(int data){

        // if Circular list is empty same logic will work to add new node in it
        // since very first node could be added only at begin

        CircularNode temp = new CircularNode(data);

        if(isEmpty()){
            last = temp;
            last.next = last;
        }
        else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    public int deleteBegin(){
        // returns data of deleted element

        if(isEmpty()){
            System.out.println("Circular List Empty !! cannot delete element...");
            return -1;
        }else{
            CircularNode temp = last.next;
            int deleted = temp.data;
            if(last.next == last)
                last = null;
            else
                last.next = temp.next;

            //temp.next = null;
            temp = null;
            return deleted;
        }
    }

    public int deleteEnd(){
        if(isEmpty()){
            System.out.println("Circular List Empty !! cannot delete element...");
            return -1;
        }else{
            CircularNode temp = last;
            int deleted = last.data;
            while(temp.next != last){
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
            return deleted;
        }
    }
}
