package array.math;

/*

LeetCode 2894. Divisible and Non-divisible Sums Difference

You are given positive integers n and m.

Define two integers as follows:

num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.

Return the integer num1 - num2.

Input: n = 10, m = 3
Output: 19

Input: n = 5, m = 6
Output: 15

Input: n = 5, m = 1
Output: -15
* */
public class DivisibleNonDivisibleSumDiff {

    public static int differenceOfSums(int n, int m) {

        //int sum = 0;
        //int num2 = 0;

        /*
        for(int i = 1; i<=n; i++){
            sum = sum + i;
        }*/

        // sum(1..N) = N * (N+1) / 2;

        int sum = n * (n+1) / 2;  //optimization

        // divisible sum
        /*
        for(int i = 1; i<=n; i++){

            if(i % m == 0){
                num2 = num2 + i;
            }
        }*/

        /* numbers divisible by m:

        x = n/m
        hence num2 = m * x * (x+1) / 2
        hence num1 = sum - num2
        */
        int x = (int) (n/m);

        int num2 =  m * x * (x+1) / 2;

        int num1 = sum - num2;

        return num1 - num2;
    }

    public static void main(String[] args) {

        int n = 10;
        int m = 3;

        int diff = differenceOfSums(n, m);

        System.out.println("num1 - num2 = "+diff);
    }
}
