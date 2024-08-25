package array.math;

import java.util.Scanner;

public class DigitSum {

    /*
    Input:
    3
12345
31203
2123

Output:
15
9
8
    * */

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();

            int digitSum = calculateDigitSum(N);

            System.out.println(digitSum);
        }
    }

    static int calculateDigitSum(int N) {

        int sum = 0;
        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }
        return sum;
    }

    //Recursive
    static int digitSum(int N) {
        // Base case: if N is 0, the sum of its digits is 0
        if (N == 0) {
            return 0;
        }
        // Recursive case: sum the last digit with the result of the function called on the remaining number
        return N % 10 + calculateDigitSum(N / 10);
    }
}
