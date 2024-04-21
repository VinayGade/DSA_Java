package array.math.matrix;

/*  LeetCode 867:
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.

Example 1:

Input:
matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]]

Output:
[
[1,4,7],
[2,5,8],
[3,6,9]]
Example 2:

Input:
matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
* */
public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static void display(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n; i++){
            System.out.println();
            for(int j=0; j<m; j++){
                System.out.print(" "+matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };

        int[][] transposeMatrix1 = transpose(matrix1);

        System.out.println("\nmatrix1 =");
        display(matrix1);

        System.out.println("\ntranspose matrix1 =");
        display(transposeMatrix1);

        int[][] matrix2 = {{1,2,3},{4,5,6}};

        int[][] transposeMatrix2 = transpose(matrix2);

        System.out.println("\nmatrix2 =");
        display(matrix2);

        System.out.println("\ntranspose matrix2 =");
        display(transposeMatrix2);

    }
}
