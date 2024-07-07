package heap.max;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxHeapInsertionDeletion {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Max Heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            String query = scanner.nextLine();
            char operation = query.charAt(0);

            switch (operation) {
                case '+':
                    int x = Integer.parseInt(query.substring(2));
                    heap.add(x);
                    System.out.println(heap.peek());
                    break;

                case '-':
                    if (!heap.isEmpty()) {
                        heap.poll();
                        System.out.println(heap.peek());
                    }
                    break;
            }
        }
        scanner.close();
    }
}
