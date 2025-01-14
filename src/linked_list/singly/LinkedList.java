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
    //Leetcode 141. Detect Cycle/ Loop in Linked List
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
}