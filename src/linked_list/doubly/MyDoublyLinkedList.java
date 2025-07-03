package linked_list.doubly;


// LeetCode 707. Design Linked List

// Refer singly.MyLinkedList for problem statement

public class MyDoublyLinkedList {

    private Node head, tail;
    private int length;

    class Node {
        int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }

    public MyDoublyLinkedList() {
        this.head = new Node(0); // Sentinel head
        this.tail = new Node(0); // Sentinel tail
        head.next = tail;
        tail.prev = head;
        length = 0;
    }

    public boolean isEmpty(){
        return this.head == null && this.tail == null;
    }

    public int get(int index) {
        if (index < 0 || index >= length) return -1;
        Node curr = getNode(index);
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void removeAtHead(){
        deleteAtIndex(0);
    }

    public void removeAtTail(){
        deleteAtIndex(length-1);
    }

    public void addAtIndex(int index, int val) {
        if (index > length || index < 0) return;
        Node prevNode = (index == 0) ? head : getNode(index - 1);
        Node nextNode = prevNode.next;
        Node newNode = new Node(val);

        // Insert newNode between prevNode and nextNode
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return;
        Node delNode = getNode(index);
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
        length--;
    }

    private Node getNode(int index) {
        Node curr;
        if (index < length / 2) {
            curr = head.next; // Start from head
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail.prev; // Start from tail
            for (int i = length - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }
}
