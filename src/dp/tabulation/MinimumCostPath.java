package dp.tabulation;

/*

Given a square grid of size N, each cell of which contains an integer cost
that represents a cost to traverse through that cell, we need to find a path from
the top left cell to the bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).

Input: grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.

Input: grid = {{4,4},{3,7}}
Output: 14
Explanation: The grid is-
4 4
3 7
The minimum cost is- 4 + 3 + 7 = 14.
* */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostPath {

    class Cell {
        int x, y, cost;

        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    // Directions for moving left, right, up, down
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    // Function to return the minimum cost to reach the bottom right cell from the top left cell
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];

        // Initialize the distance array with a large value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Priority queue to store the cells with their cost, sorted by cost
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.cost));

        // Start with the top-left cell
        pq.add(new Cell(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        // Process the priority queue
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;

            // If we've reached the bottom-right cell, return the cost
            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            // Explore the four possible directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check for valid cell
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = cost + grid[newX][newY];
                    // If a cheaper path to (newX, newY) is found, update and push to the queue
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.add(new Cell(newX, newY, newCost));
                    }
                }
            }
        }

        // In case no path is found, though it should not happen in this problem
        return dist[n-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}};

        MinimumCostPath path = new MinimumCostPath();

        int minCost = path.minimumCostPath(grid);

        System.out.println(minCost);
    }
}
