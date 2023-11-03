package linked_list.doubly;

public class DoublyLinkedList {

    DoublyLinkedNode first, last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null && last == null);
    }

    public int count(){
        int n = 0;
        if(!isEmpty()) {
            DoublyLinkedNode temp = first;
            while(temp != null){
                n++;
                temp = temp.next;
            }
        }
        return n;
    }

    public int find(int key){
        int loc = -1;
        if(!isEmpty()) {
            int c = 0;
            DoublyLinkedNode temp = first;
            while (temp!=null){
                if(temp.data == key){
                    loc = c;
                    break;
                }
                temp = temp.next;
                c++;
            }
        }
        return loc;
    }

    public boolean contains(int key){

        //int count = 0;
        if(!isEmpty()){

            DoublyLinkedNode temp1=first;
            DoublyLinkedNode temp2=last;

            int n1 = -1;
            int n2 = -1;
            while(temp2.data != n1){

                n1=temp1.data;
                n2=temp2.data;
                if(n1 == n2)
                    return n1==key;
                if(n1==key || n2==key)
                    return true;
                temp1=temp1.next;
                temp2=temp2.prev;
            }
        }
        return false;
    }

    public int size(){

        int count = 0;
        if(!isEmpty()){

            DoublyLinkedNode temp1=first;
            DoublyLinkedNode temp2=last;

            int n1 = -1;
            //int n2 = -1;
            while(temp2.data != n1){

                n1=temp1.data;
                if(n1 == temp2.data)
                    return ++count;

                //n2=temp2.data;
                temp1=temp1.next;
                temp2=temp2.prev;
                count+=2;
            }
        }
        return count;
    }

    public void display(){
        System.out.println("\n Display elements in DLL :\n");
        if(!isEmpty()) {
            DoublyLinkedNode temp = first;
            while(temp != null){
                System.out.print(" -> "+temp.data);
                temp = temp.next;
            }
        }
    }

    public void reverse(){
        if(!isEmpty()) {
            System.out.println("\n Display elements in reverse order :\n");
            if(first == last || first.next == null){
                System.out.print(" first = last = "+first.data);
            }else{
                DoublyLinkedNode temp = last;
                while(temp != null){
                    System.out.print(" <- "+temp.data);
                    temp = temp.prev;
                }
            }
        }
    }

    public int kthFromLast(int k){
        int i = 1;
        int element = -1;
        DoublyLinkedNode temp = last;
        while (temp.prev != null){
            if(i==k) {
                element = temp.data;
                break;
            }
            temp = temp.prev;
        }
        return element;
    }

    public void insertBegin(int data){
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        if(isEmpty()) {
            first = node;
            last = node;
        }else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    public void insertEnd(int data){
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        if(isEmpty()) {
            first = node;
            last = node;
        }else{
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    public void deleteBegin(){
        if(isEmpty())
            System.out.println("List empty !! No element to delete...");
        else if(first == last) {
            first = null;
            last = null;
        }else{
            first = first.next;
            first.prev = null;
        }
    }

    public void deleteEnd(){
        if(isEmpty())
            System.out.println("List empty !! No element to delete...");
        else if(first == last) {
            first = null;
            last = null;
        }else{
            last = last.prev;
            last.next = null;
        }
    }

    // delete node at given index ...index is 1 based (1,2,3,...)
    // returns data of deleted node
    public int deleteAt(int index){

        if(isEmpty())
            return -1;
        else{
            int loc = 1;
            int key = first.data;

            if(first == last && index == 1){  // remove first of list
                first = first.next;
                first.prev = null;
                return key;
            }
            DoublyLinkedNode temp = first;
            DoublyLinkedNode prev = null;
            while (temp!=null){
                if(loc == index){
                    key = temp.data;
                    prev = temp.prev;
                    if(temp.next == null){   //last node

                        prev.next = null;
                        temp.prev = null;
                        temp = null;
                        break;
                    }
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;

                    /*
                    temp.next
                    temp.prev
                    temp.next.prev
                    temp.prev.next
                    */
                    break;
                }
                temp = temp.next;
                loc++;
            }
            return key;
        }

    }

    public int delete(int key){
        int loc = -1;
        if(isEmpty()){
            return loc;
        }else if(first == last){
            if(first.data == key){
                first = null;
                last = null;
                loc = 0;
            }
            return loc;
        } else{
            int c = 0;
            DoublyLinkedNode temp = last;
            while (temp!=null){
                if(temp.data == key){
                    loc = c;

                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    /*
                    temp.next
                    temp.prev
                    temp.next.prev
                    temp.prev.next
                    */
                    break;
                }
                temp = temp.prev;
                c++;
            }
        }
        return loc;
    }

    //public int replace(int key, int value){
    public void replace(int key, int value){
        //int loc = -1;
        //DoublyLinkedNode node = new DoublyLinkedNode(value);
        if(!isEmpty()) {
            //int c = 0;
            DoublyLinkedNode temp = last;
            while (temp!=null){
                if(temp.data == key){
                    temp.data = value;
                    //loc = c;
                    break;
                }
                temp = temp.prev;
                //c++;
            }
        }
        //return loc;
    }

    void insertAfter(int key, int data) {
        DoublyLinkedNode temp = new DoublyLinkedNode(data);
        DoublyLinkedNode t = first;

        if(first == null && last == null) {
            first = last = temp;
            return;
        }
        while(t.next != null) {
            if(t.data == key) {
                temp.prev = t;
                temp.next = t.next;
                t.next.prev = temp;
                t.next = temp;
            }
            t = t.next;
        }
    }

}
