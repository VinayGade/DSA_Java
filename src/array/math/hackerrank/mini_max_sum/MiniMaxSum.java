package array.math.hackerrank.mini_max_sum;

import java.util.Arrays;
import java.util.List;

public class MiniMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {

        // find the total sum, smallest and largest elements
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int a : arr) {
            sum += a;
            min = Math.min(min, a);
            max = Math.max(max, a);
        }

        // calculate the minimum and maximum sums
        long minSum = sum - max;
        long maxSum = sum - min;

        System.out.println(minSum + " " + maxSum);

    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        miniMaxSum(arr);
    }
}
