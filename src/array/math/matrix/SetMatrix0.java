package array.math.matrix;

// Leetcode 73: Set Matrix Zeroes
/*
Given an m x n integer matrix matrix, if an element is 0,
set its entire row and column to 0's.

Input:
matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Input:
3 3

4 6 0
8 2 1
3 1 5

output:
0 0 0
8 2 0
3 1 0
* */

import java.util.Scanner;

public class SetMatrix0 {

    static void setZeroes(int[][] a, int n, int m) {
        /*
        int rows = a.length;
        int columns = a[0].length;
         */

        int rows = n;
        int columns = m;

        boolean firstColumn = false;

        for(int i=0; i<rows; i++){
            if(a[i][0] == 0){
                firstColumn = true;
            }
            for(int j=1; j<columns; j++){
                if(a[i][j] == 0){
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }

        for(int i=rows - 1; i >= 0; i--){
            for(int j=columns - 1; j >= 1; j--){

                if(a[i][0] == 0 || a[0][j] == 0){
                    a[i][j] = 0;
                }
            }
            if(firstColumn){
                a[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] a = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                a[i][j] = scanner.nextInt();
            }
        }

        setZeroes(a, N, M);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
