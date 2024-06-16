package array.math.two_pointers;

import java.util.Arrays;
import java.util.Scanner;

public class AsymmetricSwap {

    /*

    CodeChef: Asymmetric Swaps

Chef has two arrays AA and BB of the same size NN.

In one operation, Chef can:

    Choose two integers i and j (1≤i,j≤N)(1≤i,j≤N) and swap the elements Ai and Bj.

Amax: max(A)
Amin: min(A)

Chef came up with a task to find the minimum possible value of (Amax−Amin) after performing
the swap operation any (possibly zero) number of times.

Since Chef is busy, can you help him solve this task?
    * */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0) {
            int N = scan.nextInt();
            int SIZE = N*2;
            int[] a = new int[SIZE];
            //int[] b = new int[N];
            for (int i = 0; i < SIZE; i++) {
                a[i] = scan.nextInt();
            }
            /*
            for (int i = 0; i < N; i++) {
                b[i] = scan.nextInt();
            }*/
            int minimum = asymmetricSwap(a, N);
            System.out.println(minimum);
        }
    }

    private static int asymmetricSwap(int[] A, int n) {
        Arrays.sort(A);
        int max = -1, min = -1;
        int[] difference = new int[n + 1];
        int j = 0;
        for (int i = 0; i < n + 1; i++) {
            min = A[i];
            max = A[i + n - 1];
            difference[j++] = max - min;
        }
        Arrays.sort(difference);
        return difference[0];
    }
}
/**
 input:
 3
 3
 2 1 3
 1 4 1
 4
 2 1 4 3
 3 2 6 2
 5
 2 8 4 9 7
 7 3 6 8 4

 Output:
 0
 1
 2

 */

