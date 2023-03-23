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

    public int search(int key){
        if(!isEmpty()){
           int index = -1;
            CircularNode node = last.next;
            while(node != last){
                index++;
                if(key == node.data)
                    return index;
                node = node.next;
            }
        }
        return -1;
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

    public void insertAt(int index, int data){

        CircularNode temp = new CircularNode(data);
        if(isEmpty()){
            last = temp;
            last.next = last;
        }
        else{
            int i = 0;
            CircularNode node = last.next;

            while(i<(index-1)){
                node = node.next;
                i++;
            }
            temp.next = node.next;
            node.next = temp;
            /*
            while(node != last){
                i++;
                if(index == (i-1)) {
                    temp.next = node.next;
                    node.next = temp;
                }
                node = node.next;
            }
             */
        }
    }

    public void insertAfter(int key, int data){
        CircularNode temp = new CircularNode(data);
        if(isEmpty()){
            last = temp;
            last.next = last;
        }else if(last.next == null){
            last.next = temp;
            temp.next = last;
        }else{

            CircularNode node = last.next;
            while(node != last){

                if(key == node.data){

                    temp.next = node.next;
                    node.next = temp;
                }
                node = node.next;
            }
        }
    }

    public int delete(int key){
        if(isEmpty())
            return -1;
        else{
            //Fixed : fix return index of node instead of data
            int index = -1;
            CircularNode node = last.next;
            CircularNode prev = last;
            if(last.data==key){
                CircularNode temp = last;
                //int deleted = last.data;
                while(temp.next != last){
                    temp = temp.next;
                    index++;
                }
                temp.next = last.next;
                last = temp;
                return index;
            }else {
                while (node != last) {
                    index++;
                    if (key == node.data) {
                        prev.next = node.next;
                        return index;
                    }
                    prev = node;
                    node = node.next;
                }
            }
        }
        return -1;
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

            return deleted;
        }
    }

    //Delete node at index and returns data of deleted node
    public int deleteAt(int index){
        if(isEmpty()){
            System.out.println("Circular List Empty !! cannot delete element...");
            return -1;
        }else if(last.next == null){
            int deleted = last.data;
            last = null;
            return deleted;
        }else{
            int i = -1;
            CircularNode node = last.next;
            CircularNode prev = last;
            while(node != last){
                i++;
                if(i == index) {
                    int deleted = node.data;
                    prev.next = node.next;
                    return deleted;
                }
                prev = node;
                node = node.next;
            }
            return -1;
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