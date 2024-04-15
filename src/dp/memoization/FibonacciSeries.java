package dp.memoization;

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

    //Function to find the nth fibonacci number using bottom-up approach (tabulation).
    public long findNthFibonacci(int number)
    {
        if(number<=1)
            return number;

        long prev2=0;
        long prev1=1;

        for(int i=2;i<=number;i++){
            long curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;

        }
        return prev1;
    }

    //Function to find the nth fibonacci number using top-down approach.
    public long findNthFibonacciMemoization(int number, long[] fibo)
    {
        //base case for recursion.
        if(fibo[number]>0)
            return fibo[number];

        //making recursive calls for previous two values in dp.
        fibo[number] = findNthFibonacciMemoization(number-1, fibo) +
                findNthFibonacciMemoization(number-2, fibo);

        //returning the nth fibonacci number.
        return fibo[number];
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

        long nthFibonacci = topDownSeries.findNthFibonacci(n);
        System.out.print("result= "+result);

        System.out.print("nthFibonacci= "+nthFibonacci);
    }
}
