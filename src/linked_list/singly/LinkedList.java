package linked_list.singly;

public class LinkedList {

    private Node head;

    public LinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void traverse(){
        if(isEmpty()){
            System.out.println("Empty Linked List!!");
        }else{
            System.out.println("");
            Node temp = head;
            while(temp!= null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.print("null");
        }
    }

    public int find(int key){
        int location = -1;
        int i =0;
        if(!isEmpty()){
            Node temp = head;
            while(temp!= null){
                if(temp.data == key) {
                    location = i;
                    break;
                }
                i++;
                temp = temp.next;
            }
        }
        return location;
    }

    public int count(){
        int n = 0;
        if(!isEmpty()) {

            Node temp = head;
            while (temp != null) {
                n++;
                temp = temp.next;
            }
        }
        return n;
    }

    public void insertBegin(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void insertEnd(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            head = temp;
        }else{
            Node node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = temp;
        }
    }

    public void insertAt(int data, int index){
        Node temp = new Node(data);
        if(isEmpty() || index > count()){
            System.out.println("Can't insert");
        }else{
            Node node = head;
            /*
            while(--index > 0)
                node = node.next;
             */

            int i = 0;
            while(i<(index-1)){
               node = node.next;
                i++;
            }
            //Node next = node.next;

            temp.next = node.next;
            node.next = temp;
        }
    }

    public void insertAfter(int data, int element) {
        Node temp = new Node(data);
        if(isEmpty()){
            head = temp;
        }

    }

    public int deleteBegin(){
        if(isEmpty()){
            System.out.println("Empty Linked List!!");
        }
        /*else if(head.next == null){
            head = null;
        }else{*/
            int deleted = head.data;
            head = head.next;
            return deleted;
        //}
    }

    public int deleteEnd(){
        if(isEmpty()){
            System.out.println("Empty Linked List!!");
            return -1;
        }else if(head.next == null){
            int deleted = head.data;
            head = null;
            return deleted;
        }else{
            Node temp = head;

            while(temp.next.next != null){
                temp = temp.next;
            }
            int deleted = temp.next.data;
            temp.next = null;
            return deleted;
        }
    }

    public int deleteAt(int index){
        if(isEmpty()){
            System.out.println("Empty Linked List!!");
            return -1;
        }else{
            int i = 0;
            Node temp = head;
            while(i<(index-1)){
                temp = temp.next;
                i++;
            }
            Node deleted = temp.next;
            temp.next = deleted.next;
            return deleted.data;
        }
    }

    public int deleteElement(int element) {
        if(isEmpty()){
            System.out.println("Empty Linked List!!");
            return -1;
        }else{
            Node temp = head;
            Node deleted = temp;
            while(temp != null){
                if(temp.next.data == element){
                    deleted = temp.next;
                    temp.next = deleted.next;
                    break;
                }
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Element not found ");
                return -1;
            }else
                return deleted.data;
        }
    }

    public void replace(int key, int data){       // Replace key with data
        //LinkedNode node = new LinkedNode(data);
        if(isEmpty())
            System.out.println("Empty Linked List!!");
        Node temp = head;
        while(temp!=null) {
            if(temp.data == key) {
                temp.data = data;
                break;
            }
            temp=temp.next;
        }
        if(temp == null)
            System.out.println("Element not found ");
    }

    public void reverseIter() {

        //tricky

        if (isEmpty())
            System.out.println("List Empty !! Cannot reverse");
        else if(head.next == null)
            return;

        Node q = null;
        Node p = head;
        Node r;

        while(p != null) {
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }

        head = q;
    }

    public Node recursiveReverse(Node head){
        Node node = head;

        if (isEmpty()) {
            System.out.println("List Empty !! Cannot reverse");
        }

        else if (head.next == null) {
            return head;
        }

        Node remaining = recursiveReverse(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }

    /*
    Solution: Apna College | Java Placement Course
    3 nodes : current   next   previous
    next = current.previous
    prev = current.prev
    * */

    public Node reverseRecursive(Node head){ //returns head

        if(isEmpty() || head.next == null)
            return head;

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void reverse(/*Node head*/){

        if(isEmpty() || head.next == null)
            return;

        Node previous = head;
        Node current = head.next;

        while(current != null){
            Node next = current.next;
            current.next = previous;

            // update 3 nodes : current, next, previous
            previous = current;
            current = next;
        }

        head.next = null;
        head = previous;
        /*
         after completion of iteration , current = last node = null
            hence previous (= current.previous ) => head
         */
    }

    Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node middle = middleElement(head);
        Node nextofMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextofMiddle);

        Node sortdList = merge(left, right);

        return sortdList;
    }

    Node merge(Node left, Node right) {
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }
        Node temp = null;
        if(left.data < right.data) {
            temp = left;
            temp.next = merge(left.next, right);
        } else {
            temp = right;
            temp.next = merge(left, right.next);
        }

        return temp;
    }

    Node middleElement(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node removeDuplicates(Node head) {

        // do nothing if the list is empty
        if (head == null) {
            return null;
        }

        Node current = head;

        // compare the current node with the next node
        while (current.next != null)
        {
            if (current.data == current.next.data)
            {
                Node nextNext = current.next.next;
                current.next = nextNext;
            }
            else {
                current = current.next;    // only advance if no deletion
            }
        }

        return head;

    }
}
