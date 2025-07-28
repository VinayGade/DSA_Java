package array.math.matrix;

// LC 695. Max Area of Island

import java.util.Scanner;

/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 connected 4-directionally (horizontal or vertical.)
 You may assume all four edges of the grid are surrounded by water.
 The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.

Input:
3 3
0 1 1
0 1 1
0 1 1

output:
6

Input: grid =
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,1,1,0,1,0,0,0,0,0,0,0,0],
[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],
[0,0,0,0,0,0,0,0,0,0,1,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

* */
public class IslandMaxArea {

    public int maxAreaOfIsland(int[][] grid, int n, int m) {

        // int n = grid.length;
        // int m = grid[0].length;
        int maxArea = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, n, m, i, j));
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int n, int m, int i, int j){

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == 0)
            return 0;
        grid[i][j]=0;
        return (1 +
                dfs(grid, n, m, i-1, j) +
                dfs(grid, n, m, i+1, j) +
                dfs(grid, n, m, i, j-1) +
                dfs(grid, n, m, i, j+1) );
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] grid = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                grid[i][j] = scanner.nextInt();
            }
        }

        IslandMaxArea island = new IslandMaxArea();

        int area = island.maxAreaOfIsland(grid, N, M);

        System.out.println(area);

        scanner.close();
    }
}
