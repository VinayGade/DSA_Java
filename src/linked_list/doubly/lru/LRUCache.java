package linked_list.doubly.lru;

import java.util.HashMap;
import java.util.Map;

//LeetCode 146. LRU Cache
public class LRUCache {

    class Node{

        Node next, prev;
        int key, value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

    Node head;
    Node tail;

    Map<Integer, Node> map;
    int capacity;

    public LRUCache(){
        head = new Node(0, 0);
        tail = new Node(0, 0);

        map = new HashMap<>();

    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //move data to top
            //remove node and insert it
            remove(node);
            //insert node
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // if value is present move it to top
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        // if cache is full
        if(capacity == map.size())
            remove(tail.prev);
        // tail.prev ... LRU data
        insert(new Node(key, value));
    }

    void remove(Node node){
        map.remove(node.key);

        //remove node in Doublu Linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node){
        map.put(node.key, node);
        Node nextHead = head.next;
        head.next=node;
        node.prev=head;
        nextHead.prev=node;
        node.next=nextHead;
    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
