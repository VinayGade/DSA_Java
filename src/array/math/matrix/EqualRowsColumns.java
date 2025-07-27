package array.math.matrix;

import java.util.HashMap;
import java.util.Scanner;

/*
Equal Rows and Columns:

Given a N x N integer matrix, find the no. of pairs of row and column which are equal.
input:
4
9 0 0 3
0 1 1 5
0 1 1 5
8 5 5 1

output:
4

Row 2 == column 2

Row 2 == column 3

Row 3 == column 2

Row 3 == column 3
* */
public class EqualRowsColumns {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        int count = countEqualRowsColumns(matrix, N);

        System.out.println(count);

        scanner.close();
    }

    static int countEqualRowsColumns(int[][] matrix, int n){

        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
                sb.append(",");
            }
            map.put(sb.toString(),
                    map.getOrDefault(sb.toString(), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(matrix[j][i]);
                sb.append(",");
            }
            ans += map.getOrDefault(sb.toString(), 0);
        }
        return ans;
    }
}
