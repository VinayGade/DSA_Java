package graph.problems.dfs;

/*

LeetCode 130. Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O',
capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.

Region: To form a region connect every 'O' cell.

Surround: The region is surrounded with 'X' cells if you can connect the region with
'X' cells and none of the region cells are on the edge of the board.

To capture a surrounded region, replace all 'O's with 'X's in-place within the original board.
You do not need to return anything.

Input:
board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Input: board = [["X"]]

Output: [["X"]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.

* */
public class SurroundedRegions {

    public static void solve(char[][] board) {
        // Base condition
        if(board.length == 0) return;
        // 1st Loop : Traversing over top column & bottom column, to find any 'O' present by the boundary
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                DFS(board, 0, i);
            }
            if(board[board.length - 1][i] == 'O'){
                DFS(board, board.length - 1, i);
            }
        }
        // 2nd Loop : Traversing over left row & right row, to find any 'O' present by the boundary
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                DFS(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O'){
                DFS(board, i, board[0].length - 1);
            }
        }
        // 3rd Loop : Now in this we will traverse on each n every node & check if they are 'O' convert into 'X', if they are '@' convert into 'O'
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '@'){
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    // This calls helps in convert the 'O' node present near by the boundary convert them into '@'
    public static void DFS(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '@';
        DFS(board, i + 1, j);
        DFS(board, i - 1, j);
        DFS(board, i, j + 1);
        DFS(board, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] grid= {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        solve(grid);

        System.out.println("surrounding regions:");
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
