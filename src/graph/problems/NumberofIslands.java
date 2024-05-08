package graph.problems;

public class NumberofIslands {

    public static int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if(n==0)
            return 0;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    marking(grid, n, m, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    static void marking(char[][] grid, int n, int m, int i, int j){

        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != '1')
            return;

        grid[i][j] = '0';
        marking(grid, n, m, i+1, j);
        marking(grid, n, m, i-1, j);
        marking(grid, n, m, i, j+1);
        marking(grid, n, m, i, j-1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int count = numIslands(grid);

        System.out.println("count = "+count);
    }
}
