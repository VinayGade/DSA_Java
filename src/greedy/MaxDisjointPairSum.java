package greedy;

import java.util.Arrays;
import java.util.Scanner;

// CodeChef: Maximize Disjoint Pair Sum

/*
Given an array of N numbers, a pair of numbers is called good if difference between
the two numbers is strictly less than D.

Find out maximum possible sum of all good disjoint pairs that can be made from these numbers.

Sum of X pairs is the sum of all 2*X numbers in the pairs.
* */

/*
Input:
3
3 3
3 5 8
4 3
5 8 10 12
5 3
3 2 8 17 15

Output:
8
22
37

* */

public class MaxDisjointPairSum {

    static long sumPairs(int[] A, int n, int d) {
        long maxSum = 0;

        Arrays.sort(A);
        for (int i = (n-1); i > 0; i--) {
            if ((A[i] - A[i - 1]) < d) {
                maxSum += A[i] + A[i - 1];
                i--;
            }
            /*else
                i -= 1;
            */
        }
        return maxSum;
    }

    /*
    static int sumPairs(int[] a, int n, int d){
        int maxSum = 0;
        int sum = 0;
        int i=1;
        //int j = -1;
        while(i<n){
            int max = Math.max(a[i], a[i-1]);
            int min = Math.min(a[i], a[i-1]);
            if((max - min) < d){
                sum = max + min;
                //j=i;
                maxSum = Math.max(sum, maxSum);
            }
            i++;
        }
        return maxSum;
    }
     */
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (--T >= 0) {

            int N = scan.nextInt();
            int D = scan.nextInt();

            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = scan.nextInt();
            }

            long sum = sumPairs(A, N, D);
            System.out.println(sum);
        }
    }
}
