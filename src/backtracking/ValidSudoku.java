package backtracking;

import java.util.HashSet;
import java.util.Set;

//LeetCode 36: Medium
public class ValidSudoku {

        public boolean isValidSudoku(char[][] board) {
            Set<String> set = new HashSet<>();
            final int N = board.length;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N ; y++) {
                    char val = board[x][y];
                    if (val != '.') {
                        int block = (x / 3 * 3) + (y / 3);
                        if (set.contains("r" + x + val) || set.contains("c" + y + val) ||
                                set.contains("b" + block + val))
                            return false;
                        else {
                            set.add("r" + x + val);
                            set.add("c" + y + val);
                            set.add("b" + block + val);
                        }
                    }
                }
            }

            return true;
        }

    public static void main(String[] args) {

    }
}
