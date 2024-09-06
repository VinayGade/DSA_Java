package array.math.hackerrank.mini_max_sum;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {

    public static String gridChallenge(List<String> grid) {

        int size = grid.size();

        // Sort each row alphabetically
        for (int i=0;i<size; i++) {
            char[] arr = grid.get(i).toCharArray();
            Arrays.sort(arr);
            grid.set(i, new String(arr));
        }

        // Initialize an array of StringBuilder to build columns
        StringBuilder[] str = new StringBuilder[size];

        for (int i=0; i<size; i++) {
            str[i] = new StringBuilder();
        }

        // Build each column string
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                // Check to ensure we're not accessing out-of-bounds indices
                if (i<grid.get(j).length()) str[i].append(grid.get(j).charAt(i));
            }
        }

        int num = 0;

        // Check if each column is sorted
        for (int i=0; i<size; i++) {
            char[] arr = str[i].toString().toCharArray();
            char[] temp = Arrays.copyOf(arr, arr.length);
            Arrays.sort(temp);

            if (Arrays.equals(arr, temp)) num++;
        }
        return (num == size) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList("abc", "ade", "efg");
        String ans = gridChallenge(grid);
        System.out.println(ans);
    }
}
