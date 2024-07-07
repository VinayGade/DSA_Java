package heap.min;

import java.util.Scanner;

public class MinHeapInsertion {
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        MinHeap minHeap = new MinHeap();

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            minHeap.insert(value);
            minHeap.display();
        }
    }
}
