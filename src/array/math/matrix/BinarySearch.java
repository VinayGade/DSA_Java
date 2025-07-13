package array.math.matrix;

import java.util.Scanner;

/*
Search In Matrix:

You are given an N * M integer matrix with the following properties:

Each row of the matrix is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.

Given an integer X, determine whether it exists in the matrix.

expected time complexity : O(log(NM)).

input:
3 4 7
1 2 3 4
5 6 6 8
9 10 11 12

output:
YES

input:
3 4 7
1 2 3 4
5 6 6 8
9 10 11 12

Output:
NO
* */

public class BinarySearch {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt();

        if (N == 0 || M == 0) {
            System.out.println("NO");
            return;
        }

        int[][] a = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                a[i][j] = scanner.nextInt();
            }
        }

        String result = search(a, N, M, X) ? "YES" : "NO";

        System.out.println(result);
    }

    static boolean search(int[][] matrix, int n, int m, int key){

        int size = n * m; // total size of flattened array

        int start = 0;
        int end = size - 1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            int midValue = matrix[mid / m][mid % m];

            if(key == midValue)
                return true;
            else if(key < midValue)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
}
