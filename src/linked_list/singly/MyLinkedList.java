package linked_list.singly;

/*
LeetCode 707. Design Linked List

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next.
val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate
the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list.
 If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list.
 After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the
linked list.
If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
* */

public class MyLinkedList {

    Node head;
    int length;

    class Node {
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int get(int index) {
        if(index >= length)
            return -1;
        int i = 0;
        Node temp = this.head;
        while(i < index){
            temp = temp.next;
            i++;
        }
        return temp.val;
    }

    public void traverse(){
        if(isEmpty()){
            System.out.println("Empty Linked List!!");
        }else{
            System.out.println("");
            Node temp = head;
            while(temp!= null){
                System.out.print(temp.val+"->");
                temp = temp.next;
            }
            System.out.print("null");
        }
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
        length++;
    }

    public void addAtTail(int val) {

        if(head == null) {
            addAtHead(val);
        }else {
            Node node = new Node(val);
            Node temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            length++;
        }
    }

    public void addAtIndex(int index, int val) {

        if(index > length || index < 0)
            return;
        if(index == 0)
            addAtHead(val);
        else{
            Node node = new Node(val);
            Node temp = this.head;
            for (int i = 0; i < index - 1; i++) {  // Fix: Stop at index-1
                temp = temp.next;
            }
            //if(i == index){
            node.next = temp.next;  // Fix: Correct order of linking
            temp.next = node;
            length++;
            //}
        }
    }

    public void deleteAtIndex(int index) {

        if(index >= length || index < 0)
            return;

        if (index == 0) { // Remove head
            head = head.next;
            length--;
            return;
        }
        Node temp = this.head;
        int i = 0;
        while (i < index - 1) {  // Fix: Stop at index-1
            temp = temp.next;
            i++;
        }
        if (temp.next != null) { // Fix: Ensure next node exists before deleting
            temp.next = temp.next.next;
        }
        length--;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(20);
        list.addAtHead(10);

        list.traverse();

        list.addAtTail(40);

        list.traverse();

        list.addAtIndex(2, 30);

        System.out.println("\nAfter insertion");

        list.traverse();

        list.addAtTail(50);
        list.addAtTail(80);
        list.addAtTail(90);
        list.addAtTail(100);

        System.out.println("\nAfter insertion at tail");

        list.traverse();

        list.addAtIndex(5, 75);

        list.traverse();

        int nodeData = list.get(5);

        System.out.println("\n5th Node in list :"+nodeData);

        list.deleteAtIndex(5);

        System.out.println("\nAfter deletion");

        list.traverse();

        nodeData = list.get(5);

        System.out.println("\n5th Node in list after deletion :"+nodeData);
    }
}
