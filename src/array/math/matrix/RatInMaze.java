package array.math.matrix;

import java.util.ArrayList;

/*
Rat in a Maze

Consider a rat placed at (0, 0) in a square matrix mat of order n* n.
It has to reach the destination at (n - 1, n - 1).
Find all possible paths that the rat can take to reach from source to destination.
The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
Value 0 at a cell in the matrix represents that it is blocked and
rat cannot move to it while value 1 at a cell in the matrix represents
that rat can be travel through it.

Note: In a path, no cell can be visited more than one time.
If the source cell is 0, the rat cannot move to any other cell.
In case of no path, return an empty list. The driver will output "-1"

Input: mat[][] = [[1, 0, 0, 0],
                [1, 1, 0, 1],
                [1, 1, 0, 0],
                [0, 1, 1, 1]]
Output: DDRDRR DRDDRR

Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths -
DRDDRR and DDRDRR,
when printed in sorted order we get DDRDRR DRDDRR.

Input: mat[][] = [[1, 0],
                [1, 0]]
Output: -1
Explanation: No path exists and destination cell is blocked.
* */
public class RatInMaze {

    public static ArrayList<String> findPath(int[][] mat) {

        ArrayList<String> ans = new ArrayList<>();
        help(mat,mat.length,0,0,ans,"");
        return ans;
    }

    static void help(int[][] matrix,int n,int i,int j,ArrayList<String> ans,String temp){
        if(i<0 || j<0||i==n ||j==n|| matrix[i][j]==0)
            return;
        if(i==n-1 && j==n-1){
            ans.add(temp);
            return;
        }
        matrix[i][j]=0;
        help(matrix,n,i+1,j,ans,temp+'D');
        help(matrix,n,i-1,j,ans,temp+'U');
        help(matrix,n,i,j+1,ans,temp+'R');
        help(matrix,n,i,j-1,ans,temp+'L');
        matrix[i][j]=1;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        ArrayList<String> path = findPath(mat);

        path.forEach((x) -> System.out.print(x + " "));
    }
}
