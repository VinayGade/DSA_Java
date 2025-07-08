package array.math.matrix;

import java.util.Scanner;

/*
 N * N matrix
find the sum of both primary as well as secondary diagonal elements.

input:
3
3 1 5
8 2 1
4 6 0

output:
14
* */
public class DiagonalSum {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] a = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        /*
        boolean odd = N % 2 != 0;
        int k = N / 2;

        int digonalSum = 0;
        int leftDigonalSum = 0;
        int rightDigonalSum = 0;

        int center = 0;

        // left (primary) Digonal Sum
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    if (odd && j == k) {
                        center = a[i][i];
                    }
                    leftDigonalSum += a[i][i];
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == j) {
                    rightDigonalSum += a[i][i];
                }
            }
        }

        digonalSum += leftDigonalSum;
        digonalSum += rightDigonalSum;
        digonalSum -= center;

        System.out.println(digonalSum);
        */

        int diagonalSum = 0;
        for (int i = 0; i < N; i++) {
            diagonalSum += a[i][i]; // Primary diagonal
            if (i != N - i - 1) { // Exclude center element if n is odd
                diagonalSum += a[i][N - i - 1]; // Secondary diagonal
            }
        }

        System.out.println(diagonalSum);

    }
}
