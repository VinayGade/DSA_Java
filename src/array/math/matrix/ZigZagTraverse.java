package array.math.matrix;

import java.util.Scanner;

/*

Zig-zag traversal

Given a N x M matrix, print its element in zig-zag fashion, i.e.,
print first row from left to right, second row from right to left,
third row again from left to right and so on.

input:
3 3
4 6 0
8 2 1
3 1 5

Output: 4 6 0 1 2 8 3 1 5

* */

public class ZigZagTraverse {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] zigZag = traverse(matrix, N, M);

        for (int x: zigZag)
            System.out.print(x+" ");
    }

    public static int[] traverse(int[][] matrix, int n, int m){

        int size = n * m;
        int[] zigZag = new int[size];

        int k = 0;

        boolean flag = true;
        for(int i=0; i<n; i++){
            if(flag){
                for(int j = 0; j < m; j++){
                    zigZag[k] = matrix[i][j];
                    k++;
                }
                flag=false;
            }else{
                for(int j = m-1; j >= 0; j--){
                    zigZag[k] = matrix[i][j];
                    k++;
                }
                flag=true;
            }
        }
        return zigZag;
    }
}
