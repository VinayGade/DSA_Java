package array.math.matrix;

/*
Matrix Rotations:

Rotate N * N matrix 90 degrees clockwise

input:
3
3 1 5
8 2 1
4 6 0

output:
4 8 3
6 2 1
0 1 5

* */

import java.util.Scanner;

public class RotateClockwise {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        rotate(matrix, N);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    // rotate clockwise
    static void rotate(int[][] matrix, int n){

        //reverse
        for(int i = 0; i<(n/2); i++){
            int[] temp = matrix[i];      // first row
            matrix[i] = matrix[n-i-1]; // last row
            matrix[n-i-1] = temp; // swap
        }

        // transpose
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
