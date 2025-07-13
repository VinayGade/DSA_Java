package array.math.matrix;

// Leetcode 3417. Zigzag Grid Traversal With Skip

/*

You are given an m x n 2D array grid of positive integers.

Your task is to traverse grid in a zigzag pattern while skipping every alternate cell.

Zigzag pattern traversal is defined as following the below actions:

Start at the top-left cell (0, 0).

Move right within a row until the end of the row is reached.

Drop down to the next row, then traverse left until the beginning of the row is reached.

Continue alternating between right and left traversal until every row has been traversed.

Note that you must skip every alternate cell during the traversal.

Return an array of integers result containing, in order, the value of the cells visited during the zigzag traversal with skips.

Input: grid = [[1,2],[3,4]]

Output: [1,4]

Input: grid = [[2,1],[2,1],[2,1]]

Output: [2,1,2]

Input: grid = [[1,2,3],[4,5,6],[7,8,9]]

Output: [1,3,5,7,9]
* */

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverseSkip {

    public List<Integer> zigzagTraversal(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int size = n * m;
        int[] zigZag = new int[size];

        int k = 0;

        boolean flag = true;
        for(int i=0; i<n; i++){
            if(flag){
                for(int j = 0; j < m; j++){
                    zigZag[k] = grid[i][j];
                    k++;
                }
                flag=false;
            }else{
                for(int j = m-1; j >= 0; j--){
                    zigZag[k] = grid[i][j];
                    k++;
                }
                flag=true;
            }
        }

        List<Integer> zigZagSkip = new ArrayList<>();

        boolean flag2 = true;
        for(int x: zigZag){
            if(flag2){
                zigZagSkip.add(x);
                flag2 = false;
            }else{
                flag2 = true;
            }
        }
        return zigZagSkip;
    }
}
