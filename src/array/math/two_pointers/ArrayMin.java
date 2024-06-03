package array.math.two_pointers;

//CodeChef: Find Array Min
/*
3 input arrays: A, B, C

f(i, j, k) = max (|A[i] - B[j]|, |B[j] - C[k]|, |A[i] - C[k]|)
* */

import java.util.Scanner;

/*
Input:
3
4 2 2
2 5 10 15
4 4
10 15
1 1 1
5
10
25
6 6 2
4 8 10 15 15 20
6 15 25 28 28 45
10 15

Output:
6
20
0
* */
public class ArrayMin {

    static int minMaxDifference(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i < A.length && j < B.length && k < C.length) {
            int maxDiff = Math.max(Math.abs(A[i] - B[j]),
                            Math.max(Math.abs(B[j] - C[k]),
                                Math.abs(A[i] - C[k])
                            ));
            minDiff = Math.min(minDiff, maxDiff);
            // Move the pointer which points to the smallest //element
            if (A[i] <= B[j] && A[i] <= C[k])
                i++;
            else if (B[j] <= A[i] && B[j] <= C[k])
                j++;
            else
                k++;
        }
        return minDiff;
    }

    public static void main (String[] args) throws java.lang.Exception{

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N_A = scanner.nextInt();
            int N_B = scanner.nextInt();
            int N_C = scanner.nextInt();
            int[] A = new int[N_A];
            int[] B = new int[N_B];
            int[] C = new int[N_C];
            for (int i = 0; i < N_A; i++)
                A[i] = scanner.nextInt();
            for (int i = 0; i < N_B; i++)
                B[i] = scanner.nextInt();
            for (int i = 0; i < N_C; i++)
                C[i] = scanner.nextInt();
            System.out.println(minMaxDifference(A, B, C));
        }
        scanner.close();
    }
}
