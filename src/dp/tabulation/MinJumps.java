package dp.tabulation;

import java.util.Scanner;

/*
Dynamic Programming - Minimum Jumps
Array A of size N
On standing at the index i (1 <= i <= N)  Chef can make a jump of length less than or equal to Ai

If Chef starts from the first index of the array, find the minimum number of jumps
required by Chef to reach the last index of the array.

If it is impossible to reach the last index, print -1

Input:
4
4
1 1 2 2
4
1 2 0 2
4
2 1 0 2
4
0 2 0 2

Output:
3
2
-1
-1
* */

public class MinJumps {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t--> 0) {

            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++)
                a[i] = scanner.nextInt();

            int count = minJumpsToReachEnd(a, N);
            System.out.println(count);
        }
    }

    public static int minJumpsToReachEnd(int[] array, int size) {

        if (size <= 1)
            return 0;

        if (array[0] == 0)
            return -1;

        int maxReach = array[0];
        int remainingSteps = array[0];
        int jumps = 1;

        for (int i = 1; i < size; i++) {
            if (i == size - 1)
                return jumps;

            maxReach = Math.max(maxReach, i + array[i]);
            remainingSteps--;

            if (remainingSteps == 0) {
                jumps++;
                if (i >= maxReach)
                    return -1;
                remainingSteps = maxReach - i;
            }
        }
        return -1;
    }
}
