package heap.min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;

public class MinHeap {

    private List< Integer > heap;

    public MinHeap() {
        heap = new ArrayList< >();
    }

    private int parent(int i){
        return i/2;
    }

    private int left(int i){
        return 2*i + 1;
    }

    private int right(int i){
        return 2*i + 2;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /*
    Pseudocode:
    MinHeap insertion:


    Class MinHeap:
    Public:
        heap: List of integers

        // Helper function to maintain the heap property by moving the element up
        Function heapifyUp(index):
            While index > 0:
                parentIndex = (index - 1) / 2
                If heap[index] < heap[parentIndex]:
                    Swap heap[index] with heap[parentIndex]
                    index = parentIndex
                Else:
                    Break

        // Function to insert a new element into the heap
        Function insert(value):
            Append value to heap
            Call heapifyUp(heap.size() - 1)
    * */

    // move element Up to keep in correct position
    void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                Collections.swap(heap, i, parent);
                i = parent;
            } else
                break;
        }
    }

    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size() - 1);
    }

    public void heapifyDown(int i) { // similar to min-heapify(a, i)
        /*
 Min-Heap Deletion
 pseudocode:-
 Function HeapifyDown(index):
    leftChild = 2 * index + 1
    rightChild = 2 * index + 2
    smallest = index

    If leftChild < size and heap[leftChild] < heap[smallest]:
        smallest = leftChild

    If rightChild < size and heap[rightChild] < heap[smallest]:
        smallest = rightChild

    If smallest != index:
        Swap heap[index] with heap[smallest]
        HeapifyDown(smallest)  // Recursively heapify the affected subtree
        * */
        int n = heap.size();
        int smallest = i;

      while(i < n){
        int l = left(i);
        int r = right(i);

        //int n = a.length;

        if (l < n && heap.get(l) < heap.get(smallest)) {
            smallest = l;
        }

        if (r < n && heap.get(r) < heap.get(smallest)) {
            smallest = r;
        }

        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            i = smallest;
            //heapifyDown(smallest);
        } else
            break;
      }
    }

    /*
    Min-Heap Deletion
    Function deleteMin():
        If heap is empty:
            Return an error (heap is empty)

        Swap heap[0] (root) with heap[size - 1] (last leaf)
        Remove the last element from the heap

        HeapifyDown(0)  // Start the heapify process from the root
    * */
    public void deleteMin(){
        if(heap.isEmpty())
            throw new EmptyStackException();
        int n = heap.size();
        Collections.swap(heap, 0, n-1);
        heapifyDown(0);
    }

    //Print heap
    public void display(){
        for(int x: heap)
            System.out.print(x+" ");
        System.out.println();
    }

    public int findMax(){
        return heap.get(heap.size()-1);
    }
}
