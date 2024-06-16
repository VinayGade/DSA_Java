package array.math.two_pointers.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {

        // 2 - pointers

        int difference = 0;
        int n = arr.size();
        int leftSum = 0;
        int rightSum = 0;
        int i=0;
        int j=n-1;
        for(List<Integer> row: arr){
            leftSum += row.get(i);
            rightSum += row.get(j);
            i++;
            j--;
        }
        int max = Math.max(leftSum, rightSum);
        int min = Math.min(leftSum, rightSum);
        difference = max - min;
        return difference;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        /*
        1 2 3
        4 5 6
        9 8 9
        * */
        arr.add(Arrays.asList(1, 2, 3));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(9, 8, 9));

        int difference = diagonalDifference(arr);
        System.out.println("diagonal difference = "+difference);
    }
}
