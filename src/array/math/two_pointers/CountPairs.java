package array.math.two_pointers;

import java.util.Scanner;

public class CountPairs {

    /*
    CodeChef: 2 pointers + Sliding Window

    Given a sorted array of integers and a value x, count the number of pairs (i, j)
    such that i < j, and the sum arr[i] + arr[j] < x

input:
5
1 2 3 4 5
7

Output:
6
    * */

    public static long countPairsLessThanX(int[] arr, int x) {
        //Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        long count = 0;
        while (left < right) {
            if (arr[left] + arr[right] < x) {
                count += (right - left);
                left++;
            } else
                right--;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(countPairsLessThanX(arr, x));
    }
}
