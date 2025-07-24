package array.math.matrix;

import java.util.Scanner;

/*
* Median in Matrix
*
Given: row-wise sorted matrix of size N * M, (N * M is always odd)
find median of matrix

* input:
3 3
3 4 5
2 4 6
4 6 7

* output:

4

* If we place all elements in the sorter order: 2 3 4 4 4 5 6 6 7
* Then the median of the matrix = 4
* */

public class MedianMatrix {

    static int findMedian(int[][] matrix, int n, int m){

        int rowCount = n;

        int columnCount = m;

        int totalElements = rowCount * columnCount;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find the minimum and maximum values in the matrix

        // matrix is sorted row-wise

        for (int i = 0; i < rowCount; i++) {

            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][columnCount - 1]);
        }

        // Binary search for the median
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count elements smaller than or equal to mid in each row
            for (int i = 0; i < rowCount; i++) {
                count += countElementsSmallerThanMid(matrix[i], mid);
            }

            // Adjust the search range based on the count
            if (count < (totalElements + 1) / 2) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    static int countElementsSmallerThanMid(int[] row, int mid) {

        int low = 0, high = row.length - 1;

        while (low <= high) {
            int midIndex = low + (high - low) / 2; // to avoid overflow
            if (row[midIndex] <= mid) {
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }

        return low; // Returns index of the first element greater than mid
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        int median = findMedian(matrix, N, M);
        System.out.println(median);
        scanner.close();
    }
}
