package array.math.matrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
CodeChef: MATRICES : Rotting Apples:

Given an N x M matrix where each cell can have one of three values:

0 - empty cell
1 - fresh apple
2 - rotten apple

Every minute, any fresh apple that is 4 directionally adjacent to
rotten apple becomes rotten.

4 directionally adjacent cells of
 cell (i, j) are cell (i - 1, j), (i + 1, j), (i, j - 1) and (i, j + 1).

 Find the minimum number of minutes that must elapse until no cell has a fresh apple.
  If this is impossible, return -1.

input:
3 4
0 2 1 1
1 1 0 1
1 1 0 1

output:
4
* */

public class RotApples {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        int rotten = rotApples(matrix, N, M);

        System.out.println(rotten);
    }

    static int rotApples(int[][] grid, int m, int n){

        Queue<int[]> queue = new LinkedList<>();  // rotten apples

        int fresh = 0;

        // Step 1: Find all rotten apples and count fresh ones
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    queue.offer(new int[]{i, j});  // rotten apple found
                else if(grid[i][j] == 1)
                    fresh++;     // fresh apple found
            }
        }

        //if no fresh apples return 0
        if(fresh == 0)
            return 0;

        int minutes = -1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 2: Multi-Source BFS (Rot-apples Process)
        while(!queue.isEmpty()){
            int size = queue.size();
            //boolean spread = false;

            minutes++;

            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                for(int[] direction: directions){

                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if(nx >= 0 && nx < m && ny >= 0 && ny < n &&
                            grid[nx][ny] == 1){

                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                        fresh--;
                        //spread = true;
                    }
                }
            }
            /*
            if(size > 0)
                minutes++;
                */
        }
        return (fresh == 0) ? minutes : -1;
    }
}
