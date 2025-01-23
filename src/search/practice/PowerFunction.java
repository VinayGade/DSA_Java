package search.practice;

//Implement Power Function

/*
f(x) = pow(x, n) % d

Find (x^n % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non-negative integer.

Problem Constraints
-10^9 <= x <= 10^9
0 <= n <= 10^9
1 <= d <= 10^9

Example Input
Input 1:
x = 2
n = 3
d = 3

Input 2:
x = 5
n = 2
d = 6

Example Output
Output 1:
2
Output 2:
1
* */

public class PowerFunction {

    static int pow(int x, int n, int d) {

        long a = x;
        long res = 1L;

        while (n > 0) {

            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }

            a *= a;
            a %= d;
            n = n >> 1;
        }
        res = (res + d) % d;
        return (int) res;
    }

    public static void main(String[] args) {
        int x = 5;
        int n = 2;
        int d = 6;
        int result = pow(x,n,d);
        System.out.println(result);
    }
}
