package array.math;

import java.util.Scanner;

/*

Plusle and Minun on Array

Chef defines the alternating sum of the array as:
S = |A1| - |A2| + |A3| - |A4| + |A5| - |A6| - |A7| - + ... |An|

Chef is allowed to perform the following operation on the array at most once:

Choose 2 indices (i, j) => 1 <= i <= j <= n
swap (Ai, Aj)

Find the maximum alternating sum Chef can achieve by performing the operation at most once.

Note: |X| denotes absolute value of 𝑋.
| -4 | = 4    |10| = 10

input:
2
2
10 -10
7
-3 -2 -1 0 1 2 3

Output:
0
6

* */

public class PlusleMinun {

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++)
                a[i] = scanner.nextInt();

            long sum = plusleMinun(a, N);
            System.out.println(sum);
        }
    }

    static long plusleMinun(int[] a, int n) {

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum += Math.abs(a[i]);
                min = Math.min(min, Math.abs(a[i]));
            } else {
                sum -= Math.abs(a[i]);
                max = Math.max(max, Math.abs(a[i]));
            }
        }

        long potentialSum = sum + 2 * (max - min);
        return Math.max(sum, potentialSum);
    }
}
