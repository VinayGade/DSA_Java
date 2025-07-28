package array.math.matrix;
/*
LeetCode 378. Kth Smallest Element in a Sorted Matrix

Given an n x n matrix where each of the rows and columns is sorted in ascending order,
return kth smallest element in the matrix.

find kth smallest element in the sorted order.

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15],
and the 8th smallest number is 13
* */
public class SearchKthSmallest {

    public static int kthSmallest(int[][] matrix, int k) {

        int rows = matrix.length, cols = matrix[0].length;

        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1] ;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  maxNum = lo;

            for (int r = 0, c = cols - 1; r < rows; r++) {
                while (c >= 0 && matrix[r][c] > mid) c--;

                if (c >= 0) {
                    count += (c + 1); // count of nums <= mid in matrix
                    maxNum = Math.max(maxNum, matrix[r][c]);
                    // mid might be value not in  matrix, we need to record the actually max num;
                }else{ //it means c < 0
                    break;
                }
            }

            // adjust search range
            if (count == k)
                return maxNum;
            else if (count < k)
                lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};

        int k = 8;

        int kth = kthSmallest(matrix, k);
        System.out.println(kth);
    }
}
