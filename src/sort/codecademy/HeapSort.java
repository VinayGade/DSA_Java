package sort.codecademy;

import java.util.Random;

public class HeapSort {

    public static void main(String[]args) {
        MinHeap minHeap = new MinHeap();

        // Populate minHeap with 6 random numbers
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int int_random = r.nextInt(101);
            System.out.println("Adding value " + int_random);
            minHeap.add(int_random);
            System.out.println("Content of min-heap: " + minHeap.heap);
        }

        System.out.println("----------");

        // Return the minimum value in the heap until the heap is empty
        for (int i = 0; i < 10; i++) {
            System.out.println("Removing minimum value " + minHeap.popMin());
            System.out.println("Content of min-heap: " + minHeap.heap);
        }

    }
}
