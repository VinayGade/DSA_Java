package array.math.matrix;

import java.util.Scanner;

// Count Negative Numbers

/*

N * M matrix which is sorted in non-increasing order both row-wise and column-wise,
count the number of negative numbers in matrix.

input:
3 4
8 7 6 -1
7 7 -1 -2
4 -5 -6 -7

output:
6
* */
public class CountNegative {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] a = new int[M][N];

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                a[i][j] = scanner.nextInt();
            }
        }

        int count = countNegative(a, M, N);
        System.out.println(count);
        scanner.close();
    }

    static int countNegative(int[][] a, int m, int n){

        int count = 0;
        for(int i=0; i<m; i++){ // rows
            for(int j=n-1; j>=0; j--){ //columns
                if(a[i][j] >= 0){
                    break;
                }
                count++;
            }
        }
        return count;
    }

    //optimised approach
    public static int countNegatives(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row_index = 0;
        int col_index = cols - 1;
        int negatives_count = 0;

        while (row_index < rows && col_index >= 0) {
            if (matrix[row_index][col_index] < 0) {
                negatives_count += rows - row_index;
                col_index--;
            } else {
                row_index++;
            }
        }

        return negatives_count;
    }

}
