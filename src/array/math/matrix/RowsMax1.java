package array.math.matrix;

public class RowsMax1 {
    /*
    Given a boolean 2D array, consisting of only 1's and 0's, where each row is sorted.
    Return the 0-based index of the first row that has the most number of 1s.
    If no such row exists, return -1.

Input: arr[][] = [[0, 1, 1, 1],
               [0, 0, 1, 1],
               [1, 1, 1, 1],
               [0, 0, 0, 0]]
Output: 2
Explanation: Row 2 contains 4 1's (0-based indexing).

Input: arr[][] = [[0, 0],
               [1, 1]]
Output: 1
Explanation: Row 1 contains 2 1's (0-based indexing).
    * */

    public static int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int max_count = 0;
        int row_index = -1;

        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<m; j++){
                if(arr[i][j] == 1){
                    count++;
                }
            }
            if(count > max_count){
                max_count = count;
                row_index = i;

                if(max_count == m)
                    break;
            }
        }
        return row_index;
    }

    public static void main(String[] args) {
        int [][] arr = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        int max1Index =rowWithMax1s(arr);
        System.out.println("max 1 index = "+max1Index);
    }
}
