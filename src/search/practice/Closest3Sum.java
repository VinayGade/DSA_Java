package search.practice;

import java.util.Arrays;

public class Closest3Sum {

    static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array);
        int closest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 2; i++) {
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {
                int sum = array[i] + array[j] + array[k];
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;
                else if (Math.abs(sum - target) == Math.abs(closest - target))
                    closest = Math.max(closest, sum);
                if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int arr[] = {-7, 9, 8, 3, 1, 1};
        int target = 2;
        int key = threeSumClosest(arr, target);
        System.out.println(key);
    }
}