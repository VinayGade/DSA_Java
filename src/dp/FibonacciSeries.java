package dp;

import java.util.Arrays;

public class FibonacciSeries {

    /*
    *  Thumb Rule :
    *
    *   Those who do not remember the past are condemned to repeat it.
    *
    *   1. Optimal Substructure :
    *       If we can write a recurrence relation, then a problem is said to have optimal substructure.
    *
    *   2. Overlapping sub-problems :
    *       If our sub-problem repeat, then a problem is said to have  Overlapping sub-problems.
    *
    *       (eg. factorial, fibonacci)
    *
    *       2 Ways :: (**) Memoization ( Top-Down )   |   Tabulation ( Bottom-Up )
    *
    *       A. Memoization : A Lookup Table is maintained and checked be4 computation of any state. Recursion
    *
    *       B. Tabulation : Solution is built from base. Iterative process
    * */

    public int fibonacciMemoization(int n){

        final int MAX = 200;
        int[] fibonacci = new int[MAX];
        //Arrays.fill(fibonacci, -1);

        if(n < 2)    //if(n == 0 || n == 1)
            return n;

        if(fibonacci[n] != 0)
            return fibonacci[n];

        fibonacci[n] = fibonacciMemoization(n-2) + fibonacciMemoization(n-1) ;

        return fibonacci[n];
    }

    public int fibonacciRecursive(int n) {
        if (n < 2)
            return n;

        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }

    public static void main(String[] args) {
        int n = 25;

        System.out.println("\nFibonacci Series Memoization (Top-Down) approach :");

        System.out.println("\nDispalay fibonacci Series first " + n +"th term :");

        FibonacciSeries topDownSeries = new FibonacciSeries();
        int result = topDownSeries.fibonacciMemoization(n);
        System.out.print(" "+result);
    }
}
