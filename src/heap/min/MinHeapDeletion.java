package heap.min;

import java.util.Scanner;

public class MinHeapDeletion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        MinHeap minHeap = new MinHeap();

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            minHeap.insert(value);
        }

        while (!minHeap.isEmpty()) {
            minHeap.deleteMin();
            minHeap.display();
        }
    }
}
