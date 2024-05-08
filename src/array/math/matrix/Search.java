package array.math.matrix;

//LeetCode 74. Search a 2D Matrix (sorted 1D array)

/*
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
* */
public class Search {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j]>target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix
                = {{1,3,5,7},
                   {10,11,16,20},
                   {23,30,34,60}};
        int target = 3;

        boolean flag = searchMatrix(matrix, target);
        System.out.println("target "+target+" found in matrix? "+flag);
    }
}