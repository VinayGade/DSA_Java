package heap.problems;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SmallestPair {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            int sum = smallestPair(A, N, 2);
            System.out.println(sum);
        }
    }

    static int smallestPair(int[] a, int n, int k) { // k = 2

        int sum = 0;
        //Min Heap
        Queue< Integer > heap = new PriorityQueue< >();
        for (int i = 0; i < n; i++)
            heap.add(a[i]);

        for (int i = 0; i < k; i++)
            sum += heap.poll();

        return sum;
    }
}
