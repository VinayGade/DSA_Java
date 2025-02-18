package linked_list.singly;

import linked_list.doubly.DoublyLinkedNode;

import java.util.*;

public class LinkedList {

    private Node head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(int data){
        this.head = new Node(data);
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Node getHead(){
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
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

    public int search(int index){
        int i = 1;
        int key = -1;
        Node temp = head;
        while(temp!=null){
            if(index == i){
                key = temp.data;
                break;
            }
            temp=temp.next;
            i++;
        }
        return key;
    }

    public int fastSearch(int index){
        int i = 1;
        int key = -1;
        Node fast = head;
        Node slow = head;

        while(fast!=null){
            if((index+1) == i) {
                key=slow.data;
                break;
            }if(index == i){
                key = fast.data;
                break;
            }
            slow=fast.next;
            fast=fast.next.next;
            i+=2;
        }
        return key;
    }

    public int size(){
        if(head == null)
            return 0;
        /*
        if(head.next == null)
            return 1;
        */
        Node fast = head;
        int count = 1;
        while (fast.next != null) {
            if(fast.next.next == null){
                count++;
                break;
            }
            fast = fast.next.next;
            count+=2;
        }
        return count;
    }

    public int size(Node head) {
        if (head == null)
            return 0;
        Node fast = head;
        int count = 1;
        while (fast.next != null) {
            if (fast.next.next == null) {
                count++;
                break;
            }
            fast = fast.next.next;
            count += 2;
        }
        return count;
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

    public boolean isLengthEven(Node head) {

        if(head == null)
            return true;

        Node fast = head;

        int count = 1;
        while (fast.next != null) {
            if(fast.next.next == null){
                count++;
                break;
            }
            fast = fast.next.next;
            count+=2;
        }
        return ((count%2) == 0);
    }

    public boolean isLengthEvenOptimized(Node head) {
        // Fast pointer
        Node temp=head;
        while(temp != null && temp.next != null){
            temp = temp.next.next;
        }
        return temp == null;
    }

    public boolean isLengthEven2(Node head) {
        // code here
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return (count%2==0);
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
        }else {
            Node curr = head;
            Node prev = curr;
            while (curr != null) {
                if (curr.data == element) {
                    prev.next = temp;
                    temp.next = curr;
                    break;
                }
                prev = prev.next;
                curr = curr.next;
            }
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

    void deleteAll(/*Node head*/){
        Node temp = head;
        while(temp!=null){
            int deleted = deleteBegin();
            System.out.println("Deleted node "+deleted+" from list");
            temp=temp.next;
        }
    }

    public int kthFromLast(int k){
        //brute force
        //1. size of list
        //2. index = size - k
        //3. return search(index)

        int n = count();
        if(k>n)
            return -1;
        else {
            int index = n - k;
            return search(index);
        }
    }

    //fast pointer to find size
    public int kthElementFromLast(int k){
        //1. size of list using fast pointer
        //2. index = size - k
        //3. return search(index)

        int n = size();
        if(k>n)
            return -1;
        else {
            int index = n - k;
            return search(index);
        }
    }

    // Kth Node From Middle

    /*
    Given a linked list A of length N and an integer B.

Find the value of the Bth node from the middle towards the beginning of Linked List.

If no such element exists, then return -1.

Input 1:

 A = 3 -> 4 -> 7 -> 5 -> 6 -> 16 -> 15 -> 61 -> 16
 B = 3
 Input 2:

 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 2
 Input 3:

 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 10

    * */
    public int kthElementFromMid(Node head, int k) {
        if (head == null) return -1;

        int size = 0;
        Map<Integer, Integer> nodePositions = new LinkedHashMap<>();

        int pos = 1;
        Node temp = head;

        while(temp != null){

            nodePositions.put(pos, temp.data);
            temp = temp.next; // Fix: Move to the next node
            size++;
            pos++;
        }

        //int mid = Math.round(size / 2); // incorrect
        int mid = (size / 2) + 1; // Fix: Correct middle calculation

        //int position = mid + k;  // incorrect
        int position = mid - k;   // Fix: Subtract B instead of adding

        return (position < 1 || position > size) ? -1 : nodePositions.get(position);
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

    public Node removeNthFromEnd(Node head, int n) {
        int size = count(head);
        if(size==n)
            return head.next;
        else{
            int position = size - n;
            Node prev = null;
            Node curr = head;
            for(int i = 0; i < position; i++)
            {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            return head;
        }
    }

    public int count(Node head){
        int n=0;
        Node node = head;
        while(node != null){
            node = node.next;
            n++;
        }
        return n;
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

    //LeetCode 25. Reverse Nodes in k-Group
    /*
    Given the head of a linked list, reverse the nodes of the list k at a time,
    and return the modified list.

    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes, in the end,
    should remain as it is.

    You may not alter the values in the list's nodes, only nodes themselves may be changed.

    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]

    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]

    * */

    public Node reverseKGroup(Node head, int k) {
        Node begin;
        if(head == null || head.next == null || k==1)
            return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        begin = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }else
                head = head.next;
        }
        return dummy.next;
    }

    /*
    Linked List Group Reverse

    Given the head a linked list, the task is to reverse every k node in the linked list.
    If the number of nodes is not a multiple of k then the left-out nodes in the end,
    should be considered as a group and must be reversed.

Input: head = 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5

Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
Output: 3 -> 2 -> 1 -> 5 -> 4

    * */

    public Node reverseKGroups(Node head, int k) {

        if(head==null)
            return head;
        if(size(head)<k)
            return reverseRecursive(head);

        Node curr=head,next=null,prev=null;

        for(int i=0;i<k;i++){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head.next=reverseKGroups(curr,k);
        return prev;
    }

    public Node reverseList(Node head) {

        Node current = head;
        Node previous = null;

        while(current!=null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
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

    public Node reverse(Node begin, Node end){
        Node curr = begin.next;
        Node next, first;
        Node prev = begin;
        first = curr;
        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
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

    // Leetcode 92. Reverse Linked List II
    /*
    Given the head of a singly linked list and two integers left and right
    where left <= right,
    reverse the nodes of the list from position left to position right,
    and return the reversed list.
    * */

    /*
    Input: head = [1,2,3,4,5], left = 2, right = 4
    Output: [1,4,3,2,5]

    Input: head = [5], left = 1, right = 1
    Output: [5]

    * */
    public Node reverseBetween(Node head, int left, int right) {
        if (head == null || left == right)
            return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < left - 1; ++i) {
            prev = prev.next;
        }

        Node current = prev.next;

        for (int i = 0; i < right - left; ++i) {
            Node nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
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

    public Node mergeTwoLists(Node list1, Node list2) {
        Node temp1 = list1;
        Node temp2 = list2;

        LinkedList list3 = new LinkedList();

        while(temp1 != null && temp2 != null){

            int data1 = temp1.data;
            int data2 = temp2.data;

            if(data1 < data2 || data2 == data1){
                list3.insertEnd(data1);
                temp1 = temp1.next;
            }else{
                list3.insertEnd(data2);
                temp2 = temp2.next;
            }

        }

        while(temp1 != null){
            list3.insertEnd(temp1.data);
            temp1=temp1.next;
        }

        while(temp2 != null){
            list3.insertEnd(temp2.data);
            temp2=temp2.next;
        }

        return list3.head;
    }

    /*
    Above code can be optimized in terms of efficiency and cleaner code by directly
    manipulating node pointers instead of creating an entirely new LinkedList.
    * */

    /*
    Key Improvements:
    No New List Creation: Instead of creating a new linked list and copying values,
    this solution directly splices the existing nodes.

    Dummy Node: The dummy node simplifies list handling by eliminating edge cases
    for the initial head assignment.

    Efficient Pointers: The pointers current, list1, and list2 handle merging
    without unnecessary list operations.

    This approach improves time and space efficiency while keeping the solution clean
    and straightforward.
    * */

    //Optimised Merge
    public Node mergeTwoSortedLists(Node list1, Node list2) {
        // Create a dummy node to simplify edge cases
        Node dummy = new Node(-1);
        Node current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes from list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the head of the merged list (skip the dummy node)
        return dummy.next;
    }

    // optimized merge sort
    private Node mergeSortOptimized(Node head) {
        if (head == null || head.next == null) {
            return head;  // Base case: empty list or single node
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow.next;
        slow.next = null;

        Node left = mergeSortOptimized(head);
        Node right = mergeSortOptimized(mid);

        return merge(left, right);
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

    /*
    Optimized approach: Move the fast pointer once with each loop iteration but only move the slow pointer
     every-other iteration.
    * */
    public static Node findMiddle(LinkedList linkedList) {
        int count = 0;
        Node fast = linkedList.head;
        Node slow = linkedList.head;

        while(fast != null) {
            fast = fast.next;
            if (count % 2 != 0) {
                slow = slow.next;
            }
            count++;
        }
        return slow;
    }

    // Deletes middle element in linked list and returns head
    Node removeMiddleElement(Node head){

        if(head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;
        Node node = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            node = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        node.next = slow.next;
        return slow;
    }

    // find the value of the middle element of the linked list.
    // middle = (N/2) + 1
    static int getMiddleElement(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    Node deleteMid(Node head) {
        if(head.next==null)
            return null;
        Node slow=head;
        Node fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public Node removeDuplicates(Node head) {

        // do nothing if the list is empty
        if (isEmpty()) {
            return null;
        }

        Node current = head;

        // compare the current node with the next node
        while (current.next != null) {
            if (current.data == current.next.data)
                current.next = current.next.next;
            else
                current = current.next;    // only advance if no deletion
        }
        return head;
    }

    public void removeDuplicates() {
        if (isEmpty()) return;

        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // Skip the duplicate
            } else {
                current = current.next; // Move to the next distinct element
            }
        }
    }

    public void deleteDuplicates(){
        if (isEmpty()) {
            System.out.println("Empty Linked List!!");
            return;
        } else {
            Node prev = head;
            Node curr = head.next;

            //int element = head.data;

            while (curr != null) {
                if (curr.data == prev.data) {
                    prev.next = curr.next; // Skip the duplicate
                } else {
                    prev = curr;  // Move prev forward
                    //element = prev.data;
                }
                curr = curr.next;  // Always move curr forward
            }
            /*
            curr = head;
            while (curr != null) {
                System.out.print(curr.data+" ");
                curr = curr.next;
            }
            System.out.println();
            */
        }
    }

    // Remove Duplicates from Sorted List (and keep only distinct elements)
    /*
    Given a sorted linked list, delete all nodes that have duplicate numbers,
    leaving only distinct numbers from the original list.

For example,

Given 1->2->3->3->4->4->5, return 1->2->5.

Given 1->1->1->2->3, return 2->3.
    * */

    /*
    public ListNode deleteDuplicates(ListNode head) {
        // do nothing if the list is empty
        if (isEmpty(head)) {
            return null;
        }

        ListNode prev = null;
        ListNode current = head;

        // compare the current node with the next node
        while (current.next != null) {
            if (current.val == current.next.val){
                if(prev==null || current == head){
                    head = current.next.next;
                    continue;
                }
                prev.next = current.next.next;
            }else{
                prev = current;
                current = current.next;    // only advance if no deletion
            }
        }
        return head;
    }*/
    public Node deleteDuplicatesKeepDistinctNodes(Node head) {
        // Dummy node to handle the edge case of head being removed
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node current = head;

        while (current != null) {
            // Detect duplicates
            if (current.next != null && current.data == current.next.data) {
                // Skip all duplicate nodes
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                // Remove all duplicates by linking prev to current's next
                prev.next = current.next;
            } else {
                prev = current; // Move prev forward only if no duplicate
            }
            current = current.next;
        }
        return dummy.next;
    }

    // insert key in sorted linked list
    // returns head of linked list
    Node insertInSortedList(Node head, int key) {
        Node node = new Node(key);
        if(key < head.data) {
            node.next = head;
            head = node;
        }else {
            Node temp = head;
            Node prev = null;
            while (true) {
                prev = temp;
                if(temp.next == null){
                    //last node  ...key > temp.data  ... temp = null
                    temp.next = node;
                    break;
                }
                else if (key > temp.data) {
                    prev.next = node;
                    node.next = temp;
                    break;
                }else
                    temp = temp.next;
            }
        }
        return head;
    }

    // insert key in sorted linked list
    // returns head of linked list
    Node sortedInsert(Node head, int key) {

        if(head == null || key<head.data)
            return insertBegin(head, key);
        else{
            Node node = new Node(key);
            Node current = head;

            while (current.next != null && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            return head;
        }
    }

    Node insertBegin(Node head, int key){
        Node node = new Node(key);
        node.next = head;
        head = node;
        return node;
    }

    void appendToTail(Node head, int d){
        Node end = new Node(d);
        Node n = head;
        while(n.next != null)
            n=n.next;

        n.next = end;
    }

    /*
    public Node removeDuplicatesUnsorted(Node head){
        Map<Integer, Integer> frequencyMap = frequency(head);
        Map<Integer, Boolean> visited = new HashMap<>();
        Node node = head;
        Node nextNode = node.next;
        while(node!=null){
            visited.put(node.data, true);
            if(nextNode==null)
                break;

            else if(frequencyMap.get(node.data)==1){
                visited.put(node.data, true);
            }
            else if(visited.get(nextNode.data) &&
                    frequencyMap.get(nextNode.data)>1){
                node.next = nextNode.next;
                nextNode = nextNode.next;
            }
            node = node.next;
            nextNode = nextNode.next;
        }
        return head;
    }
     */

    // removes all repeating elements
    public Node removeRepeatingUnsorted(Node head){
        Map<Integer, Boolean> map = findRepeatingNodes(head);
        Node current = head;
        Node nextNode = current.next;
        while(current!=null){
            if(nextNode==null)
                break;
            if(map.get(nextNode.data)){
                current.next = nextNode.next;
                nextNode = nextNode.next;
            }
            current = current.next;
            nextNode = nextNode.next;
        }
        return head;
    }

    public Map<Integer, Boolean> findRepeatingNodes(Node head){
        Node temp = head;
        Map<Integer, Boolean> map = new HashMap<>();
        while(temp!=null){
            if(map.containsKey(temp.data)) //!map.get(temp.data)
                map.put(temp.data, true);
            else
                map.put(temp.data, false);
            temp=temp.next;
        }
        return map;
    }

    public Map<Integer, Integer> frequency(Node head){
        Node temp = head;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        while(temp!=null){
            frequencyMap.put(temp.data,
                    frequencyMap.getOrDefault(temp.data, 0) + 1);
            temp=temp.next;
        }
        return frequencyMap;
    }

    public Node removeDuplicatesUnsorted(Node head) {
        if(head == null || head.next == null)
            return head;

        Set<Integer> set = new HashSet<>();
        Node temp = head;
        Node prev = null;
        while(temp != null) {
            if(set.contains(temp.data)) {
                temp = temp.next;
                prev.next = temp;
            } else {
                set.add(temp.data);
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    //Leetcode 83: delete duplicates from a sorted linked list
    /*
    Input: head = [1,1,2,3,3]
    Output: [1,2,3]
    * */
    public Node deleteDuplicates(Node head) {
        Node temp = head;
        while(temp != null){
            if(temp.next == null)
                break;
            else if(temp.data == temp.next.data)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }

    //Function to check if the linked list has a loop.
    //Leetcode 141. Detect Cycle/ loop in Linked List
    public static boolean detectLoop(Node head){

        if(head == null || head.next == null)
            return false;

        Node hare = head;   // fast
        Node turtle = head;  // slow

        while(hare!= null && hare.next!=null){
            hare=hare.next.next;
            turtle = turtle.next;

            if(hare == turtle)
                return true;
        }
        return false;
    }

    // Leetcode 142. Linked List Cycle II
    // Detect head of the Cycle/ Loop in Linked List
    public Node detectCycle(Node head) {

        Node hare = head;   // fast
        Node turtle = head;  // slow

        while(hare!= null && hare.next!=null){
            hare=hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                Node slow = head;
                while(slow != turtle){
                    turtle = turtle.next;
                    slow = slow.next;
                }
                return turtle;
            }
        }
        return null;
    }

    public static Node identifyCycle(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        // Detecting cycle using Floyd's Tortoise and Hare method
        while (fast != null && fast.next != null) {
            slow = slow.next;            // Move slow pointer by one step
            fast = fast.next.next;       // Move fast pointer by two steps

            if (slow == fast) {          // Cycle detected
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;       // No cycle detected

        // Finding the start of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now, slow and fast meet at the beginning of the cycle
        return slow;
    }

    //Detect size of the cycle in linked list
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head){
        Node hare = head;   // fast
        Node turtle = head;  // slow
        int count=1;

        while(hare!= null && hare.next!=null){
            hare=hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                turtle = turtle.next;
                //Node slow = head;
                while(hare != turtle){
                    count++;
                    turtle = turtle.next;
                    //slow = slow.next;
                }
                return count;
            }
        }
        return 0;
    }

    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        Node temp=head;
        Node temp1=head;

        Map<Node,Integer> map=new LinkedHashMap<Node,Integer>();
        while(temp!= null){
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }
            else{
                temp1.next=null;
                break;
            }
            temp1=temp;
            temp=temp.next;
        }
    }

    public static void removeCycle(Node head) {
        Node first = head.next;
        Node second = head;
        Node previous = null;
        boolean flag = false;
        while (first.next != null && first.next.next != null) {
            if (first == second) {
                flag = true;
            }
            if (flag && head == second) {
                previous.next = null;
            }
            if (flag) head = head.next;
            first = first.next.next;
            previous = second;
            second = second.next;
        }
    }

    // Function to remove a loop in the linked list.
    public static void removeCycleFromList(Node head) {
        Node hare = head;   // fast
        Node turtle = head;  // slow
        Node temp = head;

        while(hare!= null && hare.next!=null){
            hare=hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                //Node slow = head;
                while(temp != turtle){
                    turtle = turtle.next;
                    temp = temp.next;
                }
                while (hare.next != turtle) {
                    hare = hare.next;
                }
                hare.next = null;
            }
        }
    }

    // GFG: Find the first node of loop in linked list
    //Amazon, Flipkart, Morgan Stanley, Paytm, Ola, Walmart, Goldman Sachs, Google, Visa
    public static Node findFirstNodeInCycle(Node head) {
        // code here
        if(head == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast) return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // Return the sum of last k nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        int length = size();
        int i = 0;
        int start = (length == n) ? i : (length - n);
        int sum = 0;
        Node temp = head;
        while(temp!=null){
            if(i<start){
                i++;
                temp = temp.next;
                continue;
            }
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    //Occurence of an integer in a Linked List
    public int countFrequency(Node head, int key) {
        int count = 0;
        Node temp = head;
        while(temp != null){
            if(key == temp.data){
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    // Leetcode 1019. Next Greater Node In Linked List.

    /*
    Input: head = [2,1,5]
    Output: [5,5,0]

    Input: head = [2,7,4,3,5]
    Output: [7,0,5,5,0]
    * */
    public int[] nextLargerNodes(Node head) {
        int[] arr = new int[size()];
        int i = 0;
        while(head != null) {
            arr[i++] = findNextLargeNode(head, head.data);
            head = head.next;
        }
        return arr;
    }

    public static int findNextLargeNode(Node node, int val){
        int nodeVal = 0;
        while(node != null) {
            if(node.data > val) {
                nodeVal = node.data;
                break;
            }
            node = node.next;
        }
        return nodeVal;
    }

    //LeetCode 237. Delete Node in a Linked List (without 'head' pointer)

    //optimized version of deleteElement(int key){..}
    public void deleteNode(Node node) {
        node.data=node.next.data;
        node.next=node.next.next;
    }

    //Find Next Smaller value in Linked List
    /*
    Linked List:  [19 18 16 12 8 8]
    Next Smaller: [18 16 12 8 -1 -1]
    * */
    public Node nextSmallerValue(Node head) {

        Stack<Node> nodeStack = new Stack<>();
        Node current = head;

        while(current != null){

            while(!nodeStack.isEmpty() && nodeStack.peek().data >
                    current.data){

                nodeStack.peek().data = current.data;
                nodeStack.pop();
            }
            nodeStack.push(current);
            current = current.next;
        }
        while(!nodeStack.isEmpty()){
            nodeStack.peek().data = -1;
            nodeStack.pop();
        }
        return head;
    }

    //LeetCode 328. Odd Even Linked List
    /*
    Input: head = [1,2,3,4,5]
    Output: [1,3,5,2,4]

    Input: head = [2,1,3,5,6,4,7]
    Output: [2,3,6,7,1,5,4]
    * */
    public Node oddEvenList(Node head) {

        if(head==null || head.next==null)
            return head;

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;
        Node curr = head;
        int i = 1;
        while(curr!=null){
            // generate the even indices list
            if(i%2==0) {
                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }
            // generate the odd indices list
            else{
                if(oddHead == null){
                    oddHead = curr;
                    oddTail = curr;
                }
                else{
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
            i++;
        }
        evenTail.next = null;     // there should not be any node after even tail
        oddTail.next  = evenHead;   // join even list after odd
        return oddHead;
    }

    // Separate Even and Odd values in a linked list
    public Node rearrange(Node head) {

        Node evenHead = new Node();
        Node oddHead = new Node();

        Node even = evenHead;
        Node odd = oddHead;

        //traverse linked list
        while (head != null) {

            if (head.data % 2 == 0) {

                // Check if even
                even.next = head;
                even = even.next;

                // otherwise it is odd
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next; // Move to next node
        }

        // connect even sublist or odd sublist
        even.next = oddHead.next;
        odd.next = null;

        //return rearranged list
        return evenHead.next;
    }

    /*
    Add 1 to a Linked List Number

    You are given a linked list where each element in the list is a node and
    have an integer data. You need to add 1 to the number formed by concatinating
    all the list node numbers together and return the head of the modified linked list.
    * */

    public Node addOne(Node head) {
        // code here.
        Node cur=head;
        Node prev=null;
        Node p;
        while(cur!=null){
            p=cur.next;
            cur.next=prev;
            prev=cur;
            cur=p;
        }
        head=prev;
        if(head.data+1<9){
            prev.data=prev.data+1;
        }
        else{
            // prev.data=prev.data+1;
            while(prev.data+1>9&&prev.next!=null){
                prev.data=0;
                prev=prev.next;
            }
            if(prev.next!=null){
                prev.data=prev.data+1;
            }
            else{
                Node ex=new Node(1);
                prev.data=0;
                prev.next=ex;
            }
        }
        cur=head;
        prev=null;
        p=null;
        while(cur!=null){
            p=cur.next;
            cur.next=prev;
            prev=cur;
            cur=p;
        }
        head=prev;
        return head;
    }

    //LeetCode 24. Swap Nodes in Pairs
    /*
    head -> 1 -> 2 -> 3 -> 4
    head -> 2 -> 1 -> 4 -> 3
    * */
    public Node swapNodesInPairs(Node head) {
        if (head != null && head.next != null){

            Node current = head;
            while(current != null && current.next != null){

                int temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;

                current = current.next.next;
            }
        }
        return head;
    }

    // LeetCode 234. Palindrome Linked List

    /*
    Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.

Input: head = [1,2,2,1]
Output: true

Input: head = [1,2]
Output: false
    * */

    public boolean isPalindrome(Node head) {
        if(head == null || head.next==null)
            return true;

        Node mid = findMid(head);
        Node revStart = reverseList(mid.next);

        Node first = head;
        while(revStart != null){
            if(revStart.data != first.data)
                return false;
            revStart = revStart.next;
            first = first.next;
        }
        return true;
    }

    public Node findMid(Node head){
        Node hare = head;
        Node turtle = head;

        while(hare.next!= null && hare.next.next!=null){
            hare=hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    /*
    LeetCode 160. Intersection of Two Linked Lists

    Given the heads of two singly linked-lists headA and headB,
    return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.

    input:
    listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
    output:
    intersect = 1

    * */

    // Function to find intersection point in Y shaped Linked Lists
    public static int intersectPoint(Node headA, Node headB) {
        if(headA==null || headB==null)
            return -1;

        Node tempA = headA;
        Node tempB = headB;

        while(tempA != tempB){
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }

        return tempA == null ? -1 : tempA.data;
    }

    public static int intersectionPoint(Node head1, Node head2) {
        // Create a set to store the nodes of the first list
        Set<Node> nodes = new HashSet<>();

        // Traverse the first list and store each node in the set
        Node temp1 = head1;
        while (temp1 != null) {
            nodes.add(temp1);
            temp1 = temp1.next;
        }

        // Traverse the second list and check for intersection
        Node temp2 = head2;
        while (temp2 != null) {
            if (nodes.contains(temp2)) {
                return temp2.data;
            }
            temp2 = temp2.next;
        }

        // If no intersection is found
        return -1;
    }

    //LeetCode 61: Rotate the List

    /*
    rotate the list to R places to the right.

    A single rotation to the right is an operation in which the last element of the list is
    moved to the first place in the list, while all the other elements are moved one place to the right.

    R=3
head -> 4 -> 7 -> 3 -> 1 -> 6
head -> 3 -> 1 -> 6 -> 4 -> 7
    * */

    Node rotateRight(Node head, int R) {

        if (head == null || head.next == null || R == 0) {
            return head;
        }

        // Determine the size of the list and last node
        Node last = head;
        int size = 1;
        while (last.next != null) {
            last = last.next;
            size++;
        }

        // Normalize R
        R = R % size;
        if (R == 0) {
            return head;
        }

        // Find the new end of the list
        Node newEnd = head;
        for (int i = 0; i < size - R - 1; i++) {
            newEnd = newEnd.next;
        }

        // Rotation
        Node newHead = newEnd.next;
        newEnd.next = null;
        last.next = head;

        return newHead;
    }

    // CodeChef: Critical points in a Linked List

    /*
    Given the head of a linked list, Find the number of critical points.
    (The starting and end are not considered critical points).

    Local minima or maxima are called critical points.

    A Node is called a local minima if both next and previous elements are
    greater than the current element.

    A Node is called a local maxima if both next and previous elements are
    smaller than the current element.

Input
    8
1 2 3 3 3 5 1 3

output
2

Input
7
1 2 3 2 1 3 2

output
3
    * */

    static int criticalPoints(Node head){

        int maxima = 0;
        int minima = 0;

        Node temp = head.next;
        Node prev = head;

        while(temp.next!=null){
            if(prev.data > temp.data && temp.next.data > temp.data)
                minima++;
            else if(prev.data < temp.data && temp.next.data < temp.data)
                maxima++;
            temp = temp.next;
            prev = prev.next;
        }

        return minima + maxima;
    }
}