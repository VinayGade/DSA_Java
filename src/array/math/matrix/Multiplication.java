package array.math.matrix;

import java.util.Scanner;

/*
input:
2 3
2 3 4
4 5 6
3 2
1 2
3 4
2 2

output:
19 24
31 40
* */
public class Multiplication {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        // A : M*N, B : N*P
        // C = A * B  C :M*P

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] a = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        N = scanner.nextInt();
        int P = scanner.nextInt();

        int[][] b = new int[N][P];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < P; j++) {
                b[i][j] = scanner.nextInt();
            }
        }

        int[][] c = multiply(a, M, N, b, P);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < P; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] a, int m, int n,
                                   int[][] b, int p) {

        int[][] c = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
