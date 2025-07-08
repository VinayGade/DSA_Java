package array.math.matrix;

import java.util.Scanner;

/*

Given M, N
2 matrix A, B of size MN

find sum A + B

input:
2 3
2 3 4
4 5 6
1 7 4
6 4 9

output:
3 10 8
10 9 15
* */
public class Addition {

    static int[][] findSum(int[][] a, int[][] b, int m, int n){

        int[][] sum = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j <n; j++){
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] a = new int[M][N];
        int[][] b = new int[M][N];

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                a[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                b[i][j] = scanner.nextInt();
            }
        }

        int[][] sum = findSum(a, b, M, N);
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }
    }
}
