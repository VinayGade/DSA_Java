package search.practice;

/*
LeetCode 50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:

-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
n is an integer.
Either x is not zero or n > 0.
-10^4 <= x^n <= 10^4
* */

public class Power {

    // LeetCode 69. Sqrt(x)
    /*
    f(x) = sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to
the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and
since we round it down to the nearest integer, 2 is returned.
    * */

    public int mySqrt(int x) {

        long start = 0;
        long end = x;

        while((start + 1) < end){

            long mid = start + (end - start) / 2;

            if(mid * mid == x)
                return (int) mid;

            else if(mid * mid < x)
                start = mid;

            else
                end = mid;
        }

        if(end * end == x)
            return (int) end;

        else
            return (int) start;
    }

    public int sqrt(int low, int high, int N){

        // If the range is still valid
        if (low <= high) {

            // Find the mid-value of the range
            int mid = (int)(low + high) / 2;

            // Base Case
            if ((mid * mid <= N)
                    && ((mid + 1) * (mid + 1) > N)) {
                return mid;
            }

            // Condition to check if the
            // left search space is useless
            else if (mid * mid < N) {
                return sqrt(mid + 1, high, N);
            }
            else {
                return sqrt(low, mid - 1, N);
            }
        }
        return low;
    }

    public int power(int x, int n){
        if(x == 0)
            return 0;
        else if(n == 0)
            return 1;

        else {
            int pow = power(x, n-1);
            int solution = pow * x;
            return solution;
        }
    }

    // LeetCode 50. Pow(x, n)
    public double myPow(double x, int n) {
        double ans = 1.0;
        long N = n;
        if(N < 0)
            N = -1 * N;
        while(N > 0){
            if(N % 2 == 1){
                ans = ans * x;
                N = N-1;
            }
            else{
                x = x * x;
                N = N / 2;
            }
        }
        if(n < 0)
            ans = (double)(1.0)/(double)(ans);
        return ans;
    }

    public double myPowRecursive(double x, int n) {
        double y;
        if (n == 0)
            return 1;
        y = myPowRecursive(x, n / 2);

        if (n % 2 == 0)
            return y * y;
        else {
            if (n > 0)
                return x * y * y;
            else
                return (y * y) / x;
        }
    }

    public double myPowShift(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return pow;
    }

    // method 1: recursion

    public int powerRecursive(int x, int n){
        if(n==0)
            return 1;
        else if(x==0)
            return 0;
        else
            return powerRecursive(x, n-1);
    }

    //method 2: Divide and Conquer
    public int powerDnC(int x, int n){
        if(n==0)
            return 1;
        else{
            int y = powerDnC(x, n/2);
            if(n%2==0)
                return y*y;
            else
                return x*y*y;
        }
        /*
        else if(n%2==0)
            return powerDnC(x, n/2) * powerDnC(x, n/2);
        else
            return x * powerDnC(x, n/2) * powerDnC(x, n/2);
         */
    }

    //method 3 : Extend the pow function to work for negative n and float x
    static float realPower(float x, int n){

        float y;
        if (n == 0)
            return 1;
        y = realPower(x, n / 2);

        if (n % 2 == 0)
            return y * y;
        else {
            if (n > 0)
                return x * y * y;
            else
                return (y * y) / x;
        }
    }

    //method 4 : using Binary operators:
    static int binaryPower(int x, int n){
        int result = 1;
        while (n > 0) {
            if (n % 2 != 0) // y is odd{
                result = result * x;

            x = x * x;
            n = n >> 1;
            // y=y/2;
        }
        return result;
    }

    public int factorial(int n){

        if( n == 0 || n == 1 )
            return 1;
        else
            return n * factorial(n-1);
    }

    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        else return n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2));
    }


    long floorSqrt(long n) {
        long sqroot = sqrt(0, n, n);
        return sqroot;
    }

    public long sqrt(long low, long high, long N){

        // If the range is still valid
        if (low <= high) {

            // Find the mid-value of the range
            long mid = (low + high) / 2;

            // Base Case
            if ((mid * mid <= N)
                    && ((mid + 1) * (mid + 1) > N)) {
                return mid;
            }

            // Condition to check if the
            // left search space is useless
            else if (mid * mid < N) {
                return sqrt(mid + 1, high, N);
            }
            else {
                return sqrt(low, mid - 1, N);
            }
        }
        return low;
    }

    public static void main(String[] args) {

        Power p = new Power();

        // factorial
        System.out.println("Factorial ="+p.factorial(5));

        // power
        System.out.println("Power ="+p.power(2, 5));

        // power iterative search
        System.out.println("Power ="+p.power(2, 8));

        // power recursive
        System.out.println("Power ="+p.myPowRecursive(10, 6));

        // power shift
        System.out.println("Power ="+p.myPowShift(4.0d, 3));

        // square root
        Power sqrt = new Power();
        System.out.println("Square root ="+ sqrt.mySqrt(25));

        System.out.println("Square root ="+ sqrt.floorSqrt(25L));
    }
}
